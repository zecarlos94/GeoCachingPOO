
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class ReadCSV {
  public static void main(String[] args) {
	BufferedReader br = null;
	try {
		String line;
		br = new BufferedReader(new FileReader("C:\\Users\\José Carlos\\Desktop\\query11.csv"));
		while ((line = br.readLine()) != null) {
		   System.out.println(line);
		   StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
		   while (stringTokenizer.hasMoreElements()) {
		    Integer id1 = Integer.parseInt(stringTokenizer.nextElement().toString());
		    Integer id2 = Integer.parseInt(stringTokenizer.nextElement().toString());
		    Integer id3 = Integer.parseInt(stringTokenizer.nextElement().toString());
			StringBuilder sb = new StringBuilder();
			sb.append("\nId1 : " + id1);
			sb.append("\nId2 : " + id2);
			sb.append("\nId3 : " + id3);
			sb.append("\n*******************\n");
			System.out.println(sb.toString());
		   }
		}
		System.out.println("Done");
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)
				br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
 }
}