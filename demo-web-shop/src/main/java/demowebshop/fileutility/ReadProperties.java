package demowebshop.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ANU
 */
public class ReadProperties {
	
FileInputStream fis;
	
	public String fetchProperty(String key) 
	{
		
		try {
			fis=new FileInputStream("./src/test/resources/dws.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties pObj= new Properties();
		try {
			pObj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data=pObj.getProperty(key);
		return data;
	}

}
