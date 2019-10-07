package translate;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import translate.exceptions.AudioConversionException;
import translate.exceptions.AudioPlaybackException;
import translate.exceptions.DestinationLanguageMissingException;
import translate.exceptions.OriginalStringAndDestinationLanguageMissingException;
import translate.exceptions.OriginalStringMissingException;
import translate.exceptions.PlaybackNotAvailableException;
import translate.exceptions.ProfanityException;
import translate.exceptions.UnsupportedSpeakLanguageException;
import translate.exceptions.UnsupportedTextLanguageException;

public class Translation {

	private String originalString = "";			//initial word or sentence to translate
	private String destinationLanguage = "";	//the language the string will be translated to
	private String languageCode = "";			//supported speak languages
	private String destinationString = "";		//the translated string
	private URL audioURL;						//the audio stream URL
	private int duration;						//length of the audio stream
	private String streamText = "";				//audio stream string for ssml response
	
	//no-args constructor (main translation object)
		Translation() {
			
		}
	
	//constructor with originalString and destinationLanguage parameters (direct translation object)
		Translation (String originalString, String destinationLanguage) {
			this.setOriginalString(originalString);
			this.setDestinationLanguage(destinationLanguage);
		}
	
	public String getOriginalString() {
		return this.originalString;
	}
	
	public void setOriginalString(String newOriginalString) {
		this.originalString = newOriginalString;
	}
	
	public String getDestinationLanguage() {
		return this.destinationLanguage;
	}
	
	public void setDestinationLanguage(String newDestinationLanguage) {
		this.destinationLanguage = newDestinationLanguage;
		this.setLanguageCode(this.destinationLanguage);
	}
	
	public String getLanguageCode() {
		return this.languageCode;
	}
	
	public void setLanguageCode(String destinationLanguage) {
		this.languageCode = this.getLanguageCode(destinationLanguage);
	}
	
	public String getDestinationString() {
		return this.destinationString;
	}
	
	/*setDestinationString() method retrieves the translation in text format
	 *must set the originalString and the destinationLanguage before calling this method
	 */
		public void setDestinationString() throws OriginalStringAndDestinationLanguageMissingException, DestinationLanguageMissingException, OriginalStringMissingException, 
		 		UnsupportedTextLanguageException, AudioConversionException, ProfanityException, IOException, Exception {
			if (this.getDestinationLanguage().equals("") && this.getOriginalString().equals("")) {
				System.out.println("no destinationLanguage set & no originalString set");
				throw new OriginalStringAndDestinationLanguageMissingException();
			}
			if (this.getDestinationLanguage().equals("")) {
	    		System.out.println("no destinationLanguage set");
	    		throw new DestinationLanguageMissingException();
	    	}
			if (this.getOriginalString().equals("")) {
				System.out.println("no originalString set");
				throw new OriginalStringMissingException();
			}
			if (this.getLanguageCode().equals("")) {
				System.out.println("no languageCode set");
	    		throw new UnsupportedTextLanguageException();
	    	}
			
			//language is supported by text
	    	if (!this.getOriginalString().equals("") && !this.getLanguageCode().equals("")) {
	    		try {
		    		String token = this.getToken();		//get token each time, because it expires
		    		
		    		//log the originalString and destinationLanguage to be processed
		    		System.out.println("setDestinationString(): setting '" + this.getOriginalString() + "' to " + this.getDestinationLanguage() + " (" + this.getLanguageCode() + ")");
		    		
		    		//MS Translator API request
					String FormattedDestinationString = this.getTranslationJSON(token, this.getOriginalString(), this.getLanguageCode());	
					
					//parse to string
					this.destinationString = this.JSONToString(FormattedDestinationString);
	    		} catch (ProfanityException Pe) {
	    			System.out.println("ProfanityException in setDestinationString()");
	    			throw new ProfanityException();
	    		} catch (IOException IOe) {
	    			System.out.println("IOException in setDestinationString()");
	    			throw new AudioConversionException();
	    		} catch (Exception e) {
	    			System.out.println("Exception in setDestinationString()");
	    			throw new AudioConversionException();
	    		}
	    	}
		}
	
	public URL getAudioURL() {
		return this.audioURL;
	}
	
