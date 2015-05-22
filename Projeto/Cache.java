import java.util.*;

public class Cache
{
    /**
     * Variáveis de Instância
     */
    protected HashMap<String, Data> livro_registos;
    protected Data_Hora timeline;
    protected Coordenadas coordenadas;
    
    /**
     * Construtores
     */
    public Cache() {
        this.livro_registos=new HashMap<String, Data>();
        this.timeline=new Data_Hora();
        this.coordenadas=new Coordenadas();
    }
    
    public Cache(HashMap<String, Data> livro_registos, Data data, Hora hora, Coordenadas coordenadas) {
        this.livro_registos=new HashMap<String, Data>(livro_registos);
        this.timeline=new Data_Hora();
        this.coordenadas=new Coordenadas(coordenadas);
    }
    
    public Cache(Cache c) {
        this.livro_registos=c.getLivroRegistos();
        this.timeline=getData_Hora();
        this.coordenadas=c.getCoordenadas();
    }
    
    /**
     * Getters
     */
    public HashMap<String, Data> getLivroRegistos() {
        return this.livro_registos;
    }
    
    public Data_Hora getData_Hora() {
        return this.timeline;
    }
    
    public Coordenadas getCoordenadas() {
        return this.coordenadas;
    }
    
    /**
     * Setters
     */
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
    
    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas=new Coordenadas(coordenadas);
    }
    
    /**
     * Clone
     */
    public Cache clone() {
        return new Cache(this);
    }
    
    /**
     * Equals
     */
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Cache c = (Cache) obj;
      return(this.livro_registos.equals(c.getLivroRegistos()) && this.timeline.equals(c.getData_Hora()) && this.coordenadas.equals(c.getCoordenadas()));
    }
}
