package Task_3;

/* 	������ � ������ � ������������ ��������/
	�������� � �������� ���� ���������� � �������:
	��������_������, ���_�������, ������, ����, ���������_�������. ���������� ������� ������ � ����������.
	������� ����������� �������� ������ ���� � ���������� � ���� ���������� � �������, ���������� � ������. */

import java.io.*;
import java.util.*;

public class example_with_RAF {
	public static void main(String[] args) {
//	�������� ����������� ������ � ����������		
		try {
			File folder = new File("Task_3\\Example_RAF");
			folder.mkdirs();
			File file = new File("Task_3\\Example_RAF\\input.doc");
			file.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(file,"rw");
			Scanner scan1 = new Scanner(System.in,"UTF-8");	//������ ��� �����
			Scanner scan2 = new Scanner(System.in,"UTF-8");	//������ ��� �����
			System.out.println("������� ���������� ������� ��� ������ � ���� \n => ");
			int numberOfFilms = scan1.nextInt();
			scan1.nextLine();	// ������� ������
			
			String theNameOfTheFilm, theCountry, filmGenre;
			int released, rentalPrice;
			
//	������ ���������� � ������� � ��������
			
			for(int i=1;i<=numberOfFilms;i++) {
				System.out.println("������� �������� " + i + " ������ => ");	// ��������� ��� ������������
				theNameOfTheFilm = scan2.next();	//	������ ��������� �������� ������
				raf.seek(raf.length());	//	����� ����� �����
				raf.writeUTF(theNameOfTheFilm);	// ������ � �������� �������� ������
				for(int j=0;j<20-theNameOfTheFilm.length();j++) {
					raf.writeByte(1);	// ���������� ������ �� 20-�� ����� ������ 1
				}
				System.out.println("������� ��� ������� ������ => ");
				released = scan1.nextInt();	//	������ ��������� ���
				raf.writeInt(released); //	������ ���� ������� ������ � ��������
				System.out.println("������� ������ ������������ ������ => ");
				theCountry = scan2.next();
				raf.writeUTF(theCountry);
				for(int j=0;j<20-theCountry.length();j++) {
					raf.writeByte(1);
				}
				System.out.println("������� ���� ������ => ");
				filmGenre = scan2.next();
				raf.writeUTF(filmGenre);
				for(int j=0;j<20-filmGenre.length();j++) {
					raf.writeByte(1);
				}
				System.out.println("������� ������ ������ => ");
				rentalPrice = scan1.nextInt();
				raf.writeInt(rentalPrice);
			}
		raf.close();
		
// ������� ����������� �������� ������ ���� � ������� ����� ���������� ���������� ������
		
			File file2 = new File("Task_3\\Example_RAF\\russian.txt");
			file2.createNewFile();
		
// ��������� �� ������ ���� ���������� ������
		
			raf = new RandomAccessFile(file,"r");
			raf.seek(0);
			PrintWriter pw = new PrintWriter(file2);
			pw.print("�������� \t\t ��� ������� \t\t ������ \t\t ���� \t\t ��������� �������" );
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
				
				if(theCountry.equals("Russia") || theCountry.equals("russia") || theCountry.equals("������") ||theCountry.equals("������")) {
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