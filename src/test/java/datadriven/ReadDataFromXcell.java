package datadriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDataFromXcell {

    public static void main(String[] args) throws IOException {

        //open file in reading mode.
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Book1.xlsx");

        //Extract workbook.
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get the sheet from the workbook.
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //Number of rows and columns found.
        int numberOfRows = sheet.getLastRowNum();
        int numberOfCells = sheet.getRow(1).getLastCellNum();
        System.out.println("Total Rows "+numberOfRows);
        System.out.println("Total Cells "+numberOfCells);

        //Reading the Data
        for (int r=0;r<=numberOfRows; r++){
            //Get Particular cell.
            XSSFRow currentRow = sheet.getRow(r);
            for(int c=0; c<numberOfCells; c++){
                //Get Cell.
               XSSFCell cell = currentRow.getCell(c);
               //Extract cell data.
                System.out.print(cell.toString()+"\t\t" +
                        "+");
            }
            System.out.println();
        }

        workbook.close();
        file.close();
    }
}
