package utility;

import java.io.FileInputStream;

import org.apache.commons.logging.Log;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by amy on 9/9/2016.
 */
public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook EXcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    //This method is to set the file path and to open the excel file
    //Pass Excel path and sheetname as arguments to this method
    public static void setExcelFile(String Path, String SheetName) throws Exception{
        try {
            //open the excel file
            FileInputStream ExcelFile = new FileInputStream(Path);
            //Access the required test data sheet
            EXcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = EXcelWBook.getSheet(SheetName);
            Log.info("Excel sheet opened!");
        } catch (Exception e){
            throw e;
        }

    }




}
