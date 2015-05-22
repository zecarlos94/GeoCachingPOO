
/**
 * Write a description of class Coordenada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordenada
{
    // instance variables - replace the example below with your own
    private int graus;
    
    private int minutos;
    
    private int segundos;

    /**
     * Constructor for objects of class Coordenada
     */
    public Coordenada()
    {
        graus = 0;
        minutos = 0;
        segundos = 0;
    }
    public Coordenada(int graus,int minutos,int segundos)
    {
        graus = graus;
        minutos = minutos;
        segundos = segundos;
    }
    public Coordenada(Coordenada c)
    {
        graus = c.getGraus();
        minutos = c.getMinutos();
        segundos = c.getSegundos();
    }
    
    public int getGraus()
    { return graus;}
    
    public int getMinutos()
    {
        return minutos;
    }
    
    public int getSegundos()
    { return segundos;}
    
    public void setGraus()
    {
       graus = graus;   
    }
    
    public void setMinutos()
    {
        minutos = minutos;
    }
    
    public void setSegundos()
    {
        segundos = segundos;
    }
    
    public Coordenada clone()
    {
        return new Coordenada(this);
    }
    
    public String toString()
    {
        return new String( graus + ":" + minutos + ":" + segundos);
    }
    
    public boolean equals(Object obj)
    {
       if(this == obj) return true;  // é o próprio
       if((obj == null) || (this.getClass() != obj.getClass())) return false;
       Coordenada c = (Coordenada) obj;
      return(this.graus == c.getGraus() && this.minutos == c.getMinutos() && this.segundos == c.getSegundos());
        
    }
    
    
  
}
