import java.util.*;

public class MicroCache extends Cache
{
    int geocoins; // GeoCoins da micro cache sao sempre entre 50-100
    
   public MicroCache()
   {
       super();
       geocoins=(new geraGeoCoins()).getGeoCoins();
   }
   
   public MicroCache(HashMap<String, Timeline> livro_registos, Timeline t, Coordenadas coordenadas,int gc)
   {
       super(livro_registos,t,coordenadas);
       geocoins=gc;
   }
   
   public MicroCache(MicroCache mc)
   {
       super(mc);
       geocoins = mc.getGeoCoins();
   }
   
    
    /**
     *  De notar que MicroCache nao contem geocoins, por isso retorna sempre 0
     */
   public int getGeoCoins()
   {    return geocoins;}
   
   /**
    * Os geoCoins da micro cache sao sempre os geoCoins base (50-100)
    */
   public int getGeoCoinsTotais()
   {    return geocoins;}
   
   public MicroCache clone()
   {    return new MicroCache(this);}
   
}
