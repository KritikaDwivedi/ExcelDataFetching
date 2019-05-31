package excelDataFetching;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFetch {
//kritika 90,90,90
	public static void main(String args[])throws IOException{
		
		HashMap<String, List<String>> hashMap1 = new HashMap<String, List<String>>();
		List<String> list=null ;
		FileInputStream fis=new FileInputStream("resources/excel.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		 Iterator<Row> rowIterator = sheet.iterator();
		 while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell keyCell=row.getCell(0);
			String key = keyCell.getStringCellValue().trim();
			list= new ArrayList<String>();
			 Iterator<Cell> cellIterator = row.cellIterator();
			 cellIterator.next();
			 while(cellIterator.hasNext()) {
				 Cell cell2= cellIterator.next();
					switch(cell2.getCellType()) {
					case STRING: 
                        String s=cell2.getStringCellValue(); 
                        list.add(s); 
                        break;
					 case NUMERIC: 
                         String values =String.valueOf((int)cell2.getNumericCellValue()); 
                         list.add(values);
                         break; 
					default:
						break;
					}
					hashMap1.put(key, list);
				 }
			}
		 System.out.println(hashMap1);
		
		 for (String student : hashMap1.keySet()) { 
	            System.out.println("Student: " + student); 
	            int i=1;
	        	for(String mark:hashMap1.get(student))
	         {		if(i==1)
	        		 System.out.println("Marks in Physics: " + mark); 
		         if(i==2)
	        		 System.out.println("Marks in Chemistry: " + mark); 
		         if(i==3)
	        		 System.out.println("Marks in Maths: " + mark); 
		         i++;
	        	}
	        }  
		 System.out.println("Kritika Marks in Physics is="+ hashMap1.get("Kritika"));
	}	
}
