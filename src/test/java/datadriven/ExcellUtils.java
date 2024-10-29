package datadriven;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcellUtils {

    public static FileInputStream fileIn;
    public static FileOutputStream fileOut;
    public static XSSFWorkbook workBook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    public static int getRowCount(String xlfile,String xlsheet) throws IOException {
        fileIn = new FileInputStream(xlfile);
        workBook = new XSSFWorkbook(fileIn);
        sheet = workBook.getSheet(xlsheet);
        int rowCount = sheet.getLastRowNum();
        workBook.close();
        fileIn.close();
        return rowCount;
    }

    public static int getCellCount(String xlfile,String xlsheet, int rowNum) throws IOException {
        fileIn = new FileInputStream(xlfile);
        workBook = new XSSFWorkbook(fileIn);
        sheet = workBook.getSheet(xlsheet);
        row = sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        workBook.close();
        fileIn.close();
        return cellCount;
    }

    public static String getCellData(String xlfile,String xlsheet, int rowNum, int colmNum) throws IOException {
        fileIn = new FileInputStream(xlfile);
        workBook = new XSSFWorkbook(fileIn);
        sheet = workBook.getSheet(xlsheet);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colmNum);
        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        }
        catch(Exception e){
            data= "";
        }
        workBook.close();
        fileIn.close();
        return data;
    }
}
