import java.util.*;

public class Cache
{
    /**
     * Declaração de variáveis
     */
    private TreeMap<Date, String> register_book;
    private String writing_material;    //caneta ou lápis;
    private ArrayList<String> treasures;
    private String coordenadas;
    
    /**
     * Construtores
     */
    public Cache() {
        this.register_book=new TreeMap<Date, String>(new DateComparator());
        this.writing_material="N/A";
        this.treasures=new ArrayList<String>();
        this.coordenadas="N/A";
    }
    
    public Cache(TreeMap<Date, String> reg, String writing_material, ArrayList<String> t, String coordenadas) {
        Set<Map.Entry<Date, String>> eset=reg.entrySet();
        Iterator<Map.Entry<Date, String>> it=eset.iterator();
        while(it.hasNext()) {
            Map.Entry<Date, String> elem=it.next();
            this.register_book.put(elem.getKey().clone(), elem.getValue());
        }
        this.writing_material=writing_material;
        this.treasures.addAll(t);
        this.coordenadas=coordenadas;
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
