package L_11_Examples;

/*	������ � ��������� ������� � ����� � ������������ ��������.
	��������� ��������� ���������:
				� �������� � ���� �������� ���������� ����� ����� (1 �����=4 �����);
				� ��������� ������ � ������ � �������� �������;
				� �������� ���������� � ����� � ��������� �� ����� � ����� ����� ������;
				� ������������� �� ����������� ����� ��������������� � �����. */

import java.util.*;
import java.io.*;

public class L11_6 {
	public static void main(String[] args) {
		try {
			// �������� ����� �My� �� �����, ���� ��� �� ���������� � ����� � �����
			File folder = new File("My");
			if(!folder.exists()) folder.mkdir();
			File f1 = new File("My\\input.txt");
			f1.createNewFile();
			
			Scanner sc = new Scanner(System.in,"UTF-8");
			System.out.print("������� ����� ���� �������� � ����? \\n =>");
			int count = sc.nextInt();	// ������ ���������� �����
			
			// ������� ���� ������������ ��� ������ � ������ "rw"
			RandomAccessFile rf = new RandomAccessFile(f1,"rw");
			System.out.println("�������� ������ ����� � ������ =" + rf.length() + ", ��������� ����� �� " + rf.getFilePointer() + "-� �����" );
			System.out.println("������� �����:");
			for(int i=0;i<count;i++) {
				rf.writeInt(sc.nextInt());	// �������� ����� � ����. �� ������ ����� ���� int ���������� 4 �����
			}
			System.out.println("����� ������ ����� � ������ =" + rf.length() + ", ��������� ����� �� " + rf.getFilePointer() + "-� �����");
			System.out.println("���������� ���� �� 1 ����� = " + rf.length() / count);
			rf.close();
			
			// ��������� ����� �� ����� � ������� �� �����
			rf = new RandomAccessFile(f1,"r");
			System.out.println("����� � �����:");
			for(int i=0;i<count;i++) {
				rf.seek(i*4);	// ������� ��������� �� ������� ����� i*4 �����. � ������ �������� ��� ���������������� ���������� �������� seek() ����� ���� �� ������������
				System.out.println("�����" + i + ": " + rf.readInt());
			}
			
			System.out.println("����� � �������� �������:");
			for(int i=count-1;i>=0;i--) {
				rf.seek(i*4);
				System.out.println("�����" + i + ": " + rf.readInt());
			}
			
			rf.seek(rf.getFilePointer()-4);	//������� ��������� �� ��������� �����
			System.out.println(" ���������� ����� � �����= " + rf.length()/4 + ", ��������� �����= " + rf.readInt());
			
			// ����� ��������� ����� � ����� � ����������� ��� ������ (�������)
			System.out.print("������� �����, ������� ����� ����� � ����� =>");
			int x = sc.nextInt();
			int kol = 0;
			for(int i=0;i<count;i++) {
				rf.seek(i*4);
				int number = rf.readInt();
				if(number==x) {
					kol++;
					System.out.print("����� " + i + ",");
				}
			}
			
			System.out.println(" ���������� ������� ����� = " + kol);
			rf.close();
			
			// ���������� ����� � ����� ������� ����������
			rf = new RandomAccessFile(f1, "rw");
			for(int k=0;k<count;k++) {
				for(int i=0;i<count-k-1;i++) {
					rf.seek(i*4);
					int number1 = rf.readInt();
					int number2 = rf.readInt();
					
					if(number1>number2) {
						rf.seek(i*4);
						rf.writeInt(number2);
						rf.writeInt(number1);
					}
				}
			}
			System.out.println("�����, ��������������� � �����:");
			for(int i=0;i<count;i++) {
				rf.seek(i*4);
				System.out.print(" " + rf.readInt());
			}
			rf.close();
		}
		catch (IOException e) {
			 System.out.println("End of file " + e);
			 e.printStackTrace();
		}
	}
}