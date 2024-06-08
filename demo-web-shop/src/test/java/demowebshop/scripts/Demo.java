package demowebshop.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import demowebshop.baseclass.BaseClass;

public class Demo extends BaseClass {
	@Test
	public void demo()
	{
		Reporter.log("Hi",true);
	}

}
