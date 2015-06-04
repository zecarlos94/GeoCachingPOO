import java.util.*;

/**
 * Write a description of class geraUtilizadores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class geraUtilizadores
{
   
    private final int numeroUtilizadores = 100;
    
    private Utilizadores utilizadores;

    public geraUtilizadores(Caches caches)
    {
        int i;
        for( i = 0 ; i < numeroUtilizadores ;)
            {
                Utilizador u = (new geraUtilizador()).getUtilizador();
                if ( !utilizadores.existe(u) ) 
                    {
                        utilizadores.add(u);i++;
                    }
            }
        
         geraAmizades();
         geraDescobertas(caches);
        
    }
    
    public static void geraAmizades()
    {
        Random random = new Random();
        ArrayList<String> emails = new ArrayList<String>();
        
        Iterator<Map.Entry<String,Utilizador>> it = this.utilizadores.iterator();
        while ( it.hasNext() )
         {
                    String email = it.next().getKey();
                    emails.add(email);
          }
        
        
        
        Iterator<Map.Entry<String,Utilizador>> it2 = this.utilizadores.iterator();
        while(it2.hasNext())
        {
            String email = it2.next().getKey();
            int nAmigos = random.nextInt(5) + 2;
            int count = 0;
            int i;
            for( i = random.nextInt(utilizadores.size()) ; count < nAmigos ; i = (++i) % (utilizadores.size()) )
            {
                if ( random.nextDouble() < 0.25 * random.nextDouble() ) // 0 a 25 % de adicionar o amigo 
                if( ! email.equals(emails.get(i)) ) 
                {
                    try{
                            this.utilizadores.addAmizade(email,emails.get(i));
                            count++;
                    }catch( AmizadeJaExiste e ){}
                }
                
            }
            
        }
        
    }

    public Utilizadores getUtilizadores()
    {
        return this.utilizadores.clone();
    }
    
}
