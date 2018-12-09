//this is a class about generating excel file, and reading
import java.io.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataExchange {
	public void GeneratingExcel() {
		Workbook xlsWb = new HSSFWorkbook();
		
		Sheet sheet1 = xlsWb.createSheet("Data");
		sheet1.setColumnWidth(0, 1000);
		sheet1.setColumnWidth(1, 1000);
		Sheet sheet2 = xlsWb.createSheet("Accounts");
		sheet2.setColumnWidth(0, 2000);
		sheet2.setColumnWidth(1, 2000);
		CellStyle cellStyle = xlsWb.createCellStyle();
		
		Row row = null;
		Cell cell = null;
		
		for(int i=0; i<12; i++) {
			for(int j=0; j<31; j++) {
				row = sheet1.createRow(31*i+j); //줄 설정
				cell = row.createCell(1); //칸 설정
				cell.setCellValue(j+1); //값 넣기
				cell = row.createCell(0);
				if(j==0) cell.setCellValue(i+1);
				cell = row.createCell(2);
				cell = row.createCell(3);
				cell = row.createCell(4);
			}
		}
		
		row = sheet2.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("loglog"); //아이디설정
		cell = row.createCell(1);
		cell.setCellValue("a"); //비밀번호설정
		
		try {
            File xlsFile = new File("D:/DataExcel.xls");
            FileOutputStream fileOut = new FileOutputStream(xlsFile);
            xlsWb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public String accountGet(int a) throws IOException { //계정정보가져옴
		//try {
			FileInputStream file = new FileInputStream("D:/DataExcel.xls");
			Workbook wb = new HSSFWorkbook(file);
			Sheet sheet2 = wb.getSheet("Accounts");
		/*} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		if(a==0) {
			Row row = sheet2.getRow(0);
			Cell cell = row.getCell(0);
			String value = cell.getStringCellValue() + "";
			return value;
		} else if (a==1) {
			Row row = sheet2.getRow(0);
			Cell cell = row.getCell(1);
			String value = cell.getStringCellValue() + "";
			return value;
		};
		return null;
	}
	
	public String dataReading(int a, int b) throws IOException { //행렬값을가져옴
		FileInputStream file = new FileInputStream("D:/DataExcel.xls");
		Workbook wb = new HSSFWorkbook(file);
		Sheet sheet1 = wb.getSheet("Data");
		
		Row row = sheet1.getRow(a);
		Cell cell = row.getCell(b);
		String value = cell.getStringCellValue() + "";
		return value;
	}
	public void dataEditing(int a, int b, String str) throws EncryptedDocumentException, IOException { //행,렬,값 넣기
		InputStream file = new FileInputStream("D:/DataExcel.xls");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet1 = wb.getSheet("Data");
		Row row = sheet1.getRow(a);
		Cell cell = row.getCell(b);
		if (cell == null) cell = row.createCell(b);
		//cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(str);
		
		FileOutputStream fileOut = new FileOutputStream("D:/DataExcel.xls");
		wb.write(fileOut);
		fileOut.close();
	}
}