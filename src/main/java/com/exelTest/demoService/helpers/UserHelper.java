package com.exelTest.demoService.helpers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.exelTest.demoService.entities.User;

public class UserHelper {
	
	public static List<User> convertExelDataToListOfUsers(FileInputStream fileInputStram){
		List<User> list = new ArrayList<>();
		
		try {
			
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStram);
			
			XSSFSheet sheet1 = workbook.getSheet("Sheet1");
			
			Iterator<Row> rows = sheet1.iterator();
			int cellNumber = 0;
			
			while(rows.hasNext()) {
				
				Row row = rows.next();
				
				Iterator<Cell> cells = row.iterator();
				cellNumber = 0;
				
				User user = new User();
				
				while(cells.hasNext()) {
					
					Cell cell = cells.next();
					
					switch (cellNumber) {
					case 0 :
						user.setFirstName(cell.getStringCellValue());
						break;
					case 1:
						user.setMiddleName(cell.getStringCellValue());
						break;
					case 2:
						user.setLastName(cell.getStringCellValue());
						break;
					case 3:
						user.setAge( (int)cell.getNumericCellValue());
						break;
					default :
						break;
					}
					
					cellNumber++;
					
				}
				
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
