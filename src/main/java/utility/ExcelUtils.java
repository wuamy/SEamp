package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

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

    //this method is to read the test data from the excel cell, in this we are passing param
    //as row num and col num
    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
        } catch (Exception e){
            return "";
        }
    }

    //This method is ot write in the excel cell, row num and col num are the parameters
    @SuppressWarnings("static-access")
    public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
        try {
            Row = ExcelWSheet.getRow(RowNum);
            Cell = Row.getCell(ColNum,Row.RETURN_BLANK_AS_NULL);
            if (Cell == null) {
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            } else {
                Cell.setCellValue(Result);
            }
            // Constant variables test data path and test data file name
            FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
            EXcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (Exception e){
            throw (e);
        }
    }

    public static int getRowContains(String sTestCasename, int colNum) throws Exception{
        int i;
        try {
            int rowCount = ExcelUtils.getRowUsed();
            for (i=0; i<rowCount; i++){
                if (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCasename)){
                    break;
                }
            }
            return i;
        } catch (Exception e){
            Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
            throw (e);
        }

    }

    public static int getRowUsed() throws Exception {
        try{
            int RowCount = ExcelWSheet.getLastRowNum();
            Log.info("Total number of row used return as " + RowCount + ";");
            return RowCount;
        } catch (Exception e){
            Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : " + e.getMessage());
            System.out.println(e.getMessage());
            throw (e);
        }

    }






}
