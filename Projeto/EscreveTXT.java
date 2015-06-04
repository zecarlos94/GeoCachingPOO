import java.util.*;
import java.io.*;

public class EscreveTXT
{
    public static void escreveCaches(HashMap<Coordenadas,Cache> caches, String filename) throws IOException {
        PrintWriter pw = new PrintWriter(filename);
        Iterator<Map.Entry<Coordenadas, Cache>> it=caches.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Coordenadas, Cache> elem=it.next();
            pw.printf(elem.getKey().clone().toString()+ "       " +elem.getValue().clone().toString+ "\n");  
        }
        pw.flush();
        pw.close();
    }
    
    public static void escreveUsers(HashMap<String, Utilizador> utilizadores, String filename) throws IOException {
        PrintWriter pw = new PrintWriter(filename);
        Iterator<Map.Entry<String, Utilizador>> it=utilizadores.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Utilizador> elem=it.next();
            pw.printf(elem.getKey().clone().toString()+ "       " +elem.getValue().clone().toString+ "\n");
        }
        pw.flush();
        pw.close();
    }
}
