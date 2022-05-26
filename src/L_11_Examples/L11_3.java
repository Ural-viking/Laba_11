package L_11_Examples;

/*	��������� � ������� �� ����� ���������� �� ���� ����������:
 	����� �� �����, ��������-�������� � ������� ������ ���� byte.
 	������� ���������, �������������� ���������.
 */
 
import java.io.*;
import java.net.*;

public class L11_3 {
	public static void readAllByByte(Reader in) throws IOException{
		while(true) {
			int oneByte = in.read();
			if(oneByte != -1) {
				System.out.print((char)oneByte);
			}
			else {
				System.out.print("\n" + "end");
				break;
			}
		}
	}
	
	public static void main (String[] args) {
		try {
			// � ������� ������ ����
			InputStream inFile = new FileInputStream("input.txt");
			Reader rFile = new InputStreamReader(inFile,"UTF-8");
			readAllByByte(rFile);
			System.out.print("\n\n\n");
			inFile.close();
			rFile.close();
			
			// � ������� ������� ��������-��������
			InputStream inUrl = new URL("http://google.com").openStream();
			Reader rUrl = new InputStreamReader(inUrl,"UTF-8");
			readAllByByte(rUrl);
			System.out.print("\n\n\n");
			inUrl.close();
			rUrl.close();
			
			// � ������� ������ ������ ���� byte
			InputStream inArray = new ByteArrayInputStream(new byte[] {5,8,3,9,11});
			Reader rArray = new InputStreamReader(inArray,"UTF-8");
			readAllByByte(rArray);
			System.out.print("\n\n\n");
			inArray.close();
			rArray.close();			
		}
		catch(IOException e){
			System.out.println("Error: " + e);
		}
	}
}