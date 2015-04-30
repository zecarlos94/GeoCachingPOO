import java.util.Comparator;
import java.io.Serializable;

/**
 * Classe fundamental para ordenar a TreeMap de atividades, pois utiliza um comparador de datas
 */
public class DateComparator implements Comparator<Date>, Serializable
{
    /**
     * Compara duas datas
     */
    public int compare(Date d1, Date d2) {
        if(d1.getYear()>d2.getYear()) return -1;
        if(d1.getYear()<d2.getYear()) return 1;
        if(d1.getYear()==d2.getYear() && d1.getMonth()>d2.getMonth()) return -1;
        if(d1.getYear()==d2.getYear() && d1.getMonth()<d2.getMonth()) return 1;
        if(d1.getYear()==d2.getYear() && d1.getMonth()==d2.getMonth() && d1.getDay()>d2.getDay()) return -1;
        if(d1.getYear()==d2.getYear() && d1.getMonth()==d2.getMonth() && d1.getDay()<d2.getDay()) return 1;
        else return 0;
    }
}
