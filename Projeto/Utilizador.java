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
    private TreeMap<Timeline, Actividade> actividades;    //Lista das timeline em que o utilizador participou, cuja chave corresponde à timeline em que o mesmo participou    
    private HashMap<String, Integer> estatisticas;    //Número de caches encontradas pelo utilizador por cada tipo
    private ArrayList<String> amigos;     //Lista com os emails dos amigos      
    private Caches myCaches;
    
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
        this.actividades=new TreeMap<Timeline, Actividade>();
        this.estatisticas=new HashMap<String, Integer>();
        this.amigos=new ArrayList<String>();
        this.myCaches = new Caches();
    }
    
    public Utilizador(String email, String password, String nome, char genero, String morada, Timeline timeline_nascimento, TreeMap<Timeline, Actividade> actividades, HashMap<String, Integer> estatisticas, ArrayList<String> amigos, Caches caches) {
        this.email=email;
        this.password=password;
        this.nome=nome;
        this.genero=genero;
        this.timeline_nascimento=new Timeline(timeline_nascimento);
        this.actividades=new TreeMap<Timeline, Actividade>(new TimelineComparator());
        this.estatisticas=new HashMap<String, Integer>(estatisticas);
        this.amigos=new ArrayList<String>();
        this.myCaches = caches.clone();
    }
    
    public Utilizador(Utilizador u) {
        this.email=u.getEmail();
        this.password=u.getPassword();
        this.nome=u.getNome();
        this.genero=u.getGenero();
        this.morada=u.getMorada();
        this.timeline_nascimento=u.getTimelineNascimento();
        this.actividades=u.getAtividades();
        this.estatisticas=u.getEstatisticas();
        this.amigos=u.getAmigos();
        this.myCaches = u.getMyCaches();
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
        return this.actividades;
    }
    
    public HashMap<String, Integer> getEstatisticas() {
        return this.estatisticas;
    }
    
    public ArrayList<String> getAmigos() {
        return amigos;
    }
    
    public Caches getMyCaches()
    {   return this.myCaches.clone();}
    
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
        this.actividades=aux;
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
    
    public void setAmigos(ArrayList<String> amigos) {
        this.amigos = amigos;
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
     * Adiciona um amigo a lista de amigos
     *  
     */
    
    public void addAmigo(String email)
    {
        this.amigos.add(email);
    }
    
    /**
     *  Adiciona uma actividade ao perfil
     *      
     */
    public void addActividade(String nomeAmigo, String acontecimento)
    {
        ActividadeAmigo actividade = new ActividadeAmigo(this.getEmail(),nomeAmigo,acontecimento);
        this.actividades.put(actividade.getTime(),actividade);
    }
    
    
    
    /**
     * Remove um amigo
     */
    public void removeAmigo(String email)
    {
        this.amigos.remove(email);
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
                 && this.morada.equals(c.getMorada()) && this.timeline_nascimento.equals(c.getTimelineNascimento()) && this.actividades.equals(c.getAtividades())
                 && this.estatisticas.equals(c.getEstatisticas()) && this.amigos.equals(c.getAmigos())); // falta adicionar equals à classe Caches);
    }
    
    /**
     * toString
     */
    public String toString() {
        return new String(this.email+ " " +this.password+ " " +this.nome+ " " +this.genero+ " " +this.morada+ " " +this.timeline_nascimento.toString());
    }
    

    
}
