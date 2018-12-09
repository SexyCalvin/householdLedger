//this is a class about generating excel file, and reading
import java.io.*;
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
			}
		}
		
		row = sheet2.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("loglog");
		cell = row.createCell(1);
		cell.setCellValue("pwdpwd");
		
		try {
            File xlsFile = new File("D:/DataExcel.xls");
            FileOutputStream fileOut = new FileOutputStream(xlsFile);
            xlsWb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public String accountGet(int a) throws IOException {
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
	
	public void dataReading() {
		
	}
	public void dataEditing() {
		
	}
}