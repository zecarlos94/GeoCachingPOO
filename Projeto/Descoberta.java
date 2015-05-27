import java.util.*;
/**
 *  Classe utilizada para armazenar a informção de descoberta de Cache num evento e para gerar a pontuaçao da mesma.
 */
public class Descoberta
{
    // tempo em que se deu a descoberta da Cache
    private Timeline time;
    //  pontos gerados pela descoberta da Cache
    private int pontos;
    // email/chave do utilizador que descobriu a cache
    private String utilizador;
    private String cacheName;

    /**
     * Constructor for objects of class Descoberta
     */
    public Descoberta(Utilizador vencedorRonda,Cache cacheIdentificada,Timeline tempo)
    {
        this.utilizador = vencedorRonda.getEmail();
        this.time = tempo;
        this.cacheName = cacheIdentificada.getClass().getSimpleName();
        if( cacheIdentificada instanceof MultiCache ) pontos = ((MultiCache)cacheIdentificada).getGeoCoinsTotais();
        else if (cacheIdentificada instanceof MicroCache) pontos = (new geraGeoCoins()).getGeoCoins(); // entre 50-100 pontos
        else {
                    MisteryCache mc = (MisteryCache)cacheIdentificada;
                    int experiencia = vencedorRonda.getEstatisticas().getCachesTipo(new String("MisteryCache"));
                    int maxCertas = mc.getNumeroPerguntas();
                    Random random = new Random();
                    if(experiencia > 40) experiencia = 40;
                    
                    // 60% desta probabilidade é gerada aleatoriamente mas é fixa para todas as perguntas
                    // 40% são diretamente relacionados com a experiencia, por cada misteryCache aumenta 1%
                    double probabilidadeDeAcertar = 0.6*random.nextDouble() + (experiencia * 0.01);
                    
                    int respostasCertas = 0;
                    for(int i = 0; i < maxCertas ; i++)
                        {
                            if(random.nextDouble() <= probabilidadeDeAcertar) respostasCertas++;     
                        }
                    this.pontos = mc.getGeoCoinsTotais(respostasCertas);
                               
                }
    }
    public Timeline getTime(){   return this.time;}
    public int getPontos(){ return this.pontos;}
    public String getEmail(){   return this.utilizador;}
    public String getCacheName(){   return this.cacheName;}
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(time.toString() + ":" + "O utilizador " + utilizador + "descobriu uma " + cacheName + "e fez " + pontos + " pontos!");
        return sb.toString();
    }

}
