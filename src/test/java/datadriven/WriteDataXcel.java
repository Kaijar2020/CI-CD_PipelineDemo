package datadriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//Excel File -->Workbook-->Sheets-->Rows--> Cells
public class WriteDataXcel {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\Book2.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        //create sheet
        XSSFSheet sheet = workbook.createSheet("Data");

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Rows number : ");
        int numOfRows = scan.nextInt();

        System.out.print("Enter the Cells number : ");
        int numOfCells = scan.nextInt();

        for (int r=0; r<=numOfRows;r++){

            //Create row
            XSSFRow currentRow = sheet.createRow(r);

            for (int c=0;c<numOfCells;c++){
                //Crate cells
                XSSFCell currentCell = currentRow.createCell(c);
                currentCell.setCellValue(scan.next());
            }
        }
        workbook.write(file); //attach workbook to the file.
        workbook.close();
        file.close();
    }
}
