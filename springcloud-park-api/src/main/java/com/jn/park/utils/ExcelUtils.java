package com.jn.park.utils ;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * excel 工具类， 支持xls，xlsx
 * @author : linjj
 * Date: 13-9-24
 * Time: 下午8:37
 */
public class ExcelUtils {
    /**
     * 导出xls格式
     */
    public static final int EXPORT_AS_XLS = 1;
    /**
     * 导出为xlsx格式
     */
    public static final int EXPORT_AS_XLSX = 2;
    /**
     * xls格式时每个sheet最大行
     */
    private static final int MAX_SHEET_ROWS = 50000;
    /**
     *  最大导出行
     */
    private static final int MAX_EXPORT_LINE = 100000;
    private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    private ExcelUtils() {
        // 为了防止被new对象
    }

    /**
     * 导出Excel
     *
     * @param titles   标题
     * @param fields   字段名与标题对应
     * @param data     数据
     * @param exportAs 导出方式，PoiUtil.EXPORT_AS_XLS, PoiUtil.EXPORT_AS_XLSX
     * @param out      导出的excel的输出流
     * @throws Exception
     */
    public static void exportData(List<String> titles, List<String> fields, List<Map<String, Object>> data, int exportAs, OutputStream out) throws Exception {
        Workbook workbook = createWorkbook(exportAs);
        logger.info("createWorkbook 成功");
        Map<String, CellStyle> style = createCellStyle(workbook);
        logger.error("createCellStyle 成功");
        Map<String, String> titleMap = createTitleMap(titles, fields);
        logger.info("createTitleMap 成功");
        createSheets(workbook, titleMap, data, exportAs, style);
        logger.info("createSheets 成功");
        writeWorkbook(workbook, out);
        logger.info("writeWorkbook 成功");
    }

    public static void exportDataTemplate(List<String> titles, List<String> fields, List<Map<String, Object>> data, InputStream is, OutputStream out, int rowIndex) throws Exception {
        int exportAs = 1;
        Workbook workbook = createWorkbookTemplate(is);
        logger.info("createWorkbook 成功");
        Map<String, CellStyle> style = createCellStyle(workbook);
        logger.error("createCellStyle 成功");
        Map<String, String> titleMap = createTitleMap(titles, fields);
        logger.info("createTitleMap 成功");
        createSheetsTemplate(workbook, titleMap, data, exportAs, style, rowIndex);
        logger.info("createSheets 成功");
        writeWorkbook(workbook, out);
        logger.info("writeWorkbook 成功");
    }

    /**
     * 创建工作薄
     *
     * @param exportAs 导出方式1 xls 2 xlsx
     * @return Workbook
     */
    private static Workbook createWorkbook(int exportAs) {
        // 默认创建xlsx缓存导出的工作薄
        Workbook workbook = new SXSSFWorkbook(200);
        if (exportAs == EXPORT_AS_XLS) {
            workbook = new HSSFWorkbook();
        }
        return workbook;
    }

    /**
     * 创建单元格样式，主要分为标题样式和公用样式
     *
     * @param workbook 工作薄
     * @return 样式Map
     */
    private static Map<String, CellStyle> createCellStyle(Workbook workbook) {
        Map<String, CellStyle> style = new HashMap<String, CellStyle>(16);
        Font titleFont = workbook.createFont();
        CellStyle titleStyle = workbook.createCellStyle();
        setCellStyle(titleStyle, titleFont);
        style.put("titleStyle", titleStyle);
        CellStyle commonStyle = workbook.createCellStyle();
        setCellStyle(commonStyle, null);
        style.put("commonStyle", commonStyle);
        return style;
    }

    /**
     * 创建excel sheet
     *
     * @param workbook 工作薄
     * @param titleMap 标题字段Map
     * @param data     数据
     * @param exportAs 导出方式
     * @param style    样式
     */
    private static void createSheets(Workbook workbook, Map<String, String> titleMap, List<Map<String, Object>> data, int exportAs, Map<String, CellStyle> style) {
        Sheet[] sheets = null;
        if (data == null || data.isEmpty() || exportAs == EXPORT_AS_XLSX) {
            // 如果是xlsx格式导出则数据放在一个sheet
            sheets = new Sheet[]{workbook.createSheet("sheet1")};
        } else {
            if (exportAs == EXPORT_AS_XLS) {
                // 如果是xls格式导出则每MAX_SHEET_ROWS行分一个sheet
                sheets = new Sheet[data.size() / MAX_SHEET_ROWS + 1];
                for (int i = 0; i <= data.size() / MAX_SHEET_ROWS; i++) {
                    sheets[i] = workbook.createSheet("sheet" + (i + 1));
                }
            }
        }
        createRows(sheets, titleMap, data, style);
    }

