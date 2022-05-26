package L_11_Examples;

// ������ �� ������ ����� � ������ � ������ ���� ������ ��������� � �������������� ������ � 1 ��������

import java.io.*;

public class L11_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =null;
		BufferedWriter out = null;
		try {
			// �������� �������� ���������� ������� ��� ������ � ������
			br = new BufferedReader(new FileReader("input.txt"),1024);	// ������ ������ 1024
			out = new BufferedWriter(new FileWriter("output.txt"));
			
			int lineCount = 0;
			String s;
			
			// ������������� ���������� �� ������ ����� � ������
			
			while((s=br.readLine())!= null) {
				lineCount++;
				System.out.println(lineCount + ": " + s);
				out.write(s);
				out.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error!!!");
		}
		finally {
			br.close();
			out.flush();
			out.close();
		}
	}
}