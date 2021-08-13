package prasanth.vb.JavaPrograms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

public class FileCounterCount extends BaseTestNg{

	@Test
	public void filecountercounts() {
		String path = "C:\\Users\\prasanth.vb\\Desktop\\softwares.txt";
		int linecount = 0;
		int wordcount = 0;
		int charcount = 0;
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			String currentLine = reader.readLine().trim();
			
			while(currentLine != null) {
				//lines
				linecount ++;
				
				//words
				String words[] = currentLine.split(" ");
				wordcount = words.length;
				
				//Characters
				for(String word : words) {
					charcount = charcount + word.length();
				}
				currentLine = reader.readLine().trim();
			}
			System.out.println("Total lines in the file is : " + linecount);
			System.out.println("Total words in the file is : " + wordcount);
			System.out.println("Total characters in the file is : " + charcount);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
