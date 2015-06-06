import java.util.*;
import java.io.*;

public class EscreveTXT
{
    public void escreveCaches(Caches caches, String filename) throws IOException {
        PrintWriter pw = new PrintWriter(filename);
        Iterator<Map.Entry<Coordenadas, Cache>> it=caches.iterator();
        int i=1;
        while(it.hasNext()) {
            Map.Entry<Coordenadas, Cache> elem=it.next();
            pw.printf( "Cache N"+ i + "\n" +elem.getValue().toString()+ "\n");  
            i++;
        }
        pw.flush();
        pw.close();
    }
    
    
    public void escreveUsers(Utilizadores utilizadores, String filename) throws IOException {
        PrintWriter pw = new PrintWriter(filename);
        int i = 1;
        Iterator<Map.Entry<String, Utilizador>> it=utilizadores.iterator();
        while(it.hasNext()) {
            Map.Entry<String, Utilizador> elem=it.next();
            pw.printf(" Utilizador N " + i + "\n" +elem.getValue().toString()+ "\n");
            i++;
        }
        pw.flush();
        pw.close();
    }
}
