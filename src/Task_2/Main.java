package Task_2;

/*	—оздать проект, позвол€ющий из одного текстового файла, содержащего несколько строк 
	(тип String) заранее подготовленного текста на русском €зыке (обратитесь к классике),
	построчно переписать в другой текстовый файл слова, отвечающие условию.
		”словие:
			- переписать в результирующий файл слова, которые начинаютс€ с той же буквы, что и первое слово.
		“ребовани€:
			Ц слова из предложени€ выдел€ть методом split();
			Ц в новом файле следует указать номер строки, в которой искомые слова находились в исходном файле;
			Цдл€ каждой строки указать количество выбранных слов. */

import java.io.*;

public class Main {
	public static void main(String[] args) {
		File in = new File("inputText.txt");
		File out = new File("outputText.txt");
		int stringCounter = 0;
		int wordsCounter;
		String buffer;
		char firstLetterInALine;
		char firstLetterInAWord;
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(in),"UTF-8"));BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out),"UTF-8"))){
			for(;;) {
				buffer = br.readLine();
				wordsCounter = 0;
				stringCounter++;
				if(buffer==null) {
					break;
				}
				else {
					bw.write("Line " + stringCounter + ": ");
					String[]words = buffer.split(" ");
					firstLetterInALine =words[0].toLowerCase().charAt(0);
					for(int i=0;i<words.length;i++) {
						firstLetterInAWord = words[i].toLowerCase().charAt(0);
						if(firstLetterInAWord==firstLetterInALine) {
							wordsCounter++;
							bw.write(words[i] + " ");
						}
					}
				}
				bw.write(" - Matching words - " + wordsCounter + System.lineSeparator());
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}