package CucumberOptions;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;


 @CucumberOptions(
 	    //specifying the feature File,StepDefinitions and reporting PLUGIN using Extent Report
		features = "src/test/java/features/Quality Check and 16S Amplicon Data (Mothur, QIIME, DADA2).feature",glue="StepDefinitions",
	    plugin= {"pretty","html:target/cucumber.html",
	    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	    		"rerun:target/failedscenarios.txt",
	    		"json:target/cucumber.json"
	    		})

public class TestRunner_testng  extends AbstractTestNGCucumberTests{

	//Run Tests in parallel 
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){ 
		return super.scenarios();}}
 