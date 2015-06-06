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
    
    int limite; // Numero máximo de participantes
    
    // Contem os resultados gerados pelo Evento
    ArrayList<Descoberta> descobertas = new ArrayList<Descoberta>();
    
    // Ordenado por ordem decrescente de pontos dos utilizadores, contem o numero de cada cache descoberta 
    TreeMap<Integer,PontuacaoAux> pontuacao;
    
    // Data de término de inscriçoes
    Timeline inicio;  
    
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
        
        System.out.println("Variaveis do utilizador calculadas e colocadas");
        
        while(  caches_identificadas.size() != numeroCaches   )
        {
            double melhorTempo = Double.MAX_VALUE ;
            Utilizador utilizadorMaisRapido = null;
            Cache cacheIdentificada = null;
            
            System.out.printf("Caches_identificadas %d, numeroCaches %d\n", caches_identificadas.size(),numeroCaches);
            
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
                
                if(CacheMaisPerto == null ) System.out.println("Cache mais perto é null");
                if (CacheMaisPerto instanceof MultiCache)
                    {
                       //double distancia = ((MultiCache)CacheMaisPerto).distanciaPercorrida( variaveisU.getLocalizacao() ); // Devolve a distancia mínima para passar todos os checkpoints 
                       
                       double distancia = CacheMaisPerto.getCoordenadas().distance( variaveisU.getLocalizacao()) * 0.001; // convertido para km
                       
                       distancia = distancia + aumentoDistancia*distancia; 
                  
                       // boost de (0 a 2)km/h por cada multiCache que encontrou no passado
                       // + (0 a 1) km/h por cada (misteryCache + microCache) 
                       double boostVelocidade = variaveisU.getMultiCache() * ( random.nextInt(3)) + (variaveisU.getMicroCache() + variaveisU.getMisteryCache()) * (random.nextInt(2));
      
                       velocidade = velocidadeUtilizador + boostVelocidade;
                       
                       tempoUtilizador =  distancia / velocidade  ;
                    //   System.out.printf("MultiCache velocidade %f , tempoUtilizador %f, distancia %f\n",velocidade,tempoUtilizador,distancia);
                        
                    }
                    //  CacheMaisPerto é uma MicroCache ou uma MisteryCache
                 else 
                    {                  
                        double distancia = CacheMaisPerto.getCoordenadas().distance( variaveisU.getLocalizacao()) * 0.001; // conversao para km
                        
                        distancia = distancia + aumentoDistancia*distancia; // Aumenta distancia em 0 a 20%
                        
                        int totalCaches = variaveisU.getCaches(); // total de caches descobertas pelo utilizador antes de entrar para o evento
                        
                        //boost de (2 a 4) km/h por cada cache que encontrou pre-Evento
                        double boostVelocidade = totalCaches * (random.nextInt(2) + 2);
                        
                        velocidade = velocidadeUtilizador + boostVelocidade;
                        
                        tempoUtilizador =  distancia / velocidade ;
                        
                  //      System.out.printf("Micro ou MysteryCache velocidade %f , tempoUtilizador %f, distancia:%f\n",velocidade,tempoUtilizador,distancia);
                    
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
            
            System.out.printf("Salto de %f horas\n",melhorTempo);
            System.out.printf("Antes: %s\n",this.clock_Evento.toString());
            this.clock_Evento.jumpTime(melhorTempo); 
              System.out.printf("Depois: %s\n",this.clock_Evento.toString());
            
               
            // Calcular as novas posiçoes dos utilizadores no final de x horas, sendo x = melhorTempo ; 
                   // Depende do tempo = melhorTempo , da velocidade com que se deslocou e das coordenadas iniciais e "finais"
           Iterator<Map.Entry<String,Utilizador>> it3 = utilizadores.iterator(); 
           while(it.hasNext())
                {
                    String email = it3.next().getKey();
                    VariaveisUtilizador variaveisU = variaveisUtilizadores.get( email );
                    
                    double aumentoDistancia = factoresAumento.get(email);
                    
                    // Obtém a velocidade com que utilizador se deslocou nas passadas x horas
                    double velocidade = velocidades.get( email );
                    
                    // Cálculo da distancia percorrida
                    double distanciaPercorrida = (velocidade * melhorTempo) * 0.001; // convertido para km
                    
                    // Reduz o deslocamento do utilizador em 0 a 40% da distanciaPercorrida uma vez que é irrealista mover-se em linha reta
                    double deslocamento = distanciaPercorrida - distanciaPercorrida * aumentoDistancia;
                    
                    // Coordenadas de destino servem para calcular a direçao do utilizador
                    Coordenadas destino = caches.cacheMaisPerto( variaveisU.getLocalizacao() ).getCoordenadas();
                    
                    // deslocamento devolve uma nova localizacao calculada a partir da direção e do deslocamento 
                    Coordenadas novaLocalizacao = variaveisU.getLocalizacao().deslocamento(destino,deslocamento); // recebe km ???
                    
                    // Actualiza a nova localização do utilizador
                    variaveisU.setLocalizacao(novaLocalizacao);
                    
                }
                
            // Adiciona a cache identificada e remove-a das disponiveis  
            
            caches_identificadas.add( cacheIdentificada );
            
            caches_disponiveis.remove( cacheIdentificada );
            
            
       //     System.out.println("A gerar pontuaçao");
            // Gera a pontuaçao e adiciona a informação da descoberta de cache aos dados do evento
            
            this.add( utilizadorMaisRapido , cacheIdentificada , this.clock_Evento); 
               
            
        }
        // calcula o vencedor e gera os stats de caches descobertas de cada um
            pontuacao();
        
             EscreveTXT escreve = new EscreveTXT();
             try{
             escreve.escreveEvento(this,"evento.txt");
            }catch(IOException e) {System.out.println("Evento IOException");}
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
 
    public String vencedor()
    {
        String vencedor = null;
        int mPontos = -1;
        for(Descoberta elem : this.descobertas)
        {
            int pontos = elem.getPontos();
            if(pontos > mPontos){
                    mPontos = pontos;
                    vencedor = elem.getEmail();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("O vencedor é "+vencedor + " com um total impressionante de "+mPontos +" pontos\n");
        return sb.toString(); 
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
        for(Descoberta elem : this.descobertas)
            sb.append(elem+"\n");
        sb.append(vencedor());
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
            if(ct.compare( elem.getTime(),time) <= 0 ) sb.append(elem+"\n");
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