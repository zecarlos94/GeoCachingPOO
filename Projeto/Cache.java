import java.util.*;

public abstract class Cache
{
    /**
     * Variáveis de Instância
     */

    protected TreeMap<Timeline,String> livro_registos;
    protected Timeline timeline;
    protected Coordenadas coordenadas;
    
    /**
     * Construtores
     */
    /*
    public Cache() {
        this.livro_registos=new HashMap<String, Data>();
        this.timeline=new Timeline();
        this.coordenadas=new Coordenadas();
    }
    */
   
    protected Cache() {
        this.livro_registos=new TreeMap<Timeline,String>(new TimelineComparator());
        this.timeline=new Timeline();
        this.coordenadas=new Coordenadas();
    }
    
   
    protected Cache(TreeMap<Timeline,String> livro_registos, Timeline t, Coordenadas coordenadas) throws NumberFormatException {
        this.livro_registos=new TreeMap<Timeline,String>(livro_registos);
        this.timeline=new Timeline(t);
        this.coordenadas=new Coordenadas(coordenadas);
    }

    protected Cache(Coordenadas coordenadas) {
        this.livro_registos=new TreeMap<Timeline,String>(new TimelineComparator());
        this.timeline=new Timeline();
        this.coordenadas=new Coordenadas(coordenadas);
    }
    /*
    public Cache(HashMap<String, Data> livro_registos, Data data, Hora hora, Coordenadas coordenadas) {
        this.livro_registos=new HashMap<String, Data>(livro_registos);
        this.timeline=new Timeline();
        this.coordenadas=new Coordenadas(coordenadas);
    }
    */
    protected Cache(Cache c) {
        this.livro_registos=c.getLivroRegistos();
        this.timeline=c.getTimeline();
        this.coordenadas=c.getCoordenadas();
    }
    
    /**
     * Getters
     */
    /*
    public HashMap<String, Data> getLivroRegistos() {
        return this.livro_registos;
    }
    */
   
    public TreeMap<Timeline,String> getLivroRegistos() {
        return this.livro_registos;
    }
    
    public Timeline getTimeline() {
        return this.timeline;
    }
    
    public Coordenadas getCoordenadas() {
        return this.coordenadas;
    }
    
    /**
     *  Verifica se um jogador já encontrou esta cache no passado
     */
    public boolean existe(String email){
        
            
        
        return this.livro_registos.containsValue(email);
    }
    

    
    /**
     * Setters
     */
    /*
    public void setLivroRegistos(HashMap<String, Data> livro_registos) {
        HashMap<String, Data> aux=new HashMap<String, Data>();
        Set<Map.Entry<String, Data>> eset=livro_registos.entrySet();
        Iterator<Map.Entry<String, Data>> it=eset.iterator();
        while(it.hasNext()) {
            Map.Entry<String, Data> elem=it.next();
            aux.put(elem.getKey(), elem.getValue().clone());
        }
        this.livro_registos=aux;
    }
    */
    
    public void setLivroRegistos(TreeMap<Timeline,String> lr) {
        TreeMap<Timeline,String> aux=new TreeMap<Timeline,String>(new TimelineComparator());
       
        Iterator<Map.Entry<Timeline, String>> it= lr.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Timeline, String> elem=it.next();
            aux.put(elem.getKey(), elem.getValue());
        }
        this.livro_registos =aux;
    }
   
    public void setCoordenadas(Coordenadas coordenadas) throws NumberFormatException {
        this.coordenadas=new Coordenadas(coordenadas);
    }
    
    public abstract Cache clone();

    /**
     * Equals
     */
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Cache c = (Cache) obj;
      return(this.livro_registos.equals(c.getLivroRegistos()) && this.timeline.equals(c.getTimeline()) && this.coordenadas.equals(c.getCoordenadas()));
    }
    

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Coordenadas:"+coordenadas.toString() +"\n");
        sb.append("Horas de criação:" + this.timeline.toString() + "\n" );
        sb.append("Livro de registos\n");
        Iterator<Map.Entry<Timeline,String>> it = this.livro_registos.entrySet().iterator();
        while(it.hasNext())
        {
            String email = it.next().getValue();
            Timeline time = it.next().getKey();
            sb.append("Horas:"+ time.toString() + "Utilizador:"+ email + "\n");
        }
        return sb.toString();
    }
    
    public void addLivroRegistos(String email, Timeline t) {
       this.livro_registos.put(t,email);
    }
  
    
}
