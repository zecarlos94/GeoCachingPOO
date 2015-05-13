import java.util.*;

public class Utilizador
{
    /**
     * Variáveis de Instância
     */
    private String email;
    private String password;
    private String nome;
    private char genero;
    private String morada;                                          
    private Data data_nascimento;                                        
    private TreeMap<Data, Cache> atividades;    //Lista das atividades em que o utilizador participou, cuja chave corresponde à data em que o mesmo participou    
    private HashMap<String, Integer> estatisticas;    //Número de caches encontradas pelo utilizador por cada tipo
    private HashMap<String, Utilizador> amigos=new HashMap<String, Utilizador>();     //Lista de amigos, cuja chave corresponde ao email de cada um      
    
    /**
     * Construtores
     */
    public Utilizador() {
        this.email="N/A";
        this.password="N/A";
        this.nome="N/A";
        this.genero='N';
        this.morada="N/A";
        this.data_nascimento=new Data();
        this.atividades=new TreeMap<Data, Cache>();
        this.estatisticas=new HashMap<String, Integer>();
        this.amigos=new HashMap<String, Utilizador>();
    }
    
    public Utilizador(String email, String password, String nome, char genero, String morada, Data data_nascimento, TreeMap<Data, Cache> atividades, HashMap<String, Integer> estatisticas, HashMap<String, Utilizador> amigos) {
        this.email=email;
        this.password=password;
        this.nome=nome;
        this.genero=genero;
        this.data_nascimento=new Data(data_nascimento);
        this.atividades=new TreeMap<Data, Cache>(atividades);
        this.estatisticas=new HashMap<String, Integer>(estatisticas);
        this.amigos=new HashMap<String, Utilizador>(amigos);
    }
    
    public Utilizador(Utilizador u) {
        this.email=u.getEmail();
        this.password=u.getPassword();
        this.nome=u.getNome();
        this.genero=u.getGenero();
        this.morada=u.getMorada();
        this.data_nascimento=u.getDataNascimento();
        this.atividades=u.getAtividades();
        this.estatisticas=u.getEstatisticas();
        this.amigos=u.getAmigos();
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
    
    public String getNome() {
        return this.nome;
    }
    
    public char getGenero() {
        return this.genero;
    }
    
    public String getMorada() {
        return this.morada;
    }
    
    public Data getDataNascimento() {
        return this.data_nascimento;
    }
    
    public TreeMap<Data, Cache> getAtividades() {
        return this.atividades;
    }
    
    public HashMap<String, Integer> getEstatisticas() {
        return this.estatisticas;
    }
    
    public HashMap<String, Utilizador> getAmigos() {
        return this.amigos;
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
    
    public void setNome(String nome) {
        this.nome=nome;
    }
    
    public void setGenero(char genero) {
        this.genero=genero;
    }
    
    public void setMorada(String morada) {
        this.morada=morada;
    }
    
    public void setDataNascimento(Data data_nascimento) {
        this.data_nascimento=data_nascimento.clone();
    }
    
    public void setAtividades(TreeMap<Data, Cache> atividades) {
        TreeMap<Data, Cache> aux=new TreeMap<Data, Cache>(new DataComparator());
        Set<Map.Entry<Data, Cache>> eset=atividades.entrySet();
        Iterator<Map.Entry<Data, Cache>> it=eset.iterator();
        while(it.hasNext()) {
            Map.Entry<Data, Cache> elem=it.next();
            aux.put(elem.getKey().clone(), elem.getValue().clone());
        }
        this.atividades=aux;
    }
    
    public void setEstatisticas(HashMap<String, Integer> estatisticas) {
        HashMap<String, Integer> aux=new HashMap<String, Integer>();
        Set<Map.Entry<String, Integer>> eset=estatisticas.entrySet();
        Iterator<Map.Entry<String, Integer>> it=eset.iterator();
        while(it.hasNext()) {
            Map.Entry<String, Integer> elem=it.next();
            aux.put(elem.getKey(), elem.getValue());
        }
        this.estatisticas=aux;
    }
    
    public void setAmigos(HashMap<String, Utilizador> amigos) {
        HashMap<String, Utilizador> aux=new HashMap<String, Utilizador>();
        Set<Map.Entry<String, Utilizador>> eset=amigos.entrySet();
        Iterator<Map.Entry<String, Utilizador>> it=eset.iterator();
        while(it.hasNext()) {
            Map.Entry<String, Utilizador> elem=it.next();
            aux.put(elem.getKey(), elem.getValue().clone());
        }
        this.amigos=aux;
    }
    
    /**
     * Clone
     */
    public Utilizador clone() {
        return new Utilizador(this);
    }
    
    /**
     * Equals
     */
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Utilizador c = (Utilizador) obj;
      return(this.email.equals(c.getEmail()) && this.password.equals(c.getPassword()) && this.nome.equals(c.getNome()) && this.genero==c.getGenero() 
                 && this.morada.equals(c.getMorada()) && this.data_nascimento.equals(c.getDataNascimento()) && this.atividades.equals(c.getAtividades())
                 && this.estatisticas.equals(c.getEstatisticas()) && this.amigos.equals(c.getAmigos()));
    }
    
    /**
     * toString
     */
    public String toString() {
        return new String(this.email+ " " +this.password+ " " +this.nome+ " " +this.genero+ " " +this.morada+ " " +this.data_nascimento.toString()+ " " +this.printAmigos());
    }
    
    /**
     * Coloca numa String todos os emails dos amigos do utilizador
     */
    public String printAmigos() {
        String aux="";
        int i=0;
        Set<String> kset=this.amigos.keySet();
        Iterator<String> it=kset.iterator();
        while(it.hasNext()) {
            String email=it.next();
            if(i==0) {
                aux=email;
                i++;
            }
            else aux.concat(",".concat(email));
        }
        return aux;
    }
}
