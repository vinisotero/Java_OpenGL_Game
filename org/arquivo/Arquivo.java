package org.arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Arquivo implements Serializable{
	
	public static void write(int score, File file){
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(""+score);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static String read(File myObj) {
		String data;
		try {
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        data = myReader.nextLine();
	        return data;
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return "0";
	  }

	
}
