import java.util.Comparator;
import java.io.Serializable;

/**
 * Escreva a descrição da classe HoraComparator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
   public class HoraComparator implements Comparator<Hora>, Serializable
{
    /**
     * Compara duas datas
     */
    public int compare(Timeline d1, Timeline d2) {
        if(d1.getHora()>d2.getHora()) return -1;
        if(d1.getHora()<d2.getHora()) return 1;
        if(d1.getHora()==d2.getHora() && d1.getMinuto()>d2.getMinuto()) return -1;
        if(d1.getHora()==d2.getHora() && d1.getMinuto()<d2.getMinuto()) return 1;
        if(d1.getHora()==d2.getHora() && d1.getMinuto()==d2.getMinuto() && d1.getSegundo()>d2.getSegundo()) return -1;
        if(d1.getHora()==d2.getHora() && d1.getMinuto()==d2.getMinuto() && d1.getSegundo()<d2.getSegundo()) return 1;
        else return 0;
    }
}
