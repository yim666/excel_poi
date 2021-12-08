package com.yh.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**@author yim
 *
 */

public class ExcelUtil {
    /**
     * 作用：在控制台打印日志 ，log.info() 设置日志输出的级别
     * 日志级别由高到底是：fatal -> error -> warn -> info -> debug
     * 修改日志输出的级别要在log4j文件中进行配置
     * 例：info 则 低于info的debug日志不会输出
     * 如果是error 则 只会打印 fatal 和 error 日志
     */
   private static final Logger LOGGER= LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * 获取并解析一个 excel文件 ，返回一个二维数组集合
     * @param file
     * @return 最外层的ArrayList是行（用于定位），内层的ArrayList是当前行的列集合（包含所有数据）
     */
  public  static ArrayList<ArrayList<String>> analysis(MultipartFile file){
      ArrayList<ArrayList<String>> result = new ArrayList<>();

      //获取文件名
      String originalFilename = file.getOriginalFilename();
      System.out.println(originalFilename);

      try {
        //获取输入流
          InputStream inputStream = file.getInputStream();

          Workbook wk=null;
          //判断excel版本
          if (judegExcelEdition(originalFilename)){
              wk=new XSSFWorkbook(inputStream);
          }else {
              wk=new HSSFWorkbook(inputStream);
          }

          //获取一张excel工作报表
          Sheet sheet = wk.getSheetAt(0);

          Row row=null;
          //getPhysicalNumberOfRows() 获取表的物理行数
          for (int i=1;i<sheet.getPhysicalNumberOfRows();i++){
              //获取表 第i行内容
            row=sheet.getRow(i);
            //循环获取每一列
            ArrayList<String> list = new ArrayList<>();
              Cell cell=null;
              //循环封装第i行的 第j列单元格
              for (int j=0;j<row.getPhysicalNumberOfCells();j++){
                  LOGGER.info(i+":"+j);
                  cell=row.getCell(j);
                  if (cell==null){
                      cell=row.createCell(j);
                  }
                  cell.setCellType(CellType.STRING);

                  list.add(cell.getStringCellValue());
              }
              //封装每一列到大集合（外层ArrayList）
              result.add(list);
              //关闭资源
              wk.close();
          }
      }catch (FileNotFoundException e){
        e.printStackTrace();
          System.out.println("---------未找到文件--------");
      } catch (IOException e) {
          e.printStackTrace();
          System.out.println("--------文件上传失败--------");
      }
      return  result;
  }

    /**
     * 判断excel文件上传版本(xls为2003，xlsx为2007)
     * @param originalFilename 文件路径
     * @return xlsx返回true,xls返回false
     */
    private static boolean judegExcelEdition(String originalFilename) {
        /**
         *     正则表达式  ^. 开头为任意字符串
         *     \\.  \转义  \.下一个字符为 .
         *      (?i) 右侧开启忽略大小写
         *      (xls)$ 末尾精确匹配 xls
         */
        if (originalFilename.matches("^.+\\.(?i)(xls)$")){
            return false;
        }else {
            return  true;
        }
    }
}
