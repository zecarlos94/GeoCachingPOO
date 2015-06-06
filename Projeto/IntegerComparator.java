
import java.util.Comparator;
import java.io.Serializable;

/**
 *  Ordem decrescente
 * 
 */
public class IntegerComparator implements Comparator<Integer>, Serializable
{
    public int compare(Integer d1,Integer d2)
    {
        if(d1<d2) return 1;
        if(d1 > d2) return -1;
        return 1;
    }
}
