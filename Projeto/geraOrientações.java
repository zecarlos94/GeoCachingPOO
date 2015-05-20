
import java.util.Random;
/**
 * Escreva a descrição da classe Random aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class geraOrientações
{
  public static char GeraNumeros() {
    final String alphabet = "NSEW";
    final int N = alphabet.length();
    Random r = new Random();
    /*System.out.println(alphabet.charAt(r.nextInt(N)));*/
    return alphabet.charAt(r.nextInt(N));
 }
}
