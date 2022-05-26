package L_11_Examples;

/*	Чтение из одного файла и запись в другой файл данных построчно с использованием буферизации символьных потоков
	основанных на байтовых файловых потоках.	*/

import java.io.*;

public class L11_4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			// Создание потоков для чтения и записи с нужной кодировкой
			br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"),"UTF-8"));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"),"UTF-8"));
			
			// Переписывание информации из одного файла в другой
			int lineCount =0;	// счетчик строк
			String s;
			while((s=br.readLine())!=null) {
				lineCount++;
				System.out.println(lineCount + ": " + s);
				bw.write(lineCount + ": " +s);  // запись без перевода строки
				bw.newLine();	// принудительный переход на новую строку
			}
		}
		catch(IOException e) {
			System.out.println("Error!!!" + e);
		}
		finally {
			br.close();
			bw.flush();
			bw.close();
		}
	}
}