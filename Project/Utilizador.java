import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;

public class Utilizador
{
    /**
     * Declaração de variáveis
     */
    private String email;
    private String password;
    private String name;
    private char gender;
    private String address;
    private Date birth_date;
    private TreeMap<Date, Cache> activities;            //Date corresponde à data da Cache e a ordenação será feita com base na mesma 
    private HashMap<String, Utilizador> friends;      //String corresponde ao email do Utilizador amigo
    
    /**
     * Construtores
     */
    public Utilizador() {
        this.email="N/A";
        this.password="N/A";
        this.name="N/A";
        this.gender='N';
        this.address="N/A";
        this.birth_date=new Date();
        this.activities=new TreeMap<Date, Cache>(new DateComparator());   //a árvore será ordenada pela data, daí o uso de um comparador de datas (DateComparator) 
        this.friends=new HashMap<String, Utilizador>();
    }
    
    public Utilizador(String email, String password, String name, char gender, String address, int birth_day, int birth_month, int birth_year) {
        this.email=email;
        this.password=password;
        this.name=name;
        this.gender=gender;
        this.address=address;
        this.birth_date=new Date(birth_day, birth_month, birth_year);
        this.activities=new TreeMap<Date, Cache>(new DateComparator());
        this.friends=new HashMap<String, Utilizador>();
    }
 
    public Utilizador(Utilizador u) {
        this.email=u.getEmail();
        this.password=u.getPassword();
        this.name=u.getName();
        this.gender=u.getGender();
        this.address=u.getAddress();
        this.birth_date=u.getBirthDate();
        this.activities=u.getActivities();
        this.friends=u.getFriends();
    }
    
    /**
     * Getters
     */
    public String getEmail() {
        return this.email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getName() {
        return this.name;
    }
    
    public char getGender() {
        return this.gender;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public Date getBirthDate() {
        return this.birth_date;
    }
    
    public TreeMap<Date, Cache> getActivities() {
        return this.activities;
    }
    
    public HashMap<String, Utilizador> getFriends() {
        return this.friends;
    }
    
    /**
     * Setters
     */
    public void setEmail(String email) {
        this.email=email;
    }
    
    public void setPassword(String password) {
        this.password=password;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setGender(char gender) {
        this.gender=gender;
    }
    
    public void setAddress(String address) {
        this.address=address;
    }
    
    public void setBirthDate(int birth_day, int birth_month, int birth_year) {
        this.birth_date.setDay(birth_day);
        this.birth_date.setMonth(birth_month);
        this.birth_date.setYear(birth_year);
    }
    
    public void setActivities(TreeMap<Date, Cache> a) {
        TreeMap<Date, Cache> aux=new TreeMap<Date, Cache>(new DateComparator());
        Set<Map.Entry<Date, Cache>> s=a.entrySet();
        Iterator<Map.Entry<Date, Cache>> it=s.iterator();
        while(it.hasNext()) {
            Map.Entry<Date, Cache> elem=it.next();
            aux.put(elem.getKey().clone(), elem.getValue().clone());
        }
        this.activities=aux;
    }
    
    public void setFriends(HashMap<String, Utilizador> f) {
        HashMap<String, Utilizador> aux=new HashMap<String, Utilizador>();
        Set<Map.Entry<String, Utilizador>> s=f.entrySet();
        Iterator<Map.Entry<String, Utilizador>> it=s.iterator();
        while(it.hasNext()) {
            Map.Entry<String, Utilizador> elem=it.next();
            aux.put(elem.getKey(), elem.getValue().clone());
        }
        this.friends=aux;
    }
    
    /**
     * Equals
     */
    public boolean equals(Utilizador u) {
        if(this.email.equals(u.getEmail()) && this.password.equals(u.getPassword()) && this.name.equals(u.getName()) && this.gender==u.getGender() 
            && this.address.equals(u.getAddress()) && this.birth_date.equals(u.getBirthDate()) && this.activities.equals(u.getActivities()) && this.friends.equals(u.getFriends())) 
            return true;
        else return false;
    }
    
    /**
     * Clone
     */
    public Utilizador clone() {
        return new Utilizador(this);
    }
    
    /**
     * ToString
     */
    public String toString() {
        return new String("Email: " +this.email+ ", Password: " +this.password+ ", Nome: " +this.name+ ", Género: " +this.gender+ ", Morada: " +this.address+
                                       ", Data de nascimento: " +this.birth_date);
    }
}
