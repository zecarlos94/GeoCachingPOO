import java.util.*;

public class MultiCache extends Cache implements Tesouro 
{
    private ArrayList<Coordenadas> checkpoints;
    private int geocoins; // esta variável representa os geoCoins minimos da cache e são sempre entre 50-100
    
    public MultiCache() {
           super();
           checkpoints=new ArrayList<Coordenadas>();
           geocoins=(new geraGeoCoins()).getGeoCoins();
    }
    
    public MultiCache(HashMap<String,Timeline> livro_registos, Timeline timeline, Coordenadas coordenadas, ArrayList<Coordenadas> checkpoints, int geocoins) throws NumberFormatException {
            super(livro_registos,timeline,coordenadas);
            setCheckpoints(checkpoints);
            this.geocoins=geocoins;
    }
    
    public MultiCache(Coordenadas coordenadas,ArrayList<Coordenadas> checkpoints) throws NumberFormatException {
            super(coordenadas);
            setCheckpoints(checkpoints);
            this.geocoins=(new geraGeoCoins()).getGeoCoins();
    }

    public MultiCache(MultiCache c) throws NumberFormatException {
            super(c);
            checkpoints=c.getCheckpoints();
            geocoins=c.getGeoCoins();
    }
    /**
     *  Devolve os geoCoins base
     */
    public int getGeoCoins(){
        return geocoins;
    }
    
    /**
     *  Devolve o total de geoCoins fraturados pelo utilizador que depende dos geoCoins base e do numero de checkpoints
     */
    public int getGeoCoinsTotais()
    {
        return this.geocoins + ((this.geocoins / 2) * (checkpoints.size() - 1));
    }
    
    public ArrayList<Coordenadas> getCheckpoints(){
        ArrayList<Coordenadas> r=new ArrayList<Coordenadas>();
        for(Coordenadas c : checkpoints) r.add(c.clone());
        return r;
    }
    
    public void setGeoCoins(int coins) throws NumberFormatException {
        this.geocoins=coins;
    }
    
    public void setCheckpoints(ArrayList<Coordenadas> pontos) throws NumberFormatException {
        this.checkpoints = new ArrayList<Coordenadas>();
        for(Coordenadas c : pontos) this.checkpoints.add(c.clone());
    }
    
    /**
     *  Calcula a distancia percorrida do trajeto das coordenadas recebidas ate a cache final, passando por todos os checkpoints
     */
    
    public double distanciaPercorrida(Coordenadas coordenadasIniciais)
    {
        double distancia = 0;
        Coordenadas cAnteriores = coordenadasIniciais;
        for(Coordenadas c : this.checkpoints){
            distancia+= cAnteriores.distance(c);
            cAnteriores = c;
        }
        distancia+= cAnteriores.distance(super.coordenadas);
        return distancia;
        
    }
    
    /**
     * Devolve as coordenadas do próximo checkpoint, se existir
     */
    public Coordenadas nextPoint(Coordenadas c) {
        boolean done=false; 
        Coordenadas r = null;
        Iterator<Coordenadas> it=this.checkpoints.iterator();
        while(it.hasNext()) {
            Coordenadas elem = it.next();
            if(done) {r = new Coordenadas(elem); break;}     
            if(c.equals(elem)) done = true;
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
      if( super.equals(obj)  && this.geocoins == c.getGeoCoins() && this.checkpoints.equals(c.getCheckpoints())) return true;   
      else return false;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo: MultiCache\n" + super.toString());
        sb.append("Coordenadas dos check points\n");
        
        for(Coordenadas cp : this.checkpoints )
            sb.append( cp.toString() + "\n");
        
        sb.append("Tesouro máximo:" + getGeoCoinsTotais() + "\n");
        
        return sb.toString();
    }
    
}
