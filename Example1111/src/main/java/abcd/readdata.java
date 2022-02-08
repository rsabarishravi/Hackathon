package abcd;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readdata {
	 static int j=0;
	// public static String [] arr=new String[5];
		public static String readingExcel() throws InvalidFormatException, IOException
		{
		File file=new File("E:\\github Hackathon\\Hackathon\\Example1111\\Excel\\input.xlsx");
		//FileInputStream fis = new FileInputStream("D:\\Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String c=String.valueOf(sheet.getRow(j++).getCell(0));
		//for(int i=0;i<arr.length;i++)
		//{
			//arr[i]=String.valueOf(sheet.getRow(i).getCell(0)); 
			//System.out.println(arr[i]);
		//}
		return c;
		}
}
