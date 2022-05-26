package Task_3;

/*	������ ����� ������������.
	�������:
			- �������� � �������� ���� ���������� � �������: ��������_������, ���_�������, ������, ����, ���������_�������. ���������� ������� ������ � ����������.
	������� ����������� �������� ������ ���� � ���������� � ���� ���������� � �������, ���������� � ������. */

import java.util.*;
import java.io.*;

class Film implements Serializable{
	String theNameOfTheFilm; //�������� ������
	int released;	// ���� ������ 
	String theCountry;	 // ������ ������������
	String filmGenre; // ����
	int rentalPrice; // ������
	
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
				// ��������� ���� �� �����
		File folder = new File("Task_3\\Example_Serial");
		folder.mkdirs();
		File file = new File("Task_3\\Example_Serial\\input.doc");
		file.createNewFile();
// -------------������ ������� � ����-------------
				// ��������� ����� ��� ������ �������
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
				// �������� ���������� � ������
		System.out.println("������� ���������� ������� ��� ������ � ���� \n => ");
		int numberOfFilms = scanInt.nextInt();
		for(int i=0;i<numberOfFilms;i++) {
			System.out.println("������� �������� ������: ");
			String theNameOfTheFilm = scanStr.nextLine();
			System.out.println("������� ��� ������� ������: ");
			int released = scanInt.nextInt();
			System.out.println("������� ������ ������������: ");
			String theCountry = scanStr.nextLine();
			System.out.println("������� ���� ����� ������: ");
			String filmGenre = scanStr.nextLine();
			System.out.println("������� ��������� �������: ");
			int rentalPrice = scanInt.nextInt();
		
			Film film = new Film(theNameOfTheFilm,released,theCountry,filmGenre,rentalPrice);
				// ������ ������������ � ����
				oos.writeObject(film);
		}
				// ������������ ���������� � ����������� �������� �����
		oos.flush();
		oos.close();
		
// ������� ����������� �������� ������ ����
		File file2 = new File("Task_3\\Example_Serial\\russian.txt");
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		FileOutputStream fos2 = new FileOutputStream(file2);
		ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
//	���������� � ���� ���������� � �������, ���������� � ������		
		while(true) {
			try {		
				Film f = (Film) ois.readObject();
				String countryToCompare = f.theCountry;
				if(countryToCompare.equals("Russia") || countryToCompare.equals("russia") || countryToCompare.equals("������") || countryToCompare.equals("������")) {
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