import java.util.*;

public abstract class Cache
{
    /**
     * Variáveis de Instância
     */

    protected HashMap<String, Timeline> livro_registos;
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
        this.livro_registos=new HashMap<String, Timeline>();
        this.timeline=new Timeline();
        this.coordenadas=new Coordenadas();
    }
    
   
    protected Cache(HashMap<String, Timeline> livro_registos, Timeline t, Coordenadas coordenadas) throws NumberFormatException {
        this.livro_registos=new HashMap<String, Timeline>(livro_registos);
        this.timeline=new Timeline(t);
        this.coordenadas=new Coordenadas(coordenadas);
    }

    protected Cache(Coordenadas coordenadas) {
        this.livro_registos=new HashMap<String, Timeline>();
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
        this.timeline=getTimeline();
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
   
    public HashMap<String, Timeline> getLivroRegistos() {
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
        return this.livro_registos.containsKey(email);
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
    
    public void setLivroRegistos(HashMap<String, Timeline> livro_registos) {
        HashMap<String, Timeline> aux=new HashMap<String, Timeline>();
        Set<Map.Entry<String, Timeline>> eset=livro_registos.entrySet();
        Iterator<Map.Entry<String, Timeline>> it=eset.iterator();
        while(it.hasNext()) {
            Map.Entry<String, Timeline> elem=it.next();
            aux.put(elem.getKey(), elem.getValue().clone());
        }
        this.livro_registos=aux;
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
        Iterator<Map.Entry<String,Timeline>> it = this.livro_registos.entrySet().iterator();
        while(it.hasNext())
        {
            sb.append("Horas:"+ it.next().getValue() + "Utilizador:"+ it.next().getKey() + "\n");
        }
        return sb.toString();
    }
    
}
