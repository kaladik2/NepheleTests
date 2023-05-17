package pageObjects;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class datauploadpages {

	public RemoteWebDriver driver;
	public datauploadpages (RemoteWebDriver driver) {
		this.driver=driver;} 

	String f1="src/test/resources/N2_16S_example_data/22057_S2_R1_subsample.fastq.gz";
	String f2="src/test/resources/N2_16S_example_data/22057_S2_R2_subsample.fastq.gz";

	String f3="src/test/resources/N2_16S_example_data/22061_S5_R1_subsample.fastq.gz";
	String f4="src/test/resources/N2_16S_example_data/22061_S5_R2_subsample.fastq.gz";

	String f5="src/test/resources/N2_16S_example_data/22145_S14_R1_subsample.fastq.gz";
	String f6="src/test/resources/N2_16S_example_data/22145_S14_R2_subsample.fastq.gz";

	String f7="src/test/resources/N2_16S_example_data/22187_S19_R1_subsample.fastq.gz";
	String f8="src/test/resources/N2_16S_example_data/22187_S19_R2_subsample.fastq.gz";

	String f9="src/test/resources/N2_16S_example_data/22192_S22_R1_subsample.fastq.gz";
	String f10="src/test/resources/N2_16S_example_data/22192_S22_R2_subsample.fastq.gz";

	String f11="src/test/resources/N2_16S_example_data/22349_S26_R1_subsample.fastq.gz";
	String f12="src/test/resources/N2_16S_example_data/22349_S26_R2_subsample.fastq.gz"; 

	String f13="src/test/resources/N2_16S_example_data/22350_S27_R1_subsample.fastq.gz";
	String f14="src/test/resources/N2_16S_example_data/22350_S27_R2_subsample.fastq.gz";	

	String f15="src/test/resources/N2_16S_example_data/22831_S41_R1_subsample.fastq.gz";
	String f16="src/test/resources/N2_16S_example_data/22831_S41_R2_subsample.fastq.gz";

	String f17="src/test/resources/N2_16S_example_data/22833_S45_R1_subsample.fastq.gz";
	String f18="src/test/resources/N2_16S_example_data/22833_S45_R2_subsample.fastq.gz";

	String f19="src/test/resources/N2_16S_example_data/23572_S307_R1_subsample.fastq.gz";
	String f20="src/test/resources/N2_16S_example_data/23572_S307_R2_subsample.fastq.gz";

	String mappingfile="src/test/resources/N2_16S_example_mapping_file.xlsx";
	String mappingfile1="src/test/resources/N2_16S_example_mapping_file1.xlsx";

	By uploadfrommycomputer=By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/form/div/div[1]/button");
	By addfiles=By.xpath("//*[@id=\"dropbox\"]/span/input");
	By startupload=By.xpath("//*[@id=\"fileupload\"]/div[2]/div[1]/button[1]/span");
	By next=By.xpath("//*[@id=\"lnkTarget\"]");
	By choosefiles=By.xpath("//*[@id=\"data_file\"]");
	By upload=By.xpath("//*[@id=\"form_btn\"]");

	public void uploadFASTQ_mappingFiles() throws InterruptedException {
		driver.findElement(uploadfrommycomputer).click();

		/*File fil1=new File(f1); 
    	String s1=fil1.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s1);


    	File fil2=new File(f2); 
    	String s2=fil2.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s2);


    	File fil3=new File(f3); 
    	String s3=fil3.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s3);


    	File fil4=new File(f4); 
    	String s4=fil4.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s4);

    	File fil5=new File(f5); 
    	String s5=fil5.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s5);


    	File fil6=new File(f6); 
    	String s6=fil6.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s6);


    	File fil7=new File(f7); 
    	String s7=fil7.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s7);

    	File fil8=new File(f8); 
    	String s8=fil8.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s8);

    	File fil9=new File(f9); 
    	String s9=fil9.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s9);

    	File fil10=new File(f10); 
    	String s10=fil10.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s10);


    	File fil11=new File(f11); 
    	String s11=fil11.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s11);

    	File fil12=new File(f12); 
    	String s12=fil12.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s12);

    	File fil13=new File(f13); 
    	String s13=fil13.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s13);

    	File fil14=new File(f14); 
    	String s14=fil14.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s14);*/

		/*File fil15=new File(f15); 
		String s15=fil15.getAbsolutePath();*/
		driver.findElement(addfiles).sendKeys(f15);



		/*File fil16=new File(f16); 
		String s16=fil16.getAbsolutePath();*/
		driver.findElement(addfiles).sendKeys(f16);

		/*File fil17=new File(f17); 
		String s17=fil17.getAbsolutePath();*/
		driver.findElement(addfiles).sendKeys(f17);


		/*File fil18=new File(f18); 
		String s18=fil18.getAbsolutePath();*/
		driver.findElement(addfiles).sendKeys(f18);


		/*	File fil19=new File(f19); 
    	String s19=fil19.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s19);

    	File fil20=new File(f20); 
    	String s20=fil20.getAbsolutePath();
    	driver.findElement(addfiles).sendKeys(s20);*/


		driver.findElement(startupload).click();
		//Thread.sleep(600000);  

		Thread.sleep(30000);

		driver.findElement(next).click();

		/*File filemappingfiles=new File(mappingfile1); 
		String mapf=filemappingfiles.getAbsolutePath();*/
		driver.findElement(choosefiles).sendKeys(mappingfile1);

		driver.findElement(upload).click(); }}
