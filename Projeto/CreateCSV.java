
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
 

public class CreateCSV {
 
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\José Carlos\\Desktop\\Test.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write("Mês");
            bufferedWriter.newLine();
            bufferedWriter.write("12");
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}