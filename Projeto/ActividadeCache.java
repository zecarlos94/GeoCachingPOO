
/**
 * Write a description of class ActividadeCache here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActividadeCache extends Actividade
{
    private String ordem; // Acontecimento = "descobriu" || "removeu" || "adicionou"  
    private Cache cache;

    /**
     * Constructor for objects of class ActividadeCache
     *  Usa a hora do sistema
     */
    public ActividadeCache(String nome,Cache cache,String ordem)
    {
        super(nome);
        this.cache = new Cache(cache);
        this.ordem = ordem;
        
    }
    
    public ActividadeCache(Timeline time,String nome,Cache cache,String ordem)
    {
        super(time,nome);
        this.cache = new Cache(cache);
        this.ordem = ordem;
    }
    
    public ActividadeCache( ActividadeCache c)
    {
        super(c);
        this.cache = c.getCache();
        this.ordem = c.getOrdem();
    }
    
    public Cache getCache()
    {
        return cache.clone();
    }
    
    public String getOrdem()
    {
        return ordem;
    }
    
    public void setCache(Cache cache)
    {
        this.cache = cache.clone();
    }
    
    public void setOrdem(String ordem)
    {
        this.ordem =ordem;
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
        sb.append( ordem + " ");
        sb.append( "uma" + cache.getClass().getName() + "\n");
        return sb.toString();
    }

}
