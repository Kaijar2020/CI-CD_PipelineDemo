package datadriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDatainSoecificRowCell {

    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\Book2.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        //create sheet
        XSSFSheet sheet = workbook.createSheet("Data1");

        XSSFRow row= sheet.createRow(3);
        XSSFCell cell = row.createCell(4);
        cell.setCellValue("Hey bro");

        workbook.write(file); //attach workbook to the file.
        workbook.close();
        file.close();
    }
}
