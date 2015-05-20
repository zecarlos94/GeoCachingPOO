import java.util.*;
/**
 * Escreva a descrição da classe geraLongitude aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class geraLongitude
{
  public static int GeraNumeros() {
    Random rn = new Random();
    int answer = rn.nextInt(360) + 1;
    return answer;
  }
}
