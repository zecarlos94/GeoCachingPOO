
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class ReadTXT {
  public static void main(String[] args) {
	BufferedReader br = null;
	try {
		String line;
		br = new BufferedReader(new FileReader("../Desktop/compras.txt"));
		while ((line = br.readLine()) != null) {
		   System.out.println(line);
		   StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
		   while (stringTokenizer.hasMoreElements()) {
		    String product_code = stringTokenizer.nextElement().toString();
		    Double price = Double.parseDouble(stringTokenizer.nextElement().toString());
		    Integer quantity = Integer.parseInt(stringTokenizer.nextElement().toString());
		    String purchase_mode = stringTokenizer.nextElement().toString();
		    String client_code = stringTokenizer.nextElement().toString();
		    Integer month = Integer.parseInt(stringTokenizer.nextElement().toString());
		    
			StringBuilder sb = new StringBuilder();
			
			sb.append("\nProduct Code: " + product_code);
			sb.append("\nPrice: " + price);
			sb.append("\nQuantity: " + quantity);
			sb.append("\nPurchase Mode: " + purchase_mode);
			sb.append("\nClient Code: " + client_code);
			sb.append("\nMonth : " + month);
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