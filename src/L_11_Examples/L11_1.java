package L_11_Examples;

// ������ �� ������ ����� � ������ � ������ ���� ������ �����������.

import java.io.*;

public class L11_1 {
	public static void main(String[] args) throws IOException{	// ����� main ���������� ���������e
		Reader in = null;	// ����� ����� �������� FileReader in=null; 
		Writer out = null;	// ����� ����� �������� FileWriter out =null;
		try {
			in = new FileReader("input.txt");	// ���� ��� ������ ������
			out = new FileWriter("output.txt");	// ���� ��� ������ c ����������� ���������� ������
			// ������ ����������� � ������������ ��������, ��� � ��� InputStream/OutputStream
			int oneByte;	// ����������, � ������� ����������� ������
			while ((oneByte = in.read())!= -1) {
				// out.write((char)oneByte);  // ������ � ������������ ����� ������������ ������
				out.append((char)oneByte);	// ������ � ����������� ������ � �����
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