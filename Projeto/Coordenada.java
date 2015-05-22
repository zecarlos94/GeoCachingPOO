
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
    
    // por acabar
  
}