	/*setDestinationAudio() retrieves the URL for the audio translation
	 *must call setDestinationString method before
	 */
		public void setAudioURL() throws PlaybackNotAvailableException, UnsupportedSpeakLanguageException, IOException, Exception {
			if (this.getDestinationString().equals("")) {
				System.out.println("no destinationString set");
				throw new Exception();
			}
			if (this.IsSupportedAudioLanguage(this.getDestinationLanguage()) == false) {
				throw new UnsupportedSpeakLanguageException();
			}
			if (this.destinationString.length() > 3 && TranslationStreamHandler.isEntitledProduct == false) {
				System.out.println("inside if statement length > 3, go buy the in-skill product");
				throw new PlaybackNotAvailableException();
			}
			
			//language is supported by speech
	    	if (!this.getDestinationString().equals("") && this.IsSupportedAudioLanguage(this.getDestinationLanguage()) == true) {
	    		String token = this.getToken();		//get token each time, because it expires
	    		this.audioURL = this.getSpeakLink(token, this.getDestinationString(), this.getLanguageCode());
	    	}
	    }
	
	public int getDuration() {
		return this.duration;
	}
	
	/*duration must stay under 90s to be compatible with ssml response in Alexa
	 *jaudiotagger library jar
	 */
		public void setDuration(String directory) throws AudioConversionException {
			try {
				AudioFile audioFile = AudioFileIO.read(new File(directory));
				this.duration = audioFile.getAudioHeader().getTrackLength();
			} catch (Exception e) {
				System.out.println("Error reading the length the of audio file: " + e.getMessage());
				throw new AudioConversionException();
			}
		}
	
	public String getStreamText() {
		return this.streamText;
	}
	
	public void setStreamText(String newStreamText) {
		this.streamText = newStreamText;
	}
	
