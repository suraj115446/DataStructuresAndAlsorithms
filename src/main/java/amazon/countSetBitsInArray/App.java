package amazon.countSetBitsInArray;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

/**
 * Created by Suraj on 6/20/2017.
 */
public class App implements Runnable{


    public static void main(String[] args) throws IOException, InvalidFormatException {
        String FILE_NAME = "D:\\data.xlsx";
        File file = new File(FILE_NAME);
        File file2 = new File("D:\\output.xlsx");

        try {

            FileInputStream excelFile = new FileInputStream(file);
            Iterable<Sheet> workbook = new XSSFWorkbook(excelFile);

            Iterable<Sheet> outWorkbook = new XSSFWorkbook();

            Iterator<Sheet> sheetIterator = workbook.iterator();
            while (sheetIterator.hasNext()) {

                Sheet next = sheetIterator.next();
                Sheet sheet = ((Workbook) outWorkbook).createSheet(next.getSheetName());
                Iterator<Row> rowIterator = next.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    Iterator<Cell> cellIterator = row.iterator();
                    Row currentOutputRow = sheet.createRow(row.getRowNum());

                    while (cellIterator.hasNext()) {
                        Cell currentCell = cellIterator.next();
                        Cell outPutCell = currentOutputRow.createCell(currentCell.getColumnIndex(), currentCell.getCellTypeEnum());
                        CellType currentCellType = currentCell.getCellTypeEnum();
                        switch (currentCellType) {
                            case _NONE:
                            case BLANK:
                                break;
                            case ERROR:
                                outPutCell.setCellValue(CellType.ERROR.toString());
                                break;
                            case STRING:
                                outPutCell.setCellValue(currentCell.getStringCellValue());
                                break;
                            case BOOLEAN:
                                outPutCell.setCellValue(currentCell.getBooleanCellValue());
                                break;
                            case FORMULA:
                                outPutCell.setCellValue(currentCell.getCellFormula());
                                break;
                            case NUMERIC:
                                outPutCell.setCellValue(currentCell.getNumericCellValue());
                                break;
                        }
                        System.out.println(currentCell);

                    }


                }

            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            ((Workbook) outWorkbook).write(fileOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {

    }
}
