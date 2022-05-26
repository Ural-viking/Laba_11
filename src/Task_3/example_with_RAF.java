package Task_3;

/* 	Работа с файлом с произвольным доступом/
	Записать в исходный файл информацию о фильмах:
	Название_фильма, год_выпуска, страна, жанр, стоимость_проката. Количество фильмов задать с клавиатуры.
	Создать программным способом другой файл и переписать в него информацию о фильмах, выпущенных в России. */

import java.io.*;
import java.util.*;

public class example_with_RAF {
	public static void main(String[] args) {
//	СОЗДАНИЕ НЕОБХОДИМЫХ ФАЙЛОВ И ПЕРЕМЕННЫХ		
		try {
			File folder = new File("Task_3\\Example_RAF");
			folder.mkdirs();
			File file = new File("Task_3\\Example_RAF\\input.doc");
			file.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(file,"rw");
			Scanner scan1 = new Scanner(System.in,"UTF-8");	//сканер для чисел
			Scanner scan2 = new Scanner(System.in,"UTF-8");	//сканер для строк
			System.out.println("Введите количество фильмов для записи в файл \n => ");
			int numberOfFilms = scan1.nextInt();
			scan1.nextLine();	// очистка буфера
			
			String theNameOfTheFilm, theCountry, filmGenre;
			int released, rentalPrice;
			
//	ЗАПИСЬ ИНФОРМАЦИИ О ФИЛЬМАХ В ДОКУМЕНТ
			
			for(int i=1;i<=numberOfFilms;i++) {
				System.out.println("Введите название " + i + " фильма => ");	// сообщение для пользователя
				theNameOfTheFilm = scan2.next();	//	читаем введенное название фильма
				raf.seek(raf.length());	//	поиск конца файла
				raf.writeUTF(theNameOfTheFilm);	// запись в документ названия фильма
				for(int j=0;j<20-theNameOfTheFilm.length();j++) {
					raf.writeByte(1);	// добавление байтов до 20-ти любой цифрой 1
				}
				System.out.println("Введите год выпуска фильма => ");
				released = scan1.nextInt();	//	читаем введенный год
				raf.writeInt(released); //	запись года выпуска фильма в документ
				System.out.println("Введите страну производства фильма => ");
				theCountry = scan2.next();
				raf.writeUTF(theCountry);
				for(int j=0;j<20-theCountry.length();j++) {
					raf.writeByte(1);
				}
				System.out.println("Введите жанр фильма => ");
				filmGenre = scan2.next();
				raf.writeUTF(filmGenre);
				for(int j=0;j<20-filmGenre.length();j++) {
					raf.writeByte(1);
				}
				System.out.println("Введите прокат фильма => ");
				rentalPrice = scan1.nextInt();
				raf.writeInt(rentalPrice);
			}
		raf.close();
		
// СОЗДАЕМ ПРОГРАММНЫМ СПОСОБОМ ДРУГОЙ ФАЙЛ В КОТОРЫЙ БУДЕМ ЗАПИСЫВАТЬ РОССИЙСКИЕ ФИЛЬМЫ
		
			File file2 = new File("Task_3\\Example_RAF\\russian.txt");
			file2.createNewFile();
		
// ПЕРЕПИШЕМ ВО ВТОРОЙ ФАЙЛ РОССИЙСКИЕ ФИЛЬМЫ
		
			raf = new RandomAccessFile(file,"r");
			raf.seek(0);
			PrintWriter pw = new PrintWriter(file2);
			pw.print("Название \t\t Год выпуска \t\t Страна \t\t Жанр \t\t Стоимость проката" );
			for(int i=0;i<numberOfFilms;i++) {

				theNameOfTheFilm = raf.readUTF();
				for(int j=0;j<20-theNameOfTheFilm.length();j++) {
					raf.readByte();
				}

				released = raf.readInt();
			
				theCountry = raf.readUTF();
				for(int j=0;j<20-theCountry.length();j++) {
					raf.readByte();
				}
			
				filmGenre = raf.readUTF();
				for(int j=0;j<20-filmGenre.length();j++) {
					raf.readByte();
				}
			
				rentalPrice = raf.readInt();
				
				if(theCountry.equals("Russia") || theCountry.equals("russia") || theCountry.equals("Россия") ||theCountry.equals("россия")) {
					pw.print("\n" + theNameOfTheFilm + "\t\t\t\t" + released + "\t\t" +  theCountry + "\t\t" + filmGenre + "\t\t" + rentalPrice);
				}
			
			}
			raf.close();
			pw.close();
		}
		catch(EOFException f) {
			f.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}		
	}
}