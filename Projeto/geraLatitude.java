import java.util.*;
/**
 * Escreva a descrição da classe teste aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class geraLatitude
{
    public static int GeraNumeros() {
    Random rn = new Random();
    int answer = rn.nextInt(180) + 1;
    return answer;
  }
}
