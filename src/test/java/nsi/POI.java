package nsi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POI
{

    public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite) throws IOException
    {
        File file = new File(filePath + "\\" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook wb = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if (fileExtensionName.equals(".xlsx"))
        {
            wb = new XSSFWorkbook(inputStream);
        }
        else if (fileExtensionName.equals(".xls"))
        {
            wb = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = wb.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        // Row row = sheet.getRow(0);
        Row newRow = sheet.createRow(rowCount + 1);
        for (int col = 0; col < dataToWrite.length; col++)
        {
            Cell cell = newRow.createCell(col);
            cell.setCellValue(dataToWrite[col]);
        }
        for (int col = 0; col < dataToWrite.length; col++)
        {
            sheet.autoSizeColumn(col);
        }
        sheet.setAutoFilter(CellRangeAddress.valueOf("A1:F1"));
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        wb.write(outputStream);
        outputStream.close();
    }
}
