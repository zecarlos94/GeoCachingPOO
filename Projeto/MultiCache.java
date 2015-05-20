import java.util.*;

public class MultiCache extends Cache
{
    private ArrayList<Coordenadas> checkpoints;
    private int geocoins;
    
    public MultiCache() {
           super();
           checkpoints=new ArrayList<Coordenadas>();
           geocoins=0;
    }
    
    public MultiCache(HashMap<String, Data> livro_registos, Data data, Hora hora, Coordenadas coordenadas, ArrayList<Coordenadas> checkpoints, int geocoins) {
            super(livro_registos,data,hora,coordenadas);
            setCheckpoints(checkpoints);
            this.geocoins=geocoins;
    }
    
    public MultiCache(MultiCache c){
            super(c);
            checkpoints=c.getCheckpoints();
            geocoins=c.getGeocoins();
    }
    
    public int getGeocoins(){
        return geocoins;
    }
    
    public ArrayList<Coordenadas> getCheckpoints(){
        ArrayList<Coordenadas> r=new ArrayList<Coordenadas>();
        for(Coordenadas c : checkpoints) r.add(c.clone());
        return r;
    }
    
    public void setGeocoins(int coins){
        this.geocoins=coins;
    }
    
    public void setCheckpoints(ArrayList<Coordenadas> pontos){
        this.checkpoints = new ArrayList<Coordenadas>();
        for(Coordenadas c : pontos) this.checkpoints.add(c.clone());
    }
    
    /**
     * Devolve as coordenadas do próximo checkpoint, se existir
     */
    public Coordenadas nextPoint(Coordenadas c) {
        int done=1;	
        Coordenadas r = null;
        Iterator<Coordenadas> it=this.checkpoints.iterator();
        while(it.hasNext()) {
            Coordenadas elem = it.next();
	if(done==2) {r = new Coordenadas(elem); done = 0;}		
	if(c.equals(elem)) done = 2;
        }
        return r;
    }
    
    /**
     * Verifica se as coordenadas dadas são as da cache final
     */
    public boolean checkMC(Coordenadas c) {
        return super.coordenadas.equals(c);
    }

    public MultiCache clone() {
        return new MultiCache(this);
    }
    
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      MultiCache c = (MultiCache) obj;
      if(this.livro_registos.equals(c.getLivroRegistos()) && this.data.equals(c.getData()) && this.hora.equals(c.getHora()) && this.coordenadas.equals(c.getCoordenadas()) && this.geocoins == c.getGeocoins() && this.checkpoints.equals(c.getCheckpoints())) return true;   
      else return false;
    }
    
}
