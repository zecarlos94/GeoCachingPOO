import java.util.*;
import java.io.*;
/**
 * This program demonstrates how to write characters to a text file
 * @author
 *
 */
public class Persistencia implements Serializable{
 public static void guardaBinario(GeoCaching e,String filename) throws IOException{
    FileOutputStream fos = new FileOutputStream(filename);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(e);/*empresaPOO*/
    oos.close();
 }
 
 public static GeoCaching leBinario(String filename) throws IOException, ClassNotFoundException{
    ObjectInputStream ois = new ObjectInputStream (new FileInputStream(filename));
    GeoCaching e = (GeoCaching) ois.readObject();
    ois.close();
    return e;
 }
}