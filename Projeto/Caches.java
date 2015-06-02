import java.util.*;
/**
 * Classe caches contem a informação de todas as caches activas 
 *  A chave usada é as coordenadas da cache
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caches
{
    // instance variables - replace the example below with your ow
    private HashMap<Coordenadas,Cache> caches;
    
     /**
     * Constructor for objects of class Caches
     */
    public Caches()
    {
        caches = new HashMap<Coordenadas,Cache>();
    }

    public Caches(HashMap<Coordenadas,Cache> caches)
    {
        setCaches(caches);
    }
    
    public Caches(Caches c)
    {
        caches = c.getCaches();
    }
    
    public HashMap<Coordenadas,Cache> getCaches()
    {
        HashMap<Coordenadas,Cache> resultado = new HashMap<Coordenadas,Cache>();
        Iterator<Map.Entry<Coordenadas,Cache>> it = caches.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Coordenadas,Cache> elem = it.next();
            resultado.put(elem.getKey(),elem.getValue().clone());
        }
        return resultado;
        
    }
    
    public void setCaches(HashMap<Coordenadas,Cache> caches)
    {
          HashMap<Coordenadas,Cache> resultado = new HashMap<Coordenadas,Cache>();
        Iterator<Map.Entry<Coordenadas,Cache>> it = caches.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Coordenadas,Cache> elem = it.next();
            resultado.put(elem.getKey(),elem.getValue().clone());
        }
        this.caches = resultado;
    }
    
    public int size() { return this.caches.size();}
    
    /**
     *  Adiciona uma cache
     */
    public void add(Cache c)
    {
        caches.put(c.getCoordenadas(),c.clone());
    }
    /**
     *  Remove / Invalida uma cache
     */
    public void remove(Cache c)
    {
        caches.remove(c.getCoordenadas());
    }
    /**
     *  Remove cache apartir das suas coordenadas
     */
    public void remove(Coordenadas coordenadas)
    {
        caches.remove(coordenadas);
    }
    
    /**
     *  Verifica se a cache existe
     */
    public boolean existe(Cache c) 
    {
        return caches.containsKey(c.getCoordenadas());
    }
    
    public boolean existe(Coordenadas c) 
    {
        return caches.containsKey(c);
    }
    
    
    public Caches clone()
    {
        return new Caches(this);
    }
    
    public boolean equals(Object obj)
    {
       if(this == obj) return true;  // é o próprio
       if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Caches c = (Caches) obj;
      return this.caches.equals(c.getCaches());
    }
    
    public String toString() {
        return new String(this.caches.toString());
    }
    
    public Cache cacheMaisPerto(Coordenadas coord) {
        Cache aux = null;
        
        double dist = Double.MAX_VALUE;
        
        Iterator<Map.Entry<Coordenadas,Cache>> it = caches.entrySet().iterator();
        
        while(it.hasNext()) {
            Map.Entry<Coordenadas,Cache> elem=it.next();
            double distancia = elem.getKey().distance(coord);
            if(distancia<dist) {
                dist=distancia;
                aux=elem.getValue().clone();
            }
        }
        return aux;
    }
}
