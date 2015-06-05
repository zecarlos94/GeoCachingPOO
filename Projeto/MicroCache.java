import java.util.*;

public class MicroCache extends Cache
{
    
   public MicroCache()
   {
       super();

   }
   
   public MicroCache(TreeMap<Timeline,String> livro_registos, Timeline t, Coordenadas coordenadas) 
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
   
    
   public MicroCache clone() {    
       return new MicroCache(this);
   }
   
   public String toString() {
        return "Tipo: MicroCache\n" + super.toString();
    }
    

   
}
