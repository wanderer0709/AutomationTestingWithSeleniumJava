package utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;
    private static XSSFRow Row;


    public static String getCellData(int row, int column) {
            Cell = ExcelWSheet.getRow(row).getCell(column);
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(Cell);
    }

    public static XSSFRow getRowData(int rowNum) {
        Row = ExcelWSheet.getRow(rowNum);
        return Row;
    }


    public static String[][] readExcel(String path, String sheetName) throws IOException {
        String[][] tableData;

        //Create an object of File class to open xlsx file
//        String path = System.getProperty("user.dir");
        File excelFile = new File(path);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(excelFile);

        ExcelWBook = new XSSFWorkbook(inputStream);
        ExcelWSheet = ExcelWBook.getSheet(sheetName);

        //Find number of rows in excel file
        int rowCount = ExcelWSheet.getLastRowNum();
        int columnCount = ExcelWSheet.getRow(0).getLastCellNum()-2;

        int startRow = 1;
        int startColumn = 1;

        int ci = 0;

        tableData = new String[rowCount][columnCount];
        for(int i = startRow; i <= rowCount; i++, ci++) {
            int cj = 0;
            for(int j = startColumn; j <= columnCount; j++, cj++) {
//                System.out.println(getCellData(i, j));
                tableData[ci][cj] = getCellData(i, j);
            }
        }
        return tableData;

    }
}
