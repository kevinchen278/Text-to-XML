package org.kevinchen278.java.toxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class MyUtil {
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static final String NUMS = "0123456789";
	static SecureRandom rnd = new SecureRandom();
	
	@SuppressWarnings("deprecation")
	public static String readFile(String fileName){
		String retVal = "";
		FileInputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream(fileName);
			retVal = IOUtils.toString(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
		
		return retVal;
	}
	
	public static boolean createDirectories(String path){
		File dir = new File(path);
		return dir.mkdirs();
	}
	
	
	public static void writeFile(String dirStr, String data) {
		
		String path = (new File(dirStr)).getParent();
		if ((path != null) && (! new File(path).exists())) {
			createDirectories(path);
		}
		
		try {
			FileUtils.writeStringToFile(new File(dirStr), data);
		} catch (IOException e){
			e.printStackTrace();
		}
	}	
	
	
	public String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}	
	
	public String randomPhone( int len ){
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( NUMS.charAt( rnd.nextInt(NUMS.length()) ) );
		   return sb.toString();
	}
	
	public static List<String> textToItems(String text, String splitStr) {
		List<String> lines = Arrays.asList(text.split(splitStr));
		return lines;
	}
	
}
