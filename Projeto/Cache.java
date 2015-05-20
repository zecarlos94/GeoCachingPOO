import java.util.*;

public class Cache
{
    /**
     * Variáveis de Instância
     */
    protected HashMap<String, Data> livro_registos;
    protected Data data;
    protected Hora hora;
    protected Coordenadas coordenadas;
    
    /**
     * Construtores
     */
    public Cache() {
        this.livro_registos=new HashMap<String, Data>();
        this.data=new Data();
        this.hora=new Hora();
        this.coordenadas=new Coordenadas();
    }
    
    public Cache(HashMap<String, Data> livro_registos, Data data, Hora hora, Coordenadas coordenadas) {
        this.livro_registos=new HashMap<String, Data>(livro_registos);
        this.data=new Data(data);
        this.hora=new Hora(hora);
        this.coordenadas=new Coordenadas(coordenadas);
    }
    
    public Cache(Cache c) {
        this.livro_registos=c.getLivroRegistos();
        this.data=c.getData();
        this.hora=c.getHora();
        this.coordenadas=c.getCoordenadas();
    }
    
    /**
     * Getters
     */
    public HashMap<String, Data> getLivroRegistos() {
        return this.livro_registos;
    }
    
    public Data getData() {
        return this.data;
    }
    
    public Hora getHora() {
        return this.hora;
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
    
    public void setData(Data data) {
        this.data=new Data(data);
    }
    
    public void setHora(Hora hora) {
        this.hora=new Hora(hora);
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
      return(this.livro_registos.equals(c.getLivroRegistos()) && this.data.equals(c.getData()) && this.hora.equals(c.getHora()) && this.coordenadas.equals(c.getCoordenadas()));
    }
}
