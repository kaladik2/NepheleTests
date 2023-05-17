package StepDefinitions;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.imageio.ImageIO;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.TakesScreenshot;
import Utilities.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.datauploadpages;
import pageObjects.gmailloginandInboxpage;
import pageObjects.loginpage;
import pageObjects.nepheleHomepage;
import pageObjects.pipelineselectionpage;
import pageObjects.preprocess_StartjobPage;
import pageObjects.selectdatatypepage;
import pageObjects.succesfulsubmissionpage;
import pageObjects.validateandsubmitpage;
import Utilities.sendemail;
import Utilities.getprop;

public class QC_Check_16s_Amplicon_data_Paired {

	TestContextSetUp testsetup; 

	public QC_Check_16s_Amplicon_data_Paired(TestContextSetUp testsetup1) {
		this.testsetup=testsetup1;}

	@Given("Nephele webisite is launched succesfully in any browser")
	public void nephele_webisite_is_launched_succesfully_in_any_browser() throws IOException, InterruptedException {
		nepheleHomepage hp=testsetup.pageobjectmanager.homepage(testsetup.testbase.webmanager());
		hp.validatethepageislaunched();}

	@And("to Start any Job enter registered email address")
	public void to_start_any_job_enter_registered_email_address() throws IOException, InterruptedException {
		preprocess_StartjobPage startjob=testsetup.pageobjectmanager.preprocessstartjob(testsetup.testbase.webmanager());
		startjob.clickonpreprocess();
		startjob.clickonstartjob();
		loginpage login=testsetup.pageobjectmanager.login(testsetup.testbase.webmanager());
		login.loginusingregisteredemail();}

	@When("type of data to upload is selected")
	public void type_of_data_to_upload_is_selected() throws IOException, InterruptedException {
		selectdatatypepage data=testsetup.pageobjectmanager.dt(testsetup.testbase.webmanager());
		data.selectdatatype();}

	@And("upload the FASTQ files and mapping file for Paired End FASTQ")
	public void upload_the_fastq_files_and_mapping_file_for_paired_end_fastq() throws IOException, InterruptedException {
		datauploadpages upload=testsetup.pageobjectmanager.upload(testsetup.testbase.webmanager());
		upload.uploadFASTQ_mappingFiles();}

	@And("select the pipeline selection")
	public void select_the_pipeline_selection() throws IOException, InterruptedException {
		pipelineselectionpage pipeline=testsetup.pageobjectmanager.ps(testsetup.testbase.webmanager());
		pipeline.selectpipeline();}

	@And("Submit your Paired End QC job to Nephele")
	public void submit_your_paired_end_qc_job_to_nephele() throws IOException, InterruptedException {
		validateandsubmitpage s=testsetup.pageobjectmanager.submit(testsetup.testbase.webmanager());
		s.validateANDSubmit();}

	@Then("submission success must be displayed") 
	public void submission_success_must_be_displayed() throws IOException, InterruptedException{
		String imageLocation="src/test/resources/Images/submissionSuccess_error"+".png";

		getprop gp=new getprop();
		Properties prop=new Properties();
		prop=gp.get();
		String url=prop.getProperty("testurl");
		succesfulsubmissionpage submission=testsetup.pageobjectmanager.validate(testsetup.testbase.webmanager());
		boolean b=submission.validatemsg();
		if(b==false) {
			String subject="Nephele - Submission Success Message - "+"Not displayed as Expected";
			Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(submission.driver);
			ImageIO.write(screenshot.getImage(),"PNG",new File(imageLocation));
			sendemail email=new sendemail();
			String htmlprev1="<p><b>Hello All,</b></p>";
			String htmlprev2="<p> Submission Success Message id not displayed for   " +url +"</p>";
			String txt = "<a href=\"+url+\">url</a>"; 
			String htmltxt= txt+htmlprev1+htmlprev2+"<table  border= 1  style=\"width:100%\"><tr><th>Test Frequency </th><th>GoCD Pipeline</th><tr><td>Nepehele Pipeline  Tests</td> <td>Nephele_Testing/Tests</td></table><p><b>Screenshot</b></p><table border=1 style=\"width:100%\"><tr><td><img src=\"cid:image\"></td></tr></table><br><p>Thanks,<br>Nepehele Testing Team";
			email.sendemailsnotofications(htmltxt,subject,imageLocation);
			email=null;}
		System.out.println(b);}

	@And("job submission and job completion email must be sent to Registered email address for the job submission")
	public void job_submission_and_job_completion_email_must_be_sent_to_registered_email_address_for_the_job_submission() throws IOException, InterruptedException {
		String imageLocation="src/test/resources/Images/emailNotification_error"+".png";
		getprop gp=new getprop();
		Properties prop=new Properties();
		prop=gp.get();
		String url=prop.getProperty("gmailurl");
		succesfulsubmissionpage submission=testsetup.pageobjectmanager.validate(testsetup.testbase.webmanager());
		String jobid=submission.jobid;
		System.out.println(jobid);

		Thread.sleep(300000);//5 min

		//Thread.sleep(180000);//3 min
		gmailloginandInboxpage gm=testsetup.pageobjectmanager.gmail(testsetup.testbase.webmanager());

		boolean opengmail=gm.gmaillogin(jobid);

		if(opengmail==false) {
			/*String subject="Nephele - Emails are not received within wait Time of 5 minutes in the script - Check bcbbnepheletset@gmail.com inbox manually";
			Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(submission.driver);
			ImageIO.write(screenshot.getImage(),"PNG",new File(imageLocation));
			sendemail email=new sendemail();
			String htmlprev1="<p><b>Hello All,</b></p>";
			String htmlprev2="<p> Emails are not received at    " +url +"</p>"; 
			String txt = "<a href=\"+url+\">url</a>"; 
			String htmltxt= htmlprev1+htmlprev2+txt+"<table  border= 1  style=\"width:100%\"><tr><th>Test Objective </th><th>GitHubActions - workflow </th><tr><td>Submit paired FASTQ files for 16S Amplicon Data ,validate job submisiion and emails received</td> <td>bcbb/NepheleAutomationTests/.github/workflows/RegressionTests.yml </td></table><p><b>Screenshot</b></p><table border=1 style=\"width:100%\"><tr><td><img src=\"cid:image\"></td></tr></table><br><p>Thanks,<br>Nepehele Testing Team";
			email.sendemailsnotofications(htmltxt,subject,imageLocation);
			email=null;*/
		}

		gm.gmaillogin(jobid);

		if(gm.checkemail1==false || gm.checkemail2==false) {
			/*String subject="Nephele - Emails are not received as expected";
			Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(submission.driver);
			ImageIO.write(screenshot.getImage(),"PNG",new File(imageLocation));
			sendemail email=new sendemail();
			String htmlprev1="<p><b>Hello All,</b></p>";
			String htmlprev2="<p> Emails are not received at    " +url +"</p>";
			String txt = "<a href=\"+url+\">url</a>"; 
			String htmltxt= htmlprev1+htmlprev2+txt+"<table  border= 1  style=\"width:100%\"><tr><th>Test Objective </th><th>GitHubActions - workflow </th><tr><td>Submit paired FASTQ files for 16S Amplicon Data ,validate job submisiion and emails received</td> <td>bcbb/NepheleAutomationTests/.github/workflows/RegressionTests.yml</td></table><p><b>Screenshot</b></p><table border=1 style=\"width:100%\"><tr><td><img src=\"cid:image\"></td></tr></table><br><p>Thanks,<br>Nepehele Testing Team";
			email.sendemailsnotofications(htmltxt,subject,imageLocation);
			email=null; */}}}
