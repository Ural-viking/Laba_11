package L_11_Examples;

/*	Прочитать и вывести на экран информацию из трех источников:
 	файла на диске, интернет-страницы и массива данных типа byte.
 	Указать кодировку, поддерживающую кириллицу.
 */
 
import java.io.*;
import java.net.*;

public class L11_3 {
	public static void readAllByByte(Reader in) throws IOException{
		while(true) {
			int oneByte = in.read();
			if(oneByte != -1) {
				System.out.print((char)oneByte);
			}
			else {
				System.out.print("\n" + "end");
				break;
			}
		}
	}
	
	public static void main (String[] args) {
		try {
			// С потоком связан файл
			InputStream inFile = new FileInputStream("input.txt");
			Reader rFile = new InputStreamReader(inFile,"UTF-8");
			readAllByByte(rFile);
			System.out.print("\n\n\n");
			inFile.close();
			rFile.close();
			
			// С потоком связана интернет-страница
			InputStream inUrl = new URL("http://google.com").openStream();
			Reader rUrl = new InputStreamReader(inUrl,"UTF-8");
			readAllByByte(rUrl);
			System.out.print("\n\n\n");
			inUrl.close();
			rUrl.close();
			
			// С потоком связан массив типа byte
			InputStream inArray = new ByteArrayInputStream(new byte[] {5,8,3,9,11});
			Reader rArray = new InputStreamReader(inArray,"UTF-8");
			readAllByByte(rArray);
			System.out.print("\n\n\n");
			inArray.close();
			rArray.close();			
		}
		catch(IOException e){
			System.out.println("Error: " + e);
		}
	}
}