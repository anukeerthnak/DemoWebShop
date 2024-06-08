package demowebshop.fileutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int generateRandomNumber(int range)
	{
		Random ran=new Random();
		int randomNumber=ran.nextInt(range);
		return randomNumber;
		
	}
	
	public String getSystemDate()
	{
		Date dateObj= new Date();
		String sysDate=dateObj.toString();
		return sysDate.replace(" ", "_").replace(":", "_");
		
	}
	
	public String getSystemDateInFormatDD_MM_YYYY()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date dateObj = new Date();
		String date= sdf.format(dateObj);
		return date;
	}
	
//	public static void main(String[] args) {
//		JavaUtility ju=new JavaUtility();
//		System.out.println(ju.getSystemDate());
//		System.out.println(ju.getSystemDateInFormatDD_MM_YYYY());
//	}
}
