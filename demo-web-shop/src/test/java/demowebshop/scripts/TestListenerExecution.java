package demowebshop.scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import demowebshop.baseclass.BaseClass;

/**
 * @author ANU
 */
@Listeners(demowebshop.listenerimplementation.ListenerClass.class)
public class TestListenerExecution extends BaseClass{
	
	@Test//(retryAnalyzer = demowebshop.listenerimplementation.RetryListener.class)
	public void ListenerTest()
	{
		//Assert.fail();
		Reporter.log(driver.getTitle(),true);
	}

}
