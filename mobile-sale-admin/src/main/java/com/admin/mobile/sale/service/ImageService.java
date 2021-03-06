package com.admin.mobile.sale.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
	
	@Value("${image.path}")
	private String IMAGE_DIC;
	
	public static final String PHONE_PATH = "phone-image/";
	
	public byte[] readFileFrom(String dicPath, String imageName) throws IOException {
		@SuppressWarnings("resource")
		FileInputStream fi = new FileInputStream(IMAGE_DIC + dicPath + imageName);
		byte[] bytes = new byte[fi.available()];
		 fi.read(bytes);
		 return bytes;
	}

	public void save(String fileName, byte[] bytes) throws IOException {
		@SuppressWarnings("resource")
		FileOutputStream fos = new FileOutputStream(IMAGE_DIC+PHONE_PATH+fileName);
		fos.write(bytes);
	}
	
}