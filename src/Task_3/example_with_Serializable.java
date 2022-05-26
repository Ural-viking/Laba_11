package Task_3;

/*	Работа через сериализацию.
	Условие:
			- Записать в исходный файл информацию о фильмах: Название_фильма, год_выпуска, страна, жанр, стоимость_проката. Количество фильмов задать с клавиатуры.
	Создать программным способом другой файл и переписать в него информацию о фильмах, выпущенных в России. */

import java.util.*;
import java.io.*;

class Film implements Serializable{
	String theNameOfTheFilm; //название фильма
	int released;	// дата выхода 
	String theCountry;	 // страна производства
	String filmGenre; // жанр
	int rentalPrice; // прокат
	
	Film(String name,int data,String country,String genre,int rental){
		theNameOfTheFilm = name;
		released = data;
		theCountry = country;
		filmGenre = genre;
		rentalPrice = rental;
	}	
}

public class example_with_Serializable {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner scanInt = new Scanner(System.in,"UTF-8");
		Scanner scanStr = new Scanner(System.in,"UTF-8");
				// создается файл на диске
		File folder = new File("Task_3\\Example_Serial");
		folder.mkdirs();
		File file = new File("Task_3\\Example_Serial\\input.doc");
		file.createNewFile();
// -------------ЗАПИСЬ ОБЪЕКТА В ФАЙЛ-------------
				// Создается поток для записи объекта
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
				// Вводится информация о фильме
		System.out.println("Введите количество фильмов для записи в файл \n => ");
		int numberOfFilms = scanInt.nextInt();
		for(int i=0;i<numberOfFilms;i++) {
			System.out.println("Введите название фильма: ");
			String theNameOfTheFilm = scanStr.nextLine();
			System.out.println("Введите год выпуска фильма: ");
			int released = scanInt.nextInt();
			System.out.println("Введите страну производства: ");
			String theCountry = scanStr.nextLine();
			System.out.println("введите жанр этого фильма: ");
			String filmGenre = scanStr.nextLine();
			System.out.println("Введите стоимость проката: ");
			int rentalPrice = scanInt.nextInt();
		
			Film film = new Film(theNameOfTheFilm,released,theCountry,filmGenre,rentalPrice);
				// Объект записывается в файл
				oos.writeObject(film);
		}
				// Дописывается информация и закрывается файловый поток
		oos.flush();
		oos.close();
		
// Создать программным способом другой файл
		File file2 = new File("Task_3\\Example_Serial\\russian.txt");
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		FileOutputStream fos2 = new FileOutputStream(file2);
		ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
//	переписать в него информацию о фильмах, выпущенных в России		
		while(true) {
			try {		
				Film f = (Film) ois.readObject();
				String countryToCompare = f.theCountry;
				if(countryToCompare.equals("Russia") || countryToCompare.equals("russia") || countryToCompare.equals("Россия") || countryToCompare.equals("россия")) {
					oos2.writeObject(f);
				}
			}
			catch(EOFException e) {
				break;
			}
		}	
		oos2.flush();
		oos2.close();	
	}
}