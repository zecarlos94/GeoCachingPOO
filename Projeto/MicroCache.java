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
   
   public MicroCache(Coordenadas coordenadas)
   {
       super(coordenadas);
   }

   public MicroCache(MicroCache mc) 
   {
       super(mc);
   }
   
    
   public MicroCache clone()
   {    return new MicroCache(this);}
   
}
