package de17;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TextProcessor {
	private String fName;

	public TextProcessor(String fName) {
		this.fName = fName;
	}

	public boolean checkNumber() {
		return true;
	}

	public int getWordsAmount() throws IOException {
		int count = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.fName), "UTF-16"));
		String line;
		while ((line = br.readLine()) != null) {
			String[] arr = line.split(" ");
			for (String s : arr) {
				try {
					Integer.parseInt(s);
					Double.parseDouble(s);
				} catch (Exception e) {
					count++;

				}
			}
		}
		br.close();
		return count;
	}

	public int getNumbersAmount() throws IOException {
		int count = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.fName), "UTF-16"));
		String line;
		while ((line = br.readLine()) != null) {
			String[] arr = line.split(" ");
			for (String s : arr) {
				try {
					Double.parseDouble(s);
					count++;
				} catch (Exception e) {

				}
			}
		}
		br.close();
		return count;
	}

	public int getNumberSum() throws IOException {
		return this.getWordsAmount() + this.getNumbersAmount();
	}

	public static void main(String[] args) throws IOException {
		String path = "file/CountWord.txt";
		TextProcessor test = new TextProcessor(path);
		System.out.println("Số từ(number) trong file là: " + test.getNumbersAmount());
		System.out.println("Số từ(word) trong file là: " + test.getWordsAmount());
		System.out.println("Tổng số từ trong file là: " + test.getNumberSum());

	}

}
