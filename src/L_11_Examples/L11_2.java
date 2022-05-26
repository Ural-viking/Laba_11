package L_11_Examples;

// Чтение из одного файла и запись в другой файл данных построчно с использованием буфера в 1 килобайт

import java.io.*;

public class L11_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =null;
		BufferedWriter out = null;
		try {
			// Создание файловых символьных потоков для чтения и записи
			br = new BufferedReader(new FileReader("input.txt"),1024);	// размер буфера 1024
			out = new BufferedWriter(new FileWriter("output.txt"));
			
			int lineCount = 0;
			String s;
			
			// Переписывание информации из одного файла в другой
			
			while((s=br.readLine())!= null) {
				lineCount++;
				System.out.println(lineCount + ": " + s);
				out.write(s);
				out.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error!!!");
		}
		finally {
			br.close();
			out.flush();
			out.close();
		}
	}
}