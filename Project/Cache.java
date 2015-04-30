import java.util.TreeMap;
import java.util.ArrayList;

public class Cache
{
    /**
     * Declaração de variáveis
     */
    private TreeMap<Date, String> register_book;
    private String writing_material;    //caneta ou lápis;
    private ArrayList<String> treasures;
    
    /**
     * Construtores
     */
    public Cache() {
        this.register_book=new TreeMap<Date, String>(new DateComparator());
        this.writing_material="N/A";
        this.treasures=new ArrayList<String>();
    }
    
    public Cache(String writing_material) {
        this.register_book=new TreeMap<Date, String>(new DateComparator());
        this.writing_material=writing_material;
        this.treasures=new ArrayList<String>();
    }
    
    public Cache(Cache c) {
        this.register_book=c.getRegisterBook();
        this.writing_material=c.getWritingMaterial();
        this.treasures=c.getTreasures();
    }
    
    /**
     * Getters
     */
    public TreeMap<Date, String> getRegisterBook() {
        return this.register_book;
    }
    
    public String getWritingMaterial() {
        return this.writing_material;
    }
    
    public ArrayList<String> getTreasures() {
        return this.treasures;
    }
    
    /**
     * Setters (...)
     * Equals (...)
     * ToString (...)
     */
    
    /**
     * Clone
     */
    public Cache clone() {
        return new Cache(this);
    }
}
