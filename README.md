When you package and upload this code to create your Lambda function, you specify the <translate.TranslationStreamHandler> method reference as the handler.

- No onSessionStarted() in ASK v2.0

- Building the .jar
With our skill code complete, we are ready to build our skill project. To prepare the skill for upload to AWS Lambda, we'll need to produce a JAR file that contains the skill plus all necessary dependencies. To do so, open a terminal and navigate to your Maven project's top level directory that contains pom.xml, and run the following command:

mvn org.apache.maven.plugins:maven-assembly-plugin:2.6:assembly -DdescriptorId=jar-with-dependencies package

This command produces a <my_project_name>.<my_project_version>-jar-with-dependencies.jar file in the target directory.