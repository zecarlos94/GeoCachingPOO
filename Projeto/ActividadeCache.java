
/**
 * Write a description of class ActividadeCache here.
 *
 *  Tem como objectivo principal gerar notificaçoes das actividades dos utilizadores quando interagem com uma cache:
 *          
 *   As notificações cobertas por esta classe são adições/remoções/descobertas de caches
 *   
 */
public class ActividadeCache extends Actividade
{
    private String acontecimento; // Acontecimento = "descobriu" || "removeu" || "adicionou"  
    private Cache cache;

    /**
     * Constructor for objects of class ActividadeCache
     *  Usa a hora do sistema
     */
    public ActividadeCache(String nome,Cache cache,String acontecimento)
    {
        super(nome);
        if(cache instanceof MultiCache) this.cache = new MultiCache((MultiCache)cache);
        if(cache instanceof MisteryCache) this.cache = new MisteryCache((MisteryCache)cache);
        if(cache instanceof MicroCache) this.cache = new MicroCache((MicroCache)cache);
        this.acontecimento = acontecimento;
        
    }
    
    public ActividadeCache(Timeline time,String nome,Cache cache,String acontecimento)
    {
        super(time,nome);
        if(cache instanceof MultiCache) this.cache = new MultiCache((MultiCache)cache);
        if(cache instanceof MisteryCache) this.cache = new MisteryCache((MisteryCache)cache);
        if(cache instanceof MicroCache) this.cache = new MicroCache((MicroCache)cache);
        this.acontecimento = acontecimento;
    }
    
    public ActividadeCache( ActividadeCache c)
    {
        super(c);
        this.cache = c.getCache();
        this.acontecimento = c.getAcontecimento();
    }
    
    public Cache getCache()
    {
        Cache clone = null;
        if(cache instanceof MultiCache) clone = ((MultiCache)cache).clone();
        if(cache instanceof MisteryCache) clone = ((MisteryCache)cache).clone();
        if(cache instanceof MicroCache) clone = ((MicroCache)cache).clone();
        return clone;
    }
   
    public String getAcontecimento()
    {
        return acontecimento;
    }
   
    public void setOrdem(String acontecimento)
    {
        this.acontecimento =acontecimento;
    }
    
    public ActividadeCache clone()
    {
        return new ActividadeCache(this);
    }
    
    /**
     *  Gera string com o seguinte formato:
     *      Tempo
     *          Nome Acontecimento NomeDaCache 
     *          
     *          Acontecimento = "descobriu" || "removeu" || "adicionou"  
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( super.toString() + " "); 
        sb.append( acontecimento + " ");
        sb.append( "uma" + cache.getClass().getName() );
            if(acontecimento.equals("descobriu") && (  cache instanceof MisteryCache || cache instanceof MultiCache))
                    sb.append(" e ganhou " + cache.getGeoCoins() + " GeoCoins");
        sb.append( "\n");
        return sb.toString();
    }

}
