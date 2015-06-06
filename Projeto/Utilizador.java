import java.util.*;
import java.io.*;

public class Utilizador implements Serializable
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
    private StatsUtilizador estatisticas;    
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
        this.estatisticas= new StatsUtilizador();
        this.amigos=new ArrayList<String>();
        this.myCaches = new Caches();
    }
    /**
     *  Construtor usado para criar conta de utilizador
     */
    public Utilizador(String email, String password, String nome, char genero, String morada, Timeline timeline_nascimento){
        this.email=email;
        this.password=password;
        this.nome=nome;
         this.morada=morada;
        this.genero=genero;
        this.timeline_nascimento=new Timeline(timeline_nascimento);
         this.estatisticas= new StatsUtilizador();
        this.amigos=new ArrayList<String>();
        this.myCaches = new Caches();
        this.actividades=new TreeMap<Timeline, Actividade>(new TimelineComparatorDecrescente());
    }
    
   
    public Utilizador(String email, String password, String nome, char genero, String morada, Timeline timeline_nascimento, TreeMap<Timeline, Actividade> actividades, StatsUtilizador estatisticas, ArrayList<String> amigos, Caches caches) throws NumberFormatException {
        this.email=email;
        this.password=password;
        this.nome=nome;
         this.morada=morada;
        this.genero=genero;
        this.timeline_nascimento=new Timeline(timeline_nascimento);
        this.actividades=new TreeMap<Timeline, Actividade>(new TimelineComparatorDecrescente());
        this.estatisticas=estatisticas;
        this.amigos=new ArrayList<String>();
        this.myCaches = caches.clone();
    }
    
    public Utilizador(Utilizador u) throws NumberFormatException {
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
    
    public StatsUtilizador getEstatisticas() {
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
    
    public void setTimelineNascimento(Timeline timeline_nascimento) throws NumberFormatException {
        this.timeline_nascimento=timeline_nascimento.clone();
    }
    
    public void setAtividades(TreeMap<Timeline, Actividade> timeline) throws NumberFormatException {
        TreeMap<Timeline, Actividade> aux=new TreeMap<Timeline, Actividade>(new TimelineComparatorDecrescente());
        Set<Map.Entry<Timeline, Actividade>> eset=timeline.entrySet();
        Iterator<Map.Entry<Timeline, Actividade>> it=eset.iterator();
        while(it.hasNext()) {
            Map.Entry<Timeline, Actividade> elem=it.next();
            aux.put(elem.getKey().clone(), elem.getValue());
        }
        this.actividades=aux;
    }
    
    
    public void setEstatisticas(StatsUtilizador estatisticas) {
        this.estatisticas=estatisticas;
    }
    
    public void setAmigos(ArrayList<String> amigos) {
        this.amigos = amigos;
    }
    
    /**
     *  Recebe os emails de todos os admins e verifica se faz parte da lista
     * 
     */
    
    public boolean isAdmin(ArrayList<String> admins)
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
        Timeline t = new Timeline();
        Actividade actividade = new ActividadeAmigo(t,this.nome,nomeAmigo,acontecimento);
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
     *  Gera a actividade de descoberta de Cache e actualiza as estatisticas
     */
    
    public void descobertaCache(Cache cache, int geoCoins) 
    {
        Actividade actividade = new ActividadeCache(new Timeline(),this.getNome(),cache.clone(),"descobriu",geoCoins);
        this.actividades.put(actividade.getTime(),actividade);
        
       
        geraAtmosfera atmosfera = new geraAtmosfera(); // Gera clima de acordo com o mes do sistema
        
        estatisticas.add(cache.clone(),geoCoins, atmosfera.getClima());
        
        
    }
    /**
     *  Adiciona uma cache às Caches do utilizador e gera a respectiva actividade
     */
    public void addCache(Cache cache)
    {
        Actividade actividade = new ActividadeCache(new Timeline(),this.getNome(),cache.clone(),"adicionou");
        this.actividades.put(actividade.getTime(),actividade);
        this.myCaches.add(cache);
    }
     
    /**
     *  Remove uma cache às Caches do utilizador e gera a respectiva actividade
     */
    public void removeCache(Cache cache)
    {
        Actividade actividade = new ActividadeCache(new Timeline(),this.getNome(),cache.clone(),"removeu");
        this.actividades.put(actividade.getTime(),actividade);
        this.myCaches.remove(cache);
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
                 && this.estatisticas.equals(c.getEstatisticas()) && this.amigos.equals(c.getAmigos()));
    }
    
   /**
     * toString
     */
   public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Email:"+email+"\nNome:"+nome+"\nGenero:"+genero+"\nMorada:"+morada+"\nData de Nascimento:"+timeline_nascimento.toString()+"\n");
       
       sb.append("Actividades:\n");
       Iterator<Map.Entry<Timeline,Actividade>> it = actividades.entrySet().iterator();
       while(it.hasNext())
       {
           sb.append( it.next().getValue().toString() + "\n");
        }
       
       
       sb.append("Estatisticas:\n" + estatisticas.toString() + "\n");
       sb.append("Lista de amigos:\n" + this.amigos.toString() + "\n");
       sb.append("Lista de caches:\n" + this.myCaches.toString());
      
       return sb.toString();
               
   }
    
   /**
     * Devolve um ArrayList com as últimas 10 atividades do utilizador
     */
   public String ultimasAtividades() {
        StringBuilder sb = new StringBuilder();
   
       Iterator<Actividade> it = this.actividades.values().iterator();
       while(it.hasNext())
       {
           
           sb.append( it.next().toString() + "\n");
        }
        sb.append("\n");
        return sb.toString();
   }
    
   /**
     * Devolve um ArrayList com as últimas 10 atividades do utilizador
     */
    /*
   public ArrayList<Actividade> ultimasAtividades() {
        ArrayList<Actividade> last10=new ArrayList<Actividade>();
   
       Iterator<Actividade> it = actividades.values().iterator();
       while(it.hasNext())
       {
           
           last10.add(it.next());
        }
        return last10;
   }
   */
}
