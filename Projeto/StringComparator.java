import java.util.Comparator;
import java.io.Serializable;

/**
 * Write a description of class StringComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringComparator implements Comparator<String>, Serializable
{
    public int compare(String s1,String s2)
    {
        return s1.compareTo(s2);
    }
}




