package com.api.book.helper;

import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR = "C:\\Users\\Gaurang Dalvadi\\Desktop\\Spring_Boot\\bootRestBook\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile file) {
		boolean f = false;
		
		try {
			InputStream inputStream = file.getInputStream();
			byte data[] = new byte[inputStream.available()];
			
			inputStream.read(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