	/**Primary method for translation logic**/
	@SuppressWarnings("deprecation")	//AmazonS3 object 
	/*convert destinationString to audio format
	 *audio file in S3
	 */
		public String ConvertAudio(String word, String language) throws UnsupportedSpeakLanguageException, AudioConversionException, AudioPlaybackException,
				IOException, Exception {
			//custom error exceptions:
			//UnsupportedSpeakLanguageException: "Sorry, I don't support that language. Please, say another language. Say 'translate to' followed by the language that you wish to translate in. Or, visit your Alexa app and take a look at the card. You will see your word in text, translated in the language that you requested."
			//AudioConversionException: "Something went terribly wrong when translating the word."
			//AudioPlaybackException: "Sorry, I can't playback your translation. Please visit your Alexa app and take a look at the card. You will see your word in text, translated in the language that you requested."
		
			/*string variable names*/
			String originalFileName = "original";
			String outputFileName = "output";
			//directory variable in Lambda
			String directory = "/tmp";
	    	String str = "";	//command line 
	    	String s;	//command variable
	        Process p;	//command variable
	        //ffmpeg parameters in S3
	        String ffmpegBucketName = "ffmpeg-converter";
	        String ffmpegKey = "ffmpegLinuxFilex64.3";	//64.3
	        //setting up parameters in S3
	        String bucketName = "translation-skill";	//provide existent bucket name
	        
	        //create a random key to avoid another session reading it
	        int randomKeyId = (int) (Math.random() * 1000000);
	        String key = "TranslatedAudioFile" + String.valueOf(randomKeyId);
	        String path = "";
	        String streamText = "";
	        
	        //check if language is supported & set a URL for the MP3 stream
	  		this.setAudioURL();
	  		
	  		//language is supported
			try {
				//create a directory to store the original streamable audio file
				File originalFile = new File("/tmp/" + originalFileName + ".mp3");
				
				System.out.println("CopyMp3ToFile: start");
				Translation.CopyMp3ToFile(this.getAudioURL(), originalFile);
				System.out.println("CopyMp3ToFile: done");
				System.out.println("MP3 file ready");
			} catch (AudioConversionException ACe) {
	        	System.out.println("error in translating the word: " + ACe.getMessage());
				throw new AudioConversionException();
			} catch (IOException IOe) {
				System.out.println("error in translating the word: " + IOe.getMessage());
				throw new AudioConversionException();
			} catch (Exception e) {
				System.out.println("error in translating the word: " + e.getMessage());
				throw new AudioConversionException();
			}
			
			//manage the ffmpeg executable (check if it exists already before downloading it)
			if (new File("/tmp/ffmpeg").exists() == false) {
				//ffmpeg file does not exist
	    		System.out.println("FFmpeg file does not already exist: downloading it from S3");
			
	    		//fectch ffmpeg file from S3
		    	URL ffmpegS3Url;
		    	try {
		    		//fetching form S3
		    		ffmpegS3Url = new URL("https://s3.amazonaws.com/" + ffmpegBucketName + "/" + ffmpegKey);
		    		
		    		//create a directory to store the ffmpeg file
			    	File ffmpegFile = new File("/tmp/ffmpeg");
			    	
			    	System.out.println("CopyMp3ToFile: start");
			    	Translation.CopyMp3ToFile(ffmpegS3Url, ffmpegFile);
			    	System.out.println("CopyMp3ToFile: done");
		    	} catch (AmazonServiceException e) {
		            System.out.println("AmazonServiceException in S3: " + e.getMessage());
		            throw new AudioConversionException();
		        } catch (AmazonClientException e) {
		        	System.out.println("AmazonClientException in S3: " + e.getMessage());
		            throw new AudioConversionException();
		        } catch (AudioConversionException ACe) {
		        	System.out.println("error in translating the word: " + ACe.getMessage());
					throw new AudioConversionException();
		        } catch (IOException IOe) {
					System.out.println("error in translating the word: " + IOe.getMessage());
					throw new AudioConversionException();
		        } catch (Exception e) {
					System.out.println("error when fetching the ffmpeg file from S3: " + e.getMessage());
					throw new AudioConversionException();
		        }
			}
			
			System.out.println("testing if ffmpeg file exists: " + new File("/tmp/ffmpeg").exists());
			
			//change chmod of ffmpeg file
	    	directory = "/tmp/ffmpeg";
	        str = "chmod 777 " + directory;
	        
	        System.out.println("running chmod");
	        try {
	            p = Runtime.getRuntime().exec(str);
	            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
	            while ((s = br.readLine()) != null)
	                System.out.println(s);
	            p.waitFor();
	            System.out.println ("\n ---chmod exit: " + p.exitValue());
	            p.destroy();
	        } catch (Exception e) {
	        	System.out.println("error running chmod: " + e.getMessage());
	        	throw new AudioConversionException();
	        }
	        
	        //running ffmpeg conversion
		    directory = "/tmp/" + outputFileName + ".mp3";
		    
		    str = "/tmp/ffmpeg -i /tmp/" + originalFileName + ".mp3 -ac 2 -codec:a libmp3lame -b:a 48k -ar 16000 -af volume=5 -f mp3 " + directory + " -y";
		    
		    System.out.println("running ffmpeg command");
		    try {
	            p = Runtime.getRuntime().exec(str);
	            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
	            while ((s = br.readLine()) != null)
	                System.out.println(s);
	            p.waitFor();
	            System.out.println ("\n --- ffmpeg exit: " + p.exitValue());
	            
	            //verify output
	            if (p.exitValue() != 0 || new File(directory).exists() == false) {
	            	p.destroy();
	            	throw new AudioConversionException();
	            }
	            p.destroy();
	        } catch (Exception e) {
	        	System.out.println("error running ffmpeg: " + e.getMessage());
	        	throw new AudioConversionException();
	        }
		    
		    //verify output
	        System.out.println(directory + " file exists: " + new File(directory).exists());
	        
	        //verify length of destination audio file (< 90s)
	        this.setDuration(directory);
			System.out.println("the length of " + directory + " is: " + this.getDuration() + "s");
			
			if (this.getDuration() > 90) {
				System.out.println("error will be caused by Alexa, audio file exeeds 90s");
				throw new AudioPlaybackException();
			}
			
			//starting S3 upload and download
	        AmazonS3 s3;
			try {
				System.out.println("instantiating AmazonS3 object");
				s3 = new AmazonS3Client();
				System.out.println("AmazonS3 object instantiated");
			} catch (AmazonServiceException e) {
	            System.out.println("AmazonServiceException in S3: " + e.getMessage());
	            throw new AudioConversionException();
	        } catch (AmazonClientException e) {
	        	System.out.println("AmazonClientException in S3: " + e.getMessage());
	            throw new AudioConversionException();
			} catch (Exception e) {
				System.out.println("error when instantiating the AmazonS3 object");
				throw new AudioConversionException();
			}
			
			try {
		        Region us = Region.getRegion(Regions.US_EAST_1);
		        s3.setRegion(us);
	        } catch (Exception e) {
	        	//region could not be set
	        	System.out.println("region could not be set: " + e.getMessage());
	        	throw new AudioConversionException();
	        }
			
			//allocate new string values to variables for S3 upload & download
	        directory = "/tmp/" + outputFileName + ".mp3";
	        path = directory;
	        
	        try {
	    		//put translated file in S3
	        	s3.putObject(new PutObjectRequest(bucketName, key, new File(path)));
	        	System.out.println("success in uploading " + path + " to " + bucketName + " bucket with the " + key + " key");
	        	
	        	//make the output file "public" in S3
	    		s3.setObjectAcl(bucketName, key, CannedAccessControlList.PublicRead);
	        } catch (AmazonServiceException e) {
	            System.out.println("AmazonServiceException in S3: " + e.getMessage());
	            throw new AudioConversionException();
	        } catch (AmazonClientException e) {
	        	System.out.println("AmazonClientException in S3: " + e.getMessage());
	            throw new AudioConversionException();
	        }
	        
	        //conversion successful
	        //format ssml output text
	        streamText = word + " " + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 95) + " " + capFirstLetter(language) + " " + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 96) + " " + "<audio src='https://s3.amazonaws.com/" + bucketName +"/" + key +"'/>";
	        this.setStreamText(streamText);
	        return streamText;   
		}
		
	/**Secondary methods**/
	/*MS Translator API
     *expiring token
	 */
		public String getToken() throws IOException, Exception {
			try {
				//request parameters
				String accessKey = "821b1791292343bfad4047b9cdc4a290";
				URL url = new URL("https://api.cognitive.microsoft.com/sts/v1.0/issueToken");
				
				//connection
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			    connection.setRequestMethod("POST");
			    connection.setRequestProperty("Ocp-Apim-Subscription-Key", accessKey);
			    
			    connection.setUseCaches(false);
			    connection.setDoOutput(true);
			    
			    //read data
			    DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.flush();
				wr.close();
		
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
		
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				in.close();
				
				return response.toString();
			} catch (Exception e) {
				System.out.println("exception in getToken()");
				throw new Exception();
			}
		}
	
	/*MS Translator API
	 *translate() 
	 */
		public String getTranslationXML(String token, String word, String language) throws IOException, Exception {
			String fromLanguage = TranslationStreamHandler.SESSION_LOCALE.substring(0, 2);
		
			try {
				StringBuilder result = new StringBuilder();
				
				//url request 
				URL url = new URL("https://api.microsofttranslator.com/v2/http.svc/Translate?"
				+ "appid=" + URLEncoder.encode("Bearer " + token, "UTF-8")
				+ "&from=" + URLEncoder.encode(fromLanguage, "UTF-8")
				+ "&text=" + URLEncoder.encode(word, "UTF-8") 
				+ "&to=" + URLEncoder.encode(language, "UTF-8"));
				
				System.out.println("url to MS Translator: " + url);
			    
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
			    conn.setRequestMethod("GET");
			      
			    //putting response (xml format) in a string
			    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			    String line;
			    while ((line = rd.readLine()) != null) {
			       result.append(line);
			    }
			    rd.close();
			      
			    return result.toString();
			} catch (Exception e) {
				System.out.println("exception in getTranslationXML()");
				throw new Exception();
			}
		}
	
	/*MS Translator API v3.0
	 *translate() 
	 */
		public String getTranslationJSON(String token, String word, String language) throws Exception {
			String fromLanguage = TranslationStreamHandler.SESSION_LOCALE.substring(0, 2);
		
			try {
				StringBuilder result = new StringBuilder();
				
				//url request 
				URL url = new URL("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0"
				+ "&from=" + URLEncoder.encode(fromLanguage, "UTF-8")
				+ "&to=" + URLEncoder.encode(language, "UTF-8")
				+ "&profanityAction=Marked&ProfanityMarker=Tag");
				
				System.out.println("url to MS Translator: " + url);
			    
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
				conn.setRequestProperty("Ocp-Apim-Subscription-Key", "821b1791292343bfad4047b9cdc4a290");
		        conn.setRequestProperty("Content-Type", "application/json");
		        conn.setRequestProperty("Accept", "application/json");
		        conn.setDoOutput(true);
		        conn.setDoInput(true);
		        conn.setRequestMethod("POST");
			      
		        String wordByte = "[{'Text':'" + word + "'}]";
		        byte[] outputBytes = wordByte.getBytes(StandardCharsets.UTF_8);
		        OutputStream os = conn.getOutputStream();
		        os.write(outputBytes);
	
		        os.close();
		        
		        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			    String line;
			    while ((line = rd.readLine()) != null) {
			       result.append(line);
			    }
			    rd.close();
			      
			    return result.toString();
			} catch (Exception e) {
				System.out.println("exception in getTranslationJSON()");
				throw new Exception();
			}
		}
	
	/*parsing XML to string
	 *stored in destinationString
	 */
		public String XMLToString(String XMLString) throws IOException, Exception {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = null;
			
			try {
			    db = dbf.newDocumentBuilder();
			    InputSource is = new InputSource();
			    is.setCharacterStream(new StringReader(XMLString));
			    try {
			        Document doc = db.parse(is);
			        String message = doc.getDocumentElement().getTextContent();
			        return message;
			    } catch (SAXException e) {
			        //handle SAXException
			    	System.out.println("error in XMLToString method (SAXException): " + e.getMessage());
			    	throw new Exception();
			    } catch (IOException e) {
			        //handle IOException
			    	System.out.println("error in XMLToString method (IOException): " + e.getMessage());
			    	throw new IOException();
			    }
			} catch (ParserConfigurationException ex) {
			    //handle ParserConfigurationException
				System.out.println("general error in XMLToString method (ParserConfigurationException): " + ex.getMessage());
				throw new Exception();
			}
		}
	
	/*parsing JSON to string
	 *stored in destinationString
	 */
		public String JSONToString(String JSONString) throws ProfanityException, Exception {
			try {
				String text = JSONString.substring(25);
				String[] stringArray = text.split("\"");
				if (stringArray[1].contains("<profanity>")) {
					System.out.println("profanity has been detected");
					throw new ProfanityException();
				} else {
					return stringArray[1];
				}
			} catch (ProfanityException Pe) {
				//handle ProfanityException
				System.out.println("error in JSONToString method: " + Pe.getMessage());
				throw new ProfanityException();
			} catch (Exception e) {
			   //handle Exception
		    	System.out.println("error in JSONToString method: " + e.getMessage());
		    	throw new Exception();
		    }
		}
	
	//url request
		public URL getSpeakLink(String token, String word, String language) throws IOException {
			URL url = new URL("https://api.microsofttranslator.com/v2/http.svc/Speak?appid="
					+ URLEncoder.encode("Bearer " + token, "UTF-8") 
					+ "&text=" + URLEncoder.encode(word, "UTF-8") 
					+ "&language=" + URLEncoder.encode(language, "UTF-8")
					+ "&format=" + URLEncoder.encode("audio/mp3", "UTF-8"));
		      
		    return url;
		}
	
	//used in convertAudio()
		public static void CopyMp3ToFile(URL url, File file) throws AudioConversionException, IOException {
			try {
				FileUtils.copyURLToFile(url, file);
			} catch (Exception e) {
				throw new AudioConversionException();
			}
		}
	
	//returns the language code (for URL parameter); Microsoft Translator API supports these languages
		public String getLanguageCode(String language) {
			return LocaleLanguageSettings.getLanguageCodeBasedLocale(language, TranslationStreamHandler.SESSION_LOCALE);
		}
	
	//checks if the language is supported {for universally known languages: list of MS's languages (in general MS, not the Translator API)}
		public Boolean IsSupportedUniversalLanguage(String language) {	
			return LocaleLanguageSettings.IsSupportedUniversalLanguageBasedLocale(language, TranslationStreamHandler.SESSION_LOCALE);
		}

	//checks if the language is supported for audio streams; speak()
		public Boolean IsSupportedAudioLanguage(String language) {
			//@SuppressWarnings("unused")
			return LocaleLanguageSettings.IsSupportedAudioLanguageBasedLocale(language, TranslationStreamHandler.SESSION_LOCALE);
		}
	
	//languages (supported by Alexa's GUI - cards)
		public Boolean IsSupportedCardLanguage(String language) {
			//@SuppressWarnings("unused")
			return LocaleLanguageSettings.IsSupportedCardLanguageBasedLocale(language, TranslationStreamHandler.SESSION_LOCALE);
		}
	
	//call setDestinationString first
		public String toString() {
			return "'" + this.getOriginalString() + "' " + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 95) + " " + capFirstLetter(this.getDestinationLanguage()) + " " + LocaleLanguageSettings.getLanguageString(TranslationStreamHandler.SESSION_LOCALE, 96) + ": '" + this.getDestinationString().toLowerCase() + "'";
		}

	public String capFirstLetter(String string) {
		String str = string;
		str.substring(0, 1).toUpperCase();
		return str;
	}
		
}
