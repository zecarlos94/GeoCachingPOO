import java.util.Random;

/**
 * Gera um inteiro entre 50 e 100 que vai representar os geoCoins minimos da MultiCache e MisteryCache
 * 
 */
public class geraGeoCoins
{
    
    private int geoCoins;

    /**
     * Constructor for objects of class geraGeoCoins
     */
    public geraGeoCoins() throws NumberFormatException
    {
        Random r = new Random();
        geoCoins = r.nextInt(50) + 50; // entre 100 e 50
    }

    public int getGeoCoins() throws NumberFormatException
    { return geoCoins;}
}
