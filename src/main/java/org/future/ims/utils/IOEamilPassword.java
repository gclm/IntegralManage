package org.future.ims.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.future.ims.pojo.EamilPassword;

public class IOEamilPassword {

	public EamilPassword load()// 读取文件
	{
		EamilPassword eamilPassword = new EamilPassword();
		try {
			String filename = "emailPassword.txt";
			File file = new File(filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = reader.readLine()) != null) {
				String name = temp.split(",")[0];
				String password = temp.split(",")[1];
				eamilPassword.setEmailName(name);
				eamilPassword.setEamilPassword(password);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return eamilPassword;
	}

	public void save(EamilPassword eamilPassword)// 写入文件
	{
		String fileName = "emailPassword.txt";
		String temp = eamilPassword.getEmailName()+","+eamilPassword.getEamilPassword()+",";
		try {
			File file = new File(fileName);
			FileWriter fileWriter;
			fileWriter = new FileWriter(file);
			fileWriter.write(temp);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}