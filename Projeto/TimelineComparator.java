import java.util.Comparator;
import java.io.Serializable;

/**
 * Classe fundamental para ordenar a TreeMap de atividades, pois utiliza um comparador de tempo
 */
public class TimelineComparator implements Comparator<Timeline>, Serializable
{
    /**
     * Compara duas datas
     */
    public int compare(Timeline d1, Timeline d2) {
        //anos
        if(d1.getYear()>d2.getYear()) return 1;
        if(d1.getYear()<d2.getYear()) return -1;
        //meses
        if(d1.getYear()==d2.getYear() && d1.getMonth()>d2.getMonth()) return 1;
        if(d1.getYear()==d2.getYear() && d1.getMonth()<d2.getMonth()) return -1;
        //dias
        if(d1.getYear()==d2.getYear() && d1.getMonth()==d2.getMonth() && d1.getDay()>d2.getDay()) return 1;
        if(d1.getYear()==d2.getYear() && d1.getMonth()==d2.getMonth() && d1.getDay()<d2.getDay()) return -1; 
        
        if ( !( d1.isData() && d2.isData()))
        {
        //horas    
        if(d1.getYear()==d2.getYear() && d1.getMonth()==d2.getMonth() && d1.getDay()==d2.getDay() && d1.getHora()>d2.getHora()) return 1;
        if(d1.getYear()==d2.getYear() && d1.getMonth()==d2.getMonth() && d1.getDay()==d2.getDay() && d1.getHora()<d2.getHora()) return -1;
        //minutos
        if(d1.getYear()==d2.getYear() && d1.getMonth()==d2.getMonth() && d1.getDay()==d2.getDay() && d1.getHora()==d2.getHora() && d1.getMinuto()>d2.getMinuto()) return 1;
        if(d1.getYear()==d2.getYear() && d1.getMonth()==d2.getMonth() && d1.getDay()==d2.getDay() && d1.getHora()==d2.getHora() && d1.getMinuto()<d2.getMinuto()) return -1;
        //segundos
        if(d1.getYear()==d2.getYear() && d1.getMonth()==d2.getMonth() && d1.getDay()==d2.getDay() && d1.getHora()==d2.getHora() && d1.getMinuto()==d2.getMinuto() && d1.getSegundo()>d2.getSegundo()) return 1;
        if(d1.getYear()==d2.getYear() && d1.getMonth()==d2.getMonth() && d1.getDay()==d2.getDay() && d1.getHora()==d2.getHora() && d1.getMinuto()==d2.getMinuto() && d1.getSegundo()<d2.getSegundo()) return -1;
       }
        
       return 1;
//       return 0;
    }
}
