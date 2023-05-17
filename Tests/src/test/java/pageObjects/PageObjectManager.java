package pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;

public class PageObjectManager {

	RemoteWebDriver driver;
	nepheleHomepage homepage;
	preprocess_StartjobPage preprocessstartjob;
	loginpage login;
	selectdatatypepage dt;
	datauploadpages upload;
	pipelineselectionpage ps;
	validateandsubmitpage submit;
	succesfulsubmissionpage validate;
	gmailloginandInboxpage gmail;

	public PageObjectManager(RemoteWebDriver driver) {
		this.driver=driver;}

	public selectdatatypepage dt(RemoteWebDriver driver) {
		return dt=new selectdatatypepage(driver);}


	public loginpage login(RemoteWebDriver driver) {
		return login=new loginpage(driver);}


	public preprocess_StartjobPage preprocessstartjob(RemoteWebDriver driver) {
		return preprocessstartjob=new preprocess_StartjobPage(driver);}

	public nepheleHomepage homepage(RemoteWebDriver driver) {
		return homepage=new nepheleHomepage(driver);}

	public datauploadpages upload(RemoteWebDriver driver) {
		return upload=new datauploadpages(driver);}

	public pipelineselectionpage ps(RemoteWebDriver driver) {
		return ps=new pipelineselectionpage(driver);}

	public validateandsubmitpage submit(RemoteWebDriver driver) {
		return submit=new validateandsubmitpage(driver);}


	public succesfulsubmissionpage validate(RemoteWebDriver driver) {
		return  validate=new succesfulsubmissionpage (driver);}

	public gmailloginandInboxpage gmail(RemoteWebDriver driver) {
		return  gmail=new  gmailloginandInboxpage(driver);}}
