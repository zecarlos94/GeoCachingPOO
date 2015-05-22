
import java.util.*;
//import java.lang.*;

public class MisteryCache extends Cache
{
    private ArrayList<ArrayList<String>> perguntasRespostas;
    private int geocoins;
    
    public MisteryCache() {
           super();
           perguntasRespostas=new ArrayList<ArrayList<String>>();
           geocoins=0;
    }
    
    public MisteryCache(HashMap<String,Timeline> livro_registos, Timeline timeline, Coordenadas coordenadas, ArrayList<ArrayList<String>> perguntasRespostas, int geocoins) {
            super(livro_registos,timeline,coordenadas);
            setPerguntasRespostas(perguntasRespostas);
            this.geocoins=geocoins;
    }
    
    public MisteryCache(MisteryCache c){
            super(c);
            perguntasRespostas =c.getPerguntasRespostas();
            geocoins=c.getGeocoins();
    }
    
    
    public int getGeocoins(){
        return geocoins;
    }
    
    
    public ArrayList<ArrayList<String>> getPerguntasRespostas(){
        return perguntasRespostas;
    }
    
    public void setGeocoins(int coins){
        this.geocoins=coins;
    }
    
    public void setPerguntasRespostas(ArrayList<ArrayList<String>> perguntasRespostas){
        this.perguntasRespostas = new ArrayList<ArrayList<String>>();
        for(ArrayList<String> par : perguntasRespostas){
            par = new ArrayList<String>(2);
            for(String s : par)
                par.add(s);
            this.perguntasRespostas.add(par);
        }
    }
    
    public MisteryCache clone() {
        return new MisteryCache(this);
    }
    
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      MisteryCache c = (MisteryCache) obj;
      if( super.equals(obj) && this.geocoins == c.getGeocoins() && this.perguntasRespostas.equals(c.getPerguntasRespostas())) return true;   
      else return false;
    }
}