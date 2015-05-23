import java.util.*;

public class MicroCache extends Cache
{
   public MicroCache()
   {
       super();
   }
   
   public MicroCache(HashMap<String, Timeline> livro_registos, Timeline t, Coordenadas coordenadas)
   {
       super(livro_registos,t,coordenadas);
   }
   
   public MicroCache(MicroCache mc)
   {
       super(mc);
   }
   
    
    /**
     *  De notar que MicroCache nao contem geocoins, por isso retorna sempre 0
     */
   public int getGeoCoins()
   {    return 0;}
   
   public MicroCache clone()
   {    return new MicroCache(this);}
   
}
