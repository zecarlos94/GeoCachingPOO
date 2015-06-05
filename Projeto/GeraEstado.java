
 import java.util.*;
 import java.io.*;
/**
 * Write a description of class GeraEstado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GeraEstado
{
  

    private final int numeroUtilizadores = 100;
    
    private final int numeroCaches = 80;
    
    private Utilizadores utilizadores;
    
    private Caches caches;

    public GeraEstado()
    {
        int i;
        Random random = new Random();
        
        System.out.println("Starting");
        
        this.utilizadores = new Utilizadores();
        for( i = 0 ; i < numeroUtilizadores;)
            {
                Utilizador u = (new geraUtilizador()).getUtilizador();
                if ( !utilizadores.existe(u) ) 
                    {
                        utilizadores.add(u);i++;
                    }
            }
        
        System.out.println("Utilizadores gerados");
        
        this.caches = new Caches();
         for ( i = 0; i < numeroCaches ;i++)
            {
                int opt = random.nextInt(3);
                
                Coordenadas coord;
                do{
                double latitude = random.nextDouble();
                double longitude = random.nextDouble();
                coord = new Coordenadas(latitude,longitude);
      
                }while( caches.existe(coord) );
                // System.out.println("Coordenada Aceite");
                Cache cache = null;
                switch (opt)
                {
                    case 0:
                                cache = new MicroCache(coord);
                                break;
                    case 1:
                                geraMultiCache gerador = new geraMultiCache();
                                cache = new MultiCache(coord,gerador.criaCheckpoints(coord));
                                break;
                    case 2:
                                geraMysteryCache geradorPR = new geraMysteryCache();
                                cache = new MisteryCache(coord,geradorPR.geraMysteryCache());
                                System.out.printf("\n%s\n",cache.toString());
                                break;
                }
                caches.add(cache);
            }
            
         System.out.println("Caches geradas");
            
         System.out.printf("Numero de caches = %d",caches.size());
        
         geraAmizades();
         
         System.out.println("Amizades geradas");
        
         geraDescobertas();
          
         System.out.println("Descobertas geradas");
         /*
         EscreveTXT escreve = new EscreveTXT();
         try{
         
         escreve.escreveUsers(this.utilizadores,"utilizadores.txt");
         escreve.escreveCaches(this.caches,"caches.txt");
        }catch(IOException e) {System.out.println("IOException"); }
    */
    }
    
    public void geraAmizades()
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
            for( i = random.nextInt(numeroUtilizadores) ; count < nAmigos ; i = (++i) % numeroUtilizadores )
            {
                if ( random.nextDouble() < 0.25 * random.nextDouble() ) // 0 a 25 % de adicionar o amigo 
                if( ! email.equals(emails.get(i)) ) 
                {
                    try{
                            this.utilizadores.addAmizade(email,emails.get(i));
                            count++;
                    }catch( AmizadeExisteException e ){}
                }
                
            }
            
        }
        
    }
    
    public void geraDescobertas()
    {
          Random random = new Random();
          ArrayList<Cache> cachesCollection = new ArrayList<Cache>(numeroCaches);
          
          Iterator<Map.Entry<Coordenadas,Cache>> it2 = this.caches.iterator();
          while(it2.hasNext()){
                cachesCollection.add( it2.next().getValue().clone() );
            }
            
          Iterator<Map.Entry<String,Utilizador>> it = this.utilizadores.iterator();
          while(it2.hasNext())
          {
            String email = it.next().getKey();
            int nDescobertas; // 50 % de ser ativo e ter entre 0 a 40 caches descobertas
            if(random.nextInt(2) == 0) nDescobertas = random.nextInt(40);
            else nDescobertas = random.nextInt(7);
            int count = 0;
            while(count < nDescobertas)
            {
                int i = random.nextInt(numeroCaches);
                Cache cache = cachesCollection.get(i);
                int geocoins = 0;
                if(!cache.existe(email))
                    {
                        if(cache instanceof MicroCache )
                            {
                                this.utilizadores.descobertaCache(email,cache,0);
                            }
                        else if (cache instanceof MultiCache)
                            {
                                geocoins = ((MultiCache)cache).getGeoCoinsTotais();
                                this.utilizadores.descobertaCache(email,cache,geocoins);
                                
                            }
                        else
                            {
                                int nP = ((MisteryCache)cache).getNumeroPerguntas();
                                geocoins = ((MisteryCache)cache).getGeoCoinsTotais(random.nextInt(nP+1));
                                this.utilizadores.descobertaCache(email,cache,geocoins);
                                
                            }
                         utilizadores.descobertaCache(email,cache,geocoins);
                         // caches.add(cache.getCoordenadas(),email)
                         count++;
                    }
                
            }
            
          }
          
     }
 
    public Utilizadores getUtilizadores()
    {
        return this.utilizadores.clone();
    }
    
}

