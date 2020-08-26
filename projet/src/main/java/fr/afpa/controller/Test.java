package fr.afpa.controller;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		
		String str2 = ".";
		File f2 = new File(str2);
		
		String str3 = "/src/main/webapp/WEB-INF";
		
		try {
			File f3 = new File(f2.getCanonicalPath()+str3);
			System.out.println(f3.getCanonicalPath());
			System.out.println(f3.exists());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
