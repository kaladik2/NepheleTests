Feature: Quality Check and 16S Amplicon Data (Mothur, QIIME, DADA2)

@RegTest
  Scenario: Submit paired FASTQ files for 16S Amplicon Data
    Given Nephele webisite is launched succesfully in any browser
    And to Start any Job enter registered email address 
    When type of data to upload is selected
    And upload the FASTQ files and mapping file for Paired End FASTQ 
    And select the pipeline selection
    And Submit your Paired End QC job to Nephele
    Then submission success must be displayed 
    And job submission and job completion email must be sent to Registered email address for the job submission

 