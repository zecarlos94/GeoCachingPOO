
/**
 *  EmailCache e uma classe com um par usado para a estrutura activities
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmailCache
{
     // Email
    private String email;
    
    // Cache
    private Cache cache;
  
    /**
     * Constructor for objects of class EmailCache
     */
    public EmailCache()
    {
        cache = new Cache();
        email = "N/A";
    }
    
    public EmailCache(String email,Cache cache)
    {
        cache = new Cache(cache);
        email = email;
    }

    public EmailCache(EmailCache emailcache)
    {
        cache = emailcache.getCache();
        email = emailcache.getEmail();
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getEmail()
    {
        return email;
     }
    
    public Cache getCache()
    {
        return cache.clone();
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setCache(Cache cache)
    {
        cache = cache.clone();
    }
    
    public EmailCache clone(EmailCache ec)
    {
        return new EmailCache(ec);
    }
    
    public boolean equals(Object obj)
    {
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      EmailCache ec = (EmailCache) obj;
      return( this.email.equals(ec.getEmail()) && this.cache.equals(ec.getCache()));
    }
    
    //Falta o toString 
}
