//this is a class about generating excel file, and reading
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataExchange {
	public void GeneratingExcel() {
		Workbook xlsWb = new HSSFWorkbook();
		
		Sheet sheet1 = xlsWb.createSheet("firstSheet");
		sheet1.setColumnWidth(0, 1000);
		sheet1.setColumnWidth(1, 1000);
		CellStyle cellStyle = xlsWb.createCellStyle();
		
		Row row = null;
		Cell cell = null;
		
		for(int i=0; i<12; i++) {
			for(int j=0; j<31; j++) {
				row = sheet1.createRow(31*i+j); //줄 설정
				cell = row.createCell(1); //칸 설정
				cell.setCellValue(j+1); //값 넣기
			}
		}
		
		
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
}