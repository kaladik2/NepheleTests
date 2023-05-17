# Automation Script for Nephele

Documentation
-------------
* [Installation](doc/installation.md)


Submit paired FASTQ files for 16S Amplicon Data - Framework Architecture

Submit paired FASTQ files for 16S Amplicon Data
	
	|_src/test/java
	|	|_CucumberOptions
	|	|   |_TestRunner_testng.java
	|	|_features
	|	|   |_Quality Check and 16S Amplicon Data (Mothur, QIIME, DADA2).feature
	|	|_pageObjects
	|       |   |-datauploadpages.java
	|       |   |-gmailloginandInboxpage.java
	|       |   |-loginpage.java
	|       |   |-nepheleHomepage.java
	|       |   |-PageObjectManager.java
	|       |   |-pipelineselectionpage.java
	|       |   |-preprocess_StartjobPage.java
	|       |   |-selectdatatypepage.java
	|       |   |-succesfulsubmissionpage.java
	|       |   |-validateandsubmitpage.java
	|	|_StepDefinitions
	|       |   |-Hooks.java
	|       |   |QC_Check_16s_Amplicon_data_Paired.java
	|	|_Utilities
	|       |   |-getprop.java
	|       |   |sendemail.java
	|       |   |TestBase.java
	|       |   |TestContextSetUp.java
	|_src/test/resources
	|	|_Images(Failed Test cases Screenshots)
	|	|_TestDataFiles(FASTQ and Mapping Files)
	|	|_extent.properties ( for Extent Reporting)
	|	|_Global.properties


src/test/resources/features - all the cucumber features files (files .feature ext) goes here.
src/test/java/userStepDefinition - step defintion under this package for feature steps.

Running test
--------------

Go to your project directory from terminal and hit following commands
* `mvn test (defualt will run on local firefox browser)`
* `mvn test "-Dbrowser=chrome" (to use any other browser)`
* `mvn test "-Dcloud_config=saucelab_windows_chrome52" (to run test on cloud test platforms)`
