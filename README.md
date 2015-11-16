# SNP Data Model

## Building the snpdatamodel

Make any configuration adjustments before running the Install

	host:/path/to/snpdatamodel => cp Configuration.default Configuration
	host:/path/to/snpdatamodel => ./Install
	
Once the install has completed there will be a new file in the "dist" directory called snpdatamodel.jar that is a self contained jar that has all the files needed for the models.

### Dependencies - Developers note for updating

Dependencies are handled automatically via maven and the pom.xml file inside of eclipse. Dependencies can be upgraded by changing the version required in the pom.xml file, then running following commands to update the lib directory:

	host:/path/to/snpdatamodel => rm -fr lib/*.jar
	host:/path/to/snpdatamodel => mvn dependency:copy-dependencies -DoutputDirectory=lib
	host:/path/to/snpdatamodel => git add -u lib

