package L_11_Examples;

//	��������� ������ �� ������ ����� � ������ � ������ ���� � �������������� ������ PrintWriter

import java.io.*;

public class L11_5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		PrintWriter out = null;
		try {
			// �������� �������
			br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"),"UTF-8"));
			out = new PrintWriter("output.txt","UTF-8");
			// ������������� ���������� �� ������ ����� � ������
			int lineCount = 0;
			String s;
			while((s=br.readLine())!=null) {
				lineCount++;
				out.println(lineCount + ": " + s);
			}
		}
		catch(IOException e) {
			System.out.println("Error!!! " +e);
		}
		finally {
			br.close();
			out.flush();
			out.close();
		}
	}
}