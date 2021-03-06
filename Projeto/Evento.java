import java.lang.Double; // MAX_VALUE
import java.util.*;
import java.io.*;


/**
 * Write a description of class Evento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Evento implements Serializable
{

  

      /**
     *  Variáveis de instancia 
     */
    
    
    // Contem os resultados gerados pelo Evento
    ArrayList<Descoberta> descobertas = new ArrayList<Descoberta>();
    
    // Ordenado por ordem decrescente de pontos dos utilizadores, contem o numero de cada cache descoberta 
    TreeMap<Integer,PontuacaoAux> pontuacao;
    
    
    // Momento em que acabou o evento
    Timeline clock_Evento;
    
    /**
     *  Inicia o evento com as Caches existentes e Utilizadores disponiveis
     *  
     */
    
    public Evento(Utilizadores utilizadores, Caches caches)
    {
        String clima = (new geraAtmosfera()).getClima();
        
        Random random = new Random();
        
        int numeroCaches = caches.size();
        
        HashMap<String,VariaveisUtilizador> variaveisUtilizadores = new HashMap<String,VariaveisUtilizador>();  // Variaveis de cada utilizador
        
      
        Caches caches_disponiveis = new  Caches(caches);
     
        Caches caches_identificadas = new Caches();    // colecçao de caches identificadas
    
        this.clock_Evento = new Timeline();
      
        // Contem as velocidades com que se deslocaram os Utilizadores na ultima ronda
        HashMap<String,Double> velocidades = new HashMap<String,Double>();
        
        //Guarda o factor de aumento de distancia percorrida do ultimo ciclo 
        HashMap<String,Double> factoresAumento = new HashMap<String,Double>();
        
          
        Iterator<Map.Entry<String,Utilizador>> it = utilizadores.iterator();
        while(it.hasNext())
            {
                Map.Entry<String,Utilizador> elem2 = it.next();
                String email = elem2.getKey();
                Utilizador u = elem2.getValue();
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
            while( it2.hasNext() )
            {
                Map.Entry<String,VariaveisUtilizador> elem = it2.next();
                VariaveisUtilizador variaveisU = elem.getValue();
                Utilizador utilizador = utilizadores.get(elem.getKey()); // user
                
                
                // Aumenta a distancia percorrida em 0 a 40%, uma vez que a anterior foi calculada em linha reta 
                double aumentoDistancia = 0.4 * random.nextDouble();
                
                // Variável a guardar em velocidades
                double velocidade = 0;
                 
                double tempoUtilizador; // Tempo hipotetico que o utilizador demoraria a encontrar a cache mais perto se ninguem encontrasse primeiro
                Cache CacheMaisPerto = caches_disponiveis.cacheMaisPerto(variaveisU.getLocalizacao()); 
          
                double velocidadeUtilizador = variaveisU.getVelocidade();
                
           
                if (CacheMaisPerto instanceof MultiCache)
                    {
                     
                       
                       double deslocamento = CacheMaisPerto.getCoordenadas().distance( variaveisU.getLocalizacao()) * 0.001; // convertido para km
                       
                       double distancia = deslocamento + aumentoDistancia*deslocamento; 
                  
                       // boost de (0 a 0.30)km/h por cada multiCache que encontrou no passado
                       // + (0 a 0.20) km/h por cada (misteryCache + microCache) 
                       double boostVelocidade = variaveisU.getMultiCache() * ( 0.3*random.nextDouble()) + (variaveisU.getMicroCache() + variaveisU.getMisteryCache()) * (random.nextDouble() * 0.20);
      
                       velocidade = velocidadeUtilizador + boostVelocidade;
                       
                       tempoUtilizador =  distancia / velocidade  ;
                  
                        
                    }
                    //  CacheMaisPerto é uma MicroCache ou uma MisteryCache
                 else 
                    {                  
                        double deslocamento = CacheMaisPerto.getCoordenadas().distance( variaveisU.getLocalizacao()) * 0.001; // conversao para km
                        
                        double distancia = deslocamento + aumentoDistancia*deslocamento; // Aumenta distancia em 0 a 20%
                        
                        int totalCaches = variaveisU.getCaches(); // total de caches descobertas pelo utilizador antes de entrar para o evento
                        
                        //boost de (0 a 0.25) km/h por cada cache que encontrou pre-Evento
                        double boostVelocidade = totalCaches * (0.25*random.nextDouble());
                        
                        velocidade = velocidadeUtilizador + boostVelocidade;
                        
                        tempoUtilizador =  distancia / velocidade ;
                        
                
                    
                    }
                    
                    
                    // Guarda o factor de aumento de distancia do participante nesta ronda
                    factoresAumento.put(utilizador.getEmail(),aumentoDistancia);
                    
                     // Guarda a velocidade com que se deslocou para depois calcular a nova posiçao do utilizador
                     velocidades.put(utilizador.getEmail(),velocidade);
                    
              
                if( tempoUtilizador  < melhorTempo)
                    {
                         melhorTempo = tempoUtilizador;
                         utilizadorMaisRapido = utilizador;
                         cacheIdentificada = CacheMaisPerto;
                    }
            }
            
  
            // Avança no tempo para o momento em que foi descoberta a cache

            this.clock_Evento.jumpTime(melhorTempo); 
             

            // Calcula as novas posiçoes dos utilizadores no final de x horas, sendo x = melhorTempo ; 
                   // Depende do tempo = melhorTempo , da velocidade com que se deslocou , das coordenadas iniciais e "finais" e do factor de aumento de distância percorrida 
           Iterator<Map.Entry<String,Utilizador>> it3 = utilizadores.iterator(); 
           while(it.hasNext())
                {
                    String email = it3.next().getKey();
                    VariaveisUtilizador variaveisU = variaveisUtilizadores.get( email );
                    
                    double aumentoDistancia = factoresAumento.get(email);
                    
                    // Obtém a velocidade com que utilizador se deslocou nas passadas x horas
                    double velocidade = velocidades.get( email );
                    
                    // Cálculo da distanciaPercorrida
                    double distanciaPercorrida = (velocidade * melhorTempo); // km
                    
                    // Reduz o deslocamento do utilizador em 0 a 40% da distanciaPercorrida uma vez que é irrealista mover-se em linha reta
                    double deslocamento = distanciaPercorrida - distanciaPercorrida * aumentoDistancia;
                    
                    // Coordenadas de destino servem para calcular a direçao do utilizador
                    Coordenadas destino = caches.cacheMaisPerto( variaveisU.getLocalizacao() ).getCoordenadas();
                    
                    // deslocamento devolve uma nova localizacao calculada a partir da direção e do deslocamento 
                    Coordenadas novaLocalizacao = variaveisU.getLocalizacao().deslocamento(destino,deslocamento); // recebe km 
                    
                    // Actualiza a nova localização do utilizador
                    variaveisU.setLocalizacao(novaLocalizacao);
                    
                }
                
            // Adiciona a cache identificada e remove-a das disponiveis  
            
            caches_identificadas.add( cacheIdentificada );
            
            caches_disponiveis.remove( cacheIdentificada );
            
            this.add( utilizadorMaisRapido , cacheIdentificada , this.clock_Evento); 
               
        }
        // calcula o vencedor e gera os stats de caches descobertas de cada um
            pontuacao();
        
             EscreveTXT escreve = new EscreveTXT();
             try{
             escreve.escreveEvento(this,"evento.txt");
            }catch(IOException e) {System.out.println("Evento IOException");}
        // Simulaçao do evento acaba, Informaçao guardada em this.descobertas e this.pontuacao
        
        
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
    
  
    
    public void pontuacao(){
        
           this.pontuacao = new TreeMap<Integer,PontuacaoAux>(new IntegerComparator());
           
           HashMap<String,PontuacaoAux> aux = new HashMap<String,PontuacaoAux>();
           for(Descoberta elem : this.descobertas)
           {
               String email = elem.getEmail();
               if(aux.containsKey(email))
               {
                   PontuacaoAux status = aux.get(email);
                   status.addPontos(elem.getPontos());
                   String cacheName = elem.getCacheName();
                   if ( cacheName.equals("MultiCache")) status.addMultiCache();
                   if ( cacheName.equals("MicroCache")) status.addMicroCache();
                   if( cacheName.equals("MisteryCache")) status.addMysteryCache();
                }
                else{
                    PontuacaoAux status = new PontuacaoAux(email);
                    status.addPontos(elem.getPontos());
                    String cacheName = elem.getCacheName();
                    if ( cacheName.equals("MultiCache")) status.addMultiCache();
                    if ( cacheName.equals("MicroCache")) status.addMicroCache();
                    if( cacheName.equals("MisteryCache")) status.addMysteryCache();
                    aux.put(email,status);
                }
           }
           Iterator<Map.Entry<String,PontuacaoAux>> it = aux.entrySet().iterator();
           while(it.hasNext())
           {
               Map.Entry<String,PontuacaoAux> elem = it.next();
               this.pontuacao.put(elem.getValue().getPontos(),elem.getValue());
           }
    }
      
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLog de descobertas\n"+this.toStringLog());
        sb.append("Stats dos participantes\n");
        Iterator<Map.Entry<Integer,PontuacaoAux>> it = this.pontuacao.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,PontuacaoAux> elem = it.next();
            PontuacaoAux stats = elem.getValue();
            sb.append("O participante "+ stats.getEmail() + " fez " + stats.getPontos() + " pontos com:\n");
            sb.append( stats.getMultiCache() + " MultiCaches " + stats.getMicroCache() + " MicroCache " + stats.getMysteryCache() + " MysteryCache\n");
        }
        
        return sb.toString();
    }
    
    public String toStringLog()
    {
        StringBuilder sb = new StringBuilder();
        TreeMap<Timeline,Descoberta> aux = new TreeMap<Timeline,Descoberta>(new TimelineComparator());
        for(Descoberta elem : this.descobertas)
            aux.put(elem.getTime(),elem);
            
        Iterator<Descoberta> it = aux.values().iterator();
        while(it.hasNext()){
            Descoberta elem = it.next();
            sb.append(elem.toString()+"\n");
        }
                 
        sb.append("\n");
        return sb.toString();
    }
    
    /**
     *  toString usado para mostrar aos utilizadores o decorrer do evento, ou seja, quando o mesmo ainda não acabou
     */
    public String toStringLog(Timeline time)
    {
        StringBuilder sb = new StringBuilder();
        Iterator<Descoberta> it = descobertas.iterator();
        Comparator<Timeline> ct = new TimelineComparator();
        while(it.hasNext()){
            Descoberta elem = it.next();
            if(ct.compare( elem.getTime(),time) <= 0 ) sb.append(elem.toString()+"\n");
        }
        return sb.toString();   
    }
    
    /**
     *  Infere um velocidade media de deslocamento em função do clima e experiência do utilizador
     *      Recolhe também o numero de caches que o utilizador descobriu antes do evento
     */

    public class VariaveisUtilizador
    {
            private final double velocidadeBase = 5 ; // Velocidade Base km/h
            
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
                
                double latitude = random.nextDouble();
                double longitude = random.nextDouble();
                setLocalizacao( new Coordenadas(latitude,longitude)); 
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