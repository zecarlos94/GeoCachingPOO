
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
 

public class CreateTXT {
 
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\José Carlos\\Desktop\\Test.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            bufferedWriter.write("Olá");
            bufferedWriter.newLine();
            bufferedWriter.write("POO/LI3!!!");
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}