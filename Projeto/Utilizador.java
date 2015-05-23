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
    private Timeline timeline_nascimento;    // O construtor recebe d/m/y                                   
    private TreeMap<Timeline, Actividade> timeline;    //Lista das timeline em que o utilizador participou, cuja chave corresponde à timeline em que o mesmo participou    
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
        this.timeline_nascimento=new Timeline();
        this.timeline=new TreeMap<Timeline, Actividade>();
        this.estatisticas=new HashMap<String, Integer>();
        this.amigos=new HashMap<String, Utilizador>();
    }
    
    public Utilizador(String email, String password, String nome, char genero, String morada, Timeline timeline_nascimento, TreeMap<Timeline, Actividade> timeline, HashMap<String, Integer> estatisticas, HashMap<String, Utilizador> amigos) {
        this.email=email;
        this.password=password;
        this.nome=nome;
        this.genero=genero;
        this.timeline_nascimento=new Timeline(timeline_nascimento);
        this.timeline=new TreeMap<Timeline, Actividade>(timeline);
        this.estatisticas=new HashMap<String, Integer>(estatisticas);
        this.amigos=new HashMap<String, Utilizador>(amigos);
    }
    
    public Utilizador(Utilizador u) {
        this.email=u.getEmail();
        this.password=u.getPassword();
        this.nome=u.getNome();
        this.genero=u.getGenero();
        this.morada=u.getMorada();
        this.timeline_nascimento=u.getTimelineNascimento();
        this.timeline=u.getAtividades();
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
    
    public Timeline getTimelineNascimento() {
        return this.timeline_nascimento;
    }
    
    public TreeMap<Timeline, Actividade> getAtividades() {
        return this.timeline;
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
    
    public void setTimelineNascimento(Timeline timeline_nascimento) {
        this.timeline_nascimento=timeline_nascimento.clone();
    }
    
    public void setAtividades(TreeMap<Timeline, Actividade> timeline) {
        TreeMap<Timeline, Actividade> aux=new TreeMap<Timeline, Actividade>(new TimelineComparator());
        Set<Map.Entry<Timeline, Actividade>> eset=timeline.entrySet();
        Iterator<Map.Entry<Timeline, Actividade>> it=eset.iterator();
        while(it.hasNext()) {
            Map.Entry<Timeline, Actividade> elem=it.next();
            aux.put(elem.getKey().clone(), elem.getValue());
        }
        this.timeline=aux;
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
     *  Recebe os emails de todos os admins e verifica se faz parte da lista
     * 
     */
    
    public boolean isAdmin(String[] admins)
    {
        boolean res = false;
        for( String admin : admins)
            if( this.email.equals(admin)) res = true;
        return true;
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
                 && this.morada.equals(c.getMorada()) && this.timeline_nascimento.equals(c.getTimelineNascimento()) && this.timeline.equals(c.getAtividades())
                 && this.estatisticas.equals(c.getEstatisticas()) && this.amigos.equals(c.getAmigos()));
    }
    
    /**
     * toString
     */
    public String toString() {
        return new String(this.email+ " " +this.password+ " " +this.nome+ " " +this.genero+ " " +this.morada+ " " +this.timeline_nascimento.toString()+ " " +this.printAmigos());
    }
    
    /**
     * Coloca numa String todos os emails dos amigos do utilizador
     */
    public String printAmigos() {
        String newString=new String();
        String aux=new String();
        int i=0;
        Set<String> kset=this.amigos.keySet();
        Iterator<String> it=kset.iterator();
        while(it.hasNext()) {
            String email=it.next();
            if(i==0) {
                aux=new String(newString+email);
                newString=aux;
                i++;
            }
            else {
                aux=new String(newString+ "," +email);
                newString=aux;
            }
        }
        return aux;
    }
}
