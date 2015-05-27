import java.lang.Double; // MAX_VALUE
import java.util.*;


/**
 * Write a description of class Evento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Evento
{
 
    
    /**
     *  Variáveis de instancia;
     */
    
    int limite; // Numero máximo de participantes

      /**
     *  Variáveis de instancia 
     */
    
    // Contem os resultados gerados pelo Evento
    ArrayList<Descoberta> descobertas = new ArrayList<Descoberta>();
    
    // Data de término de inscriçoes
    Timeline inicio;  
    
    // Momento em que acabou o evento
    Timeline clock_Evento;
    
    /**
     *  Inicia o evento com as Caches existentes e Utilizadores disponiveis
     *  
     */
    
    public void simulateEvento(Utilizadores utilizadores, Caches caches)
    {
        String clima = (new geraAtmosfera()).getClima();
        
        Random random = new Random();
        
        int numeroCaches = caches.size();// codigo errado
        
        HashMap<String,VariaveisUtilizador> variaveisUtilizadores = new HashMap<String,VariaveisUtilizador>();  // Variaveis de cada utilizador
        
        Caches caches_disponiveis = new  Caches(caches);
        
        Caches caches_identificadas = new Caches();;    // colecçao de caches identificadas
        
        this.clock_Evento = new Timeline();
      
        // Contem as velocidades com que se deslocaram os Utilizadores na ultima ronda
        HashMap<String,Double> velocidades = new HashMap<String,Double>();
        
        // Contem o ultimo checkPoint que o utilizador já ultrapassou na MultiCache caso se verifique
       // Não implementado HashMap<String,Coordenadas> checkPoints = new HashMap<String,Coordenadas>();
    
        Iterator<Map.Entry<String,Utilizador>> it = utilizadores.iterator();
        while(it.hasNext())
            {
                String email = it.next().getKey();
                Utilizador u = it.next().getValue();
                variaveisUtilizadores.put( email , new VariaveisUtilizador(u,clima));
            }
        // Obtém e guarda todos os dados simulados pelo evento
        // Em cada iteraçao há sempre um utilizador que descobre uma cache
        
        while(  caches_identificadas.size() != numeroCaches   )
        {
            double melhorTempo = Double.MAX_VALUE ;
            Utilizador utilizadorMaisRapido = null;
            Cache cacheIdentificada = null;
            
            // Calcula o utilizador que demorou menos tempo a encontrar a Cache
            // Acho q pode ser mudado para arrayList<VariantesUtilizador> esta 
            Iterator<Map.Entry<String,VariaveisUtilizador>> it2 = variaveisUtilizadores.entrySet().iterator();
            while( it.hasNext() )
            {
                VariaveisUtilizador variaveisU = it2.next().getValue();
                Utilizador utilizador = utilizadores.get(it2.next().getKey()); // user
                
                double tempoUtilizador; // Tempo hipotetico que o utilizador demoraria a encontrar a cache mais perto se ninguem encontrasse primeiro
                Cache CacheMaisPerto = caches_disponiveis.cacheMaisPerto(variaveisU.getLocalizacao()); 
          
                
                double velocidadeUtilizador = variaveisU.getVelocidade();
                
                
                if (CacheMaisPerto instanceof MultiCache)
                    {
                       
                       double distancia = ((MultiCache)CacheMaisPerto).distanciaPercorrida( variaveisU.getLocalizacao() ); // Devolve a distancia mínima para passar todos os checkpoints 
                       
                       distancia = distancia + 0.2*random.nextDouble()*distancia; // Aumenta a distancia percorrida em 0 a 20%, uma vez que a anterior foi calculada em linha reta 
                  
                       
                       // boost de (4 a 8)km/h por cada multiCache que encontrou no passado
                       // + (2 a 4) km/h por cada (misteryCache + microCache) 
                       double boostVelocidade = variaveisU.getMultiCache() * ( random.nextInt(4) + 4) + (variaveisU.getMicroCache() + variaveisU.getMisteryCache()) * (random.nextInt(2)+ 2);
                                                                    
                                                                                                  
                       
                       tempoUtilizador = (velocidadeUtilizador + boostVelocidade) / distancia ;
                         
                        
                    }
                    //  CacheMaisPerto é uma MicroCache ou uma MisteryCache
                 else 
                    {
                        
                        
                        double distancia = CacheMaisPerto.getCoordenadas().distance( variaveisU.getLocalizacao());
                        
                        distancia = distancia + 0.2*random.nextDouble()*distancia; // Aumenta distancia em 0 a 20%
                        
                        int totalCaches = variaveisU.getCaches(); // total de caches descobertas pelo utilizador antes de entrar para o evento
                        
                        //boost de (2 a 4) km/h por cada cache que encontrou pre-Evento
                        double boostVelocidade = totalCaches * (random.nextInt(2) + 2);
                        
                        tempoUtilizador = (velocidadeUtilizador + boostVelocidade) / distancia ;
                    
                    
                    }
              
                if( tempoUtilizador > melhorTempo)
                    {
                         melhorTempo = tempoUtilizador;
                         utilizadorMaisRapido = utilizador;
                         cacheIdentificada = CacheMaisPerto;
                    }
            }
            
            // Avança no tempo para o momento em que foi descoberta a cache
            
            this.clock_Evento.jumpTime(melhorTempo); 
            
               
            // Calcular as novas posiçoes dos utilizadores no final de x horas, sendo x = melhorTempo ; 
                   // Depende do tempo = melhorTempo , da velocidade com que se deslocou e das coordenadas iniciais e "finais"
           Iterator<Map.Entry<String,Utilizador>> it3 = utilizadores.iterator(); 
           while(it.hasNext())
                {
                    String email = it3.next().getKey();
                    VariaveisUtilizador variaveisU = variaveisUtilizadores.get( email );
                    
                    // Obtém a velocidade com que utilizador se deslocou nas passadas x horas
                    double velocidade = velocidades.get( email );
                    
                    // Cálculo da distancia percorrida
                    double distanciaPercorrida = (velocidade * melhorTempo);
                    
                    // Reduz o deslocamento do utilizador em 0 a 40% da distanciaPercorrida uma vez que é irrealista mover-se em linha reta
                    double deslocamento = distanciaPercorrida - distanciaPercorrida * ( random.nextDouble()*0.4 );
                    
                    // Coordenadas de destino servem para calcular a direçao do utilizador
                    Coordenadas destino = caches.cacheMaisPerto( variaveisU.getLocalizacao() ).getCoordenadas();
                    
                    // deslocamento devolve uma nova localizacao calculada a partir da direção e do deslocamento 
                    Coordenadas novaLocalizacao = variaveisU.getLocalizacao().deslocamento(destino,deslocamento);
                    
                    // Actualiza a nova localização do utilizador
                    variaveisU.setLocalizacao(novaLocalizacao);
                    
                }
                
            
            // Adiciona a cache identificada e remove-a das disponiveis  
            
            caches_identificadas.add( cacheIdentificada );
            
            caches_disponiveis.remove( cacheIdentificada );
            
            
            
            // Gera a pontuaçao e adiciona a informação da descoberta de cache aos dados do evento
            
            this.add( utilizadorMaisRapido , cacheIdentificada , this.clock_Evento); 
               
            
        }
        
        // Simulaçao do evento acaba, Informaçao guardada em this.descobertas
        
        
    }
  
    
    /**
     *  Informação a guardar
     *      -- Tempo de descoberta da Cache -- Email do utilizador  -- Pontos obtidos -- Tipo de Cache 
     */
    
    public void add(Utilizador vencedorRonda,Cache cacheIdentificada,Timeline tempo)
    {
        Descoberta descoberta = new Descoberta(vencedorRonda,cacheIdentificada,tempo);
        
        this.descobertas.add(descoberta);
    }
    
    /**
     *  Infere um velocidade media de deslocamento em função do clima e experiência do utilizador
     *      Recolhe também o numero de caches que o utilizador descobriu antes do evento
     */

    public class VariaveisUtilizador
    {
            private final double velocidadeBase = 25 ; // Velocidade Base km/h
            
            /**
               *    Variáveis de instancia
            */
            private Coordenadas localizacao;
               
            // As seguintes variáveis contêm a quantidade de caches descobertas pelo utilizador previamente ao evento
            private int multiCache;
            private int misteryCache;
            private int microCache;
            private int caches;
            // Velocidade media do utilizador nas condições atmosféricas dadas
            private double velocidade;
            
            public VariaveisUtilizador( Utilizador utilizador, String clima ){
       
                Random random = new Random();
                
                if( utilizador.getEstatisticas().climaFavorito(clima) ) this.velocidade = velocidadeBase + velocidadeBase * ( 0.4*random.nextDouble()) ; // boost de 0 a 40% se for o clima com mais experiencia
                
                if( utilizador.getEstatisticas().climaPior(clima) ) this.velocidade = velocidadeBase - velocidadeBase * ( 0.4*random.nextDouble()) ; // deboost de 0 a 40% se for o clima com menos experiencia
            
                int cachesObtidasClima = utilizador.getEstatisticas().numeroCachesClima(clima);
                
                this.velocidade = this.velocidade + this.velocidade*( random.nextDouble() * ((double)cachesObtidasClima / 100) ); // boost de 0 a NumeroCachesObtidasClima%
                
                this.multiCache = utilizador.getEstatisticas().getCachesTipo(new String("MultiCache"));
                this.misteryCache = utilizador.getEstatisticas().getCachesTipo(new String("MisteryCache"));
                this.microCache = utilizador.getEstatisticas().getCachesTipo(new String("MicroCache"));
                this.caches = this.multiCache + this.misteryCache + this.microCache;
                
 
               // variantes.setLocalizacao(0); // a alterar 
            } 
        
            public void setLocalizacao(Coordenadas c){   this.localizacao = c;  }
            public Coordenadas getLocalizacao() {   return this.localizacao;}
            public double getVelocidade()   {   return this.velocidade; }
            public int getMultiCache(){ return this.multiCache; }
            public int getMicroCache(){ return this.microCache;  }
            public int getMisteryCache(){   return this.misteryCache; }
            public int getCaches()  {   return this.caches;}
        
    }
}
