package com.cleartrip.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class FileReusables {
	
	static String filepath;
	static File file;
	static FileWriter fileWriter;
	static BufferedWriter bufferedWriter;
	static FileReader fileReader;
	static BufferedReader bufferedReader;
	
	public FileReusables(String filepath){
		this.filepath=filepath;
	}
	
	public static void fileWriting() throws IOException {
		 file = new File(filepath);
		 file.createNewFile();
		 fileWriter = new FileWriter(filepath);
		 bufferedWriter = new BufferedWriter(fileWriter);	 
	}
	public static void fileReading() throws FileNotFoundException {
		file = new File(filepath);
	    fileReader = new FileReader(filepath);
	    bufferedReader = new BufferedReader(fileReader);
	}
	public static void writeDataStr(String data) throws IOException {
		bufferedWriter.write(data);
		bufferedWriter.flush();
	}
	
	public static void writeDataInt(int data) throws IOException {
		bufferedWriter.write(data);
		bufferedWriter.flush();
	}
	
	public static String readData() throws IOException {
		String data=bufferedReader.readLine();
		return data;
	}
	
/*public static void main(String[] args) throws IOException {
	
	FileWriteReadReusable fr = new FileWriteReadReusable("C:\\Users\\IN00914\\workspace\\ramesh_projects\\classdemos1\\abc.txt");
	fr.fileWriting();
	fr.writeDataStr("selenium");
	
	fr.fileReading();
	String data =fr.readData();
	System.out.println(data);
	
	
	FileWriteReadReusable fr1 = new FileWriteReadReusable("C:\\Users\\IN00914\\workspace\\ramesh_projects\\classdemos1\\abc.txt");
	fr1.fileWriting();
	fr1.writeDataStr("cigniti technologies");
	
	fr1.fileReading();
	String data1 =fr.readData();
	System.out.println(data1);
	
	*/

}
