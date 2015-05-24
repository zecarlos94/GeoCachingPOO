
import java.util.Random;
/**
 * Escreva a descrição da classe Random aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class geraAtmosfera
{
  public static String GeraAtmosfera() {
    Random r = new Random();
    int month = GeraMes();
    String monthString="N/A";
    switch (month) {
            case 1:  monthString=geraInverno();
                     break;
            case 2:  monthString=geraInverno();
                     break;
            case 3:  monthString=geraInverno();
                     break; 
            case 4:  monthString=geraVerao();
                     break;  
            case 5:  monthString=geraVerao();
                     break;
            case 6:  monthString=geraVerao();
                     break;
            case 7:  monthString=geraVerao();
                     break;
            case 8:  monthString=geraVerao();
                     break; 
            case 9:  monthString=geraVerao();
                     break;  
            case 10:  monthString=geraInverno();
                     break; 
            case 11:  monthString=geraInverno();
                     break;          
            case 12:  monthString=geraInverno();
                     break;          
        }
    return monthString;
 }
 
 public static int GeraMes() {
    Random rn = new Random();
    int mes = rn.nextInt(11) + 1;
    return mes;
  } 
  
 public static String geraInverno() {
    String estados[] = {"Nublado","Chuvas Fracas","Chuvas Fortes","Frio"};
    Random rn = new Random();
    int i = rn.nextInt(3) + 1;
    return estados[i];
 }
 
 public static String geraVerao() {
    String estados[] = {"Sol","Chuvas Fracas","Quente"};
    Random rn = new Random();
    int i = rn.nextInt(2) + 1;
    return estados[i];
 }
}