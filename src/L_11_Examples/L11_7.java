package L_11_Examples;

//	��������� ������ ����� � ������ �� �� ����� � ������������ ��������.


import java.io.*;
import java.util.*;

public class L11_7 {
	public static void main(String[] args) {
		try {
			File folder = new File("Example_7");
			if(!folder.exists()) folder.mkdir();
			File file = new File("Example_7\\string_for_example.txt");
			
			Scanner scan = new Scanner(System.in);
			System.out.print("������� ����� ���� �������� � ����? \n =>");
			int count =scan.nextInt();
			scan.nextLine();
			
			RandomAccessFile raf = new RandomAccessFile(file,"rw");
			raf.setLength(0);
			long len = raf.length();
			System.out.println("������ ���� �������� "+ len + " ����");
			System.out.println("������� ������:");
			int kol = 0;
			// �������� ������ � ����
			for(int i=0;i<count;i++) {
				raf.seek(raf.length());
				String s = scan.nextLine();
				raf.writeUTF(s);
				kol+=s.length();
			}
			len = raf.length();
			System.out.println("������ ����� � ������ = " + len);
			raf.close();
			// ������� ���� ��� ������ "r"
			raf = new RandomAccessFile(file,"r");
			// ����� ����� �� ����� �� �����
			System.out.println("������ �� �����:");
			raf.seek(0); // ��������� ��������� � ������ ����� (�� ������ �����)
			for (int i = 0; i < count; i++)
			System.out.println("������ " + i +" ���������� � ����� " + raf.getFilePointer() + " - " + raf.readUTF() + " - ������������� ������ " + (raf.getFilePointer()-1));
			raf.close();
		}
		catch(IOException e){
			System.out.println("End of file " +e);
		}
	}
}