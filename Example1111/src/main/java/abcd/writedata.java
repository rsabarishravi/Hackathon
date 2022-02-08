package abcd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class writedata
{
	static int k=0;
	static XSSFWorkbook workbook=new XSSFWorkbook();
	static XSSFSheet sheet=workbook.createSheet("output");

public static void writeExcel(String result) throws IOException {
	//int k=0;
        sheet.createRow(k++).createCell(0).setCellValue(result);
        sheet.autoSizeColumn(0);
        
     //   Cell c0=r0.createCell(0);
     //   c0.setCellValue(result);
        File f=new File("E:\\github Hackathon\\Hackathon\\Example1111\\Excel\\output new.xlsx");
        FileOutputStream fos=new FileOutputStream(f);
        workbook.write(fos);
        //fos.close();
        //workbook.close();
}
}