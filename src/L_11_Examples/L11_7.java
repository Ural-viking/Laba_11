package L_11_Examples;

//	Выполнить запись строк и чтение их из файла с произвольным доступом.


import java.io.*;
import java.util.*;

public class L11_7 {
	public static void main(String[] args) {
		try {
			File folder = new File("Example_7");
			if(!folder.exists()) folder.mkdir();
			File file = new File("Example_7\\string_for_example.txt");
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Сколько строк надо записать в файл? \n =>");
			int count =scan.nextInt();
			scan.nextLine();
			
			RandomAccessFile raf = new RandomAccessFile(file,"rw");
			raf.setLength(0);
			long len = raf.length();
			System.out.println("Открыт файл размером "+ len + " байт");
			System.out.println("Введите строки:");
			int kol = 0;
			// Записать строки в файл
			for(int i=0;i<count;i++) {
				raf.seek(raf.length());
				String s = scan.nextLine();
				raf.writeUTF(s);
				kol+=s.length();
			}
			len = raf.length();
			System.out.println("Размер файла в байтах = " + len);
			raf.close();
			// Открыть файл для чтения "r"
			raf = new RandomAccessFile(file,"r");
			// Вывод строк из файла на экран
			System.out.println("Строки из файла:");
			raf.seek(0); // перевести указатель в начало файла (на первое слово)
			for (int i = 0; i < count; i++)
			System.out.println("Строка " + i +" начинается с байта " + raf.getFilePointer() + " - " + raf.readUTF() + " - заканчивается байтом " + (raf.getFilePointer()-1));
			raf.close();
		}
		catch(IOException e){
			System.out.println("End of file " +e);
		}
	}
}