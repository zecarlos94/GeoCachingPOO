
import java.util.*;

public class MisteryCache extends Cache
{
    private ArrayList<ArrayList<String>> perguntasRespostas;
    private int geocoins;
    
    public MisteryCache() {
           super();
           perguntasRespostas=new ArrayList<ArrayList<String>>();
           geocoins=0;
    }
    
    public MisteryCache(HashMap<String,Timeline> livro_registos, Timeline timeline, Hora hora, Coordenadas coordenadas, ArrayList<ArrayList<String>> perguntasRespostas, int geocoins) {
            super(livro_registos,timeline,hora,coordenadas);
            setCheckpoints(perguntasRespostas);
            this.geocoins=geocoins;
    }
    
    public MisteryCache(MultiCache c){
            super(c);
            checkpoints=c.getCheckpoints();
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
        for(ArrayList<String> par : perguntasRespostas)
            for(String s : par)
                this.perguntasRespostas.add(s);
           
    }
    
    public MisteryCache clone() {
        return new MisteryCache(this);
    }
    
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      MisteryCache c = (MisteryCache) obj;
      if(this.livro_registos.equals(c.getLivroRegistos()) && this.data.equals(c.getData()) && this.hora.equals(c.getHora()) && this.coordenadas.equals(c.getCoordenadas()) && this.geocoins == c.getGeocoins() && this.checkpoints.equals(c.getCheckpoints())) return true;   
      else return false;
    }
}