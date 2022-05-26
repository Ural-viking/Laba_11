package L_11_Examples;

// „тение из одного файла и запись в другой файл данных посимвольно.

import java.io.*;

public class L11_1 {
	public static void main(String[] args) throws IOException{	// метод main генерирует исключениe
		Reader in = null;	// можно сразу записать FileReader in=null; 
		Writer out = null;	// можно сразу записать FileWriter out =null;
		try {
			in = new FileReader("input.txt");	// файл дл€ чтени€ данных
			out = new FileWriter("output.txt");	// файл дл€ записи c разрешением добавлени€ данных
			// ƒанные считываютс€ и записываютс€ побайтно, как и дл€ InputStream/OutputStream
			int oneByte;	// переменна€, в которую считываютс€ данные
			while ((oneByte = in.read())!= -1) {
				// out.write((char)oneByte);  // запись с уничтожением ранее существующих данных
				out.append((char)oneByte);	// запись с добавлением данных в конец
				System.out.print((char)oneByte);
			}
		}
		catch(IOException e) {
			System.out.println("Error!!!");
		}
		finally {
			in.close();
			out.close();
		}
	}
}