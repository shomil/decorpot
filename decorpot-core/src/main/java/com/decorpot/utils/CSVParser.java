package com.decorpot.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVParser {

	public static void main(String[] args) {

		CSVParser obj = new CSVParser();
		obj.run();
	}

	public void run() {

		String csvFile = "/Users/ssaurav/Documents/decorpot_files/img1.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			Map<String, String> maps = new HashMap<String, String>();

			Map<Integer, String> headerMap = new HashMap<>();
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {


			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		
	  }
}