    /**
     * 创建导出行
     *
     * @param sheets   excel sheet
     * @param titleMap 标题
     * @param data     数据
     * @param style    样式
     */
    private static void createRows(Sheet[] sheets, Map<String, String> titleMap, List<Map<String, Object>> data, Map<String, CellStyle> style) {
        Row row;
        if (sheets != null) {
            // 导出数据的数组下标
            int dataIndex = 0;
            for (Sheet sheet : sheets) {
                // 单元格下标
                int cellIndex = 0;
                // 当前sheet行数下标
                int rowIndex = 0;
                if (titleMap != null && !titleMap.isEmpty()) {
                    row = sheet.createRow(rowIndex);
                    for (Map.Entry<String, String> stringStringEntry1 : titleMap.entrySet()) {
                        Map.Entry entry = (Map.Entry) stringStringEntry1;
                        String cellData = Objects.toString(entry.getValue());
                        sheet.setColumnWidth(cellIndex, 6000);
                        createCell(row, cellData, cellIndex, style.get("titleStyle"));
                        cellIndex++;
                    }
                    rowIndex++;
                    if (data != null && !data.isEmpty()) {
                        for (; dataIndex < data.size() && dataIndex < MAX_EXPORT_LINE; dataIndex++) {
                            // 数据最大导出限制为MAX_EXPORT_LINE
                            Map<String, Object> dataMap = data.get(dataIndex);
                            row = sheet.createRow(rowIndex);
                            cellIndex = 0;
                            for (Map.Entry<String, String> stringStringEntry : titleMap.entrySet()) {
                                Map.Entry entry = (Map.Entry) stringStringEntry;
                                String cellKey = Objects.toString(entry.getKey());
                                sheet.setColumnWidth(cellIndex, 6000);
                                createCell(row, dataMap.get(cellKey), cellIndex, style.get("commonStyle"));
                                cellIndex++;
                            }
                            rowIndex++;
                            if (rowIndex > MAX_SHEET_ROWS && sheets.length > 1) {
                                // 如果超过每页最大数则进行excel分页,把数据存到下一个sheet中,此逻辑主要针对xls格式导出方式
                                dataIndex++;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 创建单元格
     *
     * @param row       行
     * @param cellData  单元格数据
     * @param cellIndex 单元格下标
     * @param style     样式
     */
    private static void createCell(Row row, Object cellData, int cellIndex, CellStyle style) {
        if (row != null) {
            Cell cell = row.createCell(cellIndex);
            cell.setCellValue(Objects.toString(cellData));
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellStyle(style);
        }
    }

    /**
     * 创建公用样式和标题样式
     *
     * @param cellStyle 单元格样式
     * @param titleFont 标题字体
     */
    private static void setCellStyle(CellStyle cellStyle, Font titleFont) {
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        cellStyle.setWrapText(false);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        if (titleFont != null) {
            titleFont.setColor(IndexedColors.BLACK.getIndex());
            titleFont.setFontHeightInPoints((short) 12);
            cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            cellStyle.setFont(titleFont);
        }
    }


    private static Map<String, String> createTitleMap(List<String> titles, List<String> fields) {
        Map<String, String> titleMap = null;
        if (fields != null && !fields.isEmpty()) {
            titleMap = new LinkedHashMap<String, String>(fields.size());
            for (int i = 0; i < fields.size(); i++) {
                if (titles != null && i < titles.size()) {
                    titleMap.put(fields.get(i), titles.get(i));
                } else {
                    titleMap.put(fields.get(i), fields.get(i));
                }
            }
        }
        return titleMap;
    }

    private static void createSheetsTemplate(Workbook workbook, Map<String, String> titleMap, List<Map<String, Object>> data, int exportAs, Map<String, CellStyle> style, int rowIndex) {
        Sheet[] sheets = null;
        char change='썐';
        if (data != null && !data.isEmpty() && exportAs != EXPORT_AS_XLSX) {
            if (exportAs == 1) {
                sheets = new Sheet[data.size() / change + 1];

                for(int i = 0; i <= data.size() / change; ++i) {
                    try {
                        sheets[i] = workbook.getSheetAt(i);
                    } catch (Exception var9) {
                        sheets[i] = workbook.createSheet("Sheet" + i);
                    }
                }
            }
        } else {
            sheets = new Sheet[]{workbook.createSheet("sheet1")};
        }

        createRowsTemplate(sheets, titleMap, data, style, rowIndex);
    }

    private static void createRowsTemplate(Sheet[] sheets, Map<String, String> titleMap, List<Map<String, Object>> data, Map<String, CellStyle> style, int rowIndex) {
        if (sheets != null) {
            int dataIndex = 0;
            Sheet[] arr = sheets;
            int len = sheets.length;
            int maxlength=400000;
            for(int i = 0; i < len; ++i) {
                Sheet sheet = arr[i];
                if (data != null && !data.isEmpty()) {
                    while(dataIndex < data.size() && dataIndex < maxlength) {
                        Map<String, Object> dataMap = (Map)data.get(dataIndex);
                        Row row = sheet.createRow(rowIndex);
                        int cellIndex = 0;

                        for(Iterator j = titleMap.entrySet().iterator(); j.hasNext(); ++cellIndex) {
                            Map.Entry<String, String> stringStringEntry = (Map.Entry)j.next();
                            String cellKey = Objects.toString(stringStringEntry.getKey());
                            String cellStr = (String)dataMap.get(cellKey);
                            if (StringUtils.isBlank(cellStr)) {
                                cellStr = "";
                            }
                            sheet.setColumnWidth(cellIndex, 6000);
                            createCell(row, cellStr, cellIndex, (CellStyle)style.get("commonStyle"));
                        }
                        ++rowIndex;
                        if (rowIndex > 50000 && sheets.length > 1) {
                            ++dataIndex;
                            break;
                        }

                        ++dataIndex;
                    }
                }
            }
        }

    }

    private static Workbook createWorkbookTemplate(InputStream is) {
        HSSFWorkbook workbook = null;

        try {
            workbook = new HSSFWorkbook(is);
        } catch (Exception var3) {
            ;
        }

        return workbook;
    }

    private static void writeWorkbook(Workbook workbook, OutputStream out) throws IOException {
        try {
            workbook.write(out);
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            }catch (IOException ce){
                logger.error("writeWorkbook finally exception ",ce);
            }
            logger.info("writeWorkbook finally ");
        }
    }
}