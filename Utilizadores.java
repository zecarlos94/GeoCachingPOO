import java.util.ArrayList;

public class Utilizadores {

  /**Variáveis de instância*/
  private String nome_grupo;
  private ArrayList<Utilizador> users;

  
  //capacidade do stand (em número de veículos)
  private int capacidade;
  
  //capacidade inicial do Stand: valor por omissão
  public static final int capacidade_inicial = 10000;
  
  //construtores
  public Utilizadores() {
    this.nomeStand = new String();/*ou "LEI" ,por exemplo*/
    this.users = new ArrayList<Utilizador> (capacidade_inicial);
    this.capacidade = capacidade_inicial;
  }
  
  public Utilizadores(String nome, int capacidade) {
    this.nome_grupo = nome;
    this.users = new ArrayList<Utilizador> (capacidade);
    this.capacidade = capacidade;
  }
  
  public Utilizadores(Utilizadores a) {
    this.nome_grupo = a.getNGrupo();
    this.users     = a.getUtilizadores();
    this.capacidade = a.getCapacidade();
  }
  
    /*Métodos de instância**/
  
  public String getNGrupo(){
    return nome_grupo;
    }
    
  public ArrayList<Utilizador> getUtilizadores(){
    int tamanho=users.size;
    ArrayList<Utilizador> u = new ArrayList<Utilizador> (tamanho);
    for(int i=0;i<tamanho;i++){
      u.add(i,this.users.get(i).clone());  
    }
    return u;
    }
    
  public int getCapacidade(){
    return capacidade;
    }
    
  public void setNGrupo(String nome){
    this.nome_grupo=nome;
    }
    
  public void setUtilizadores(ArrayList<Veiculo> u){
   this.users.clear();
   for(Utilizador uzd : u){
    this.users.add(uzd.clone());     
    }
    }
    
  public void setCapacidade(int cp){
    this.capacidade=cp;
    }
  
  /**
   * Método que insere um utilizador no grupo de todos os utilizadores.
   * 
   */
   public void insereUtilizador(Utilizador urz) {
     users.add(urz.clone());
  }
   
   /**
    * Método que verifica se um determinado utilizador está no
    * grupo que contem todos os utilizadores registados.
    */
    public boolean existeUtilizador(Utilizador urz) {
     return users.contains(urz);   
    }
    
    
    /**
     * Método que verifica se um utilizador cuja nome é conhecido, 
     * está no grupo que contem todos os utilizadores registados.
     */
    public boolean existeUtilizadorPorNome(String nm) {
     for(Utilizador urz : users){
       if(this.urz.getUsername().equals(nm)) return true;
        }
     return false;  
    }
    
     /**
     * Método que verifica se um utilizador, cuja email é conhecido, 
     * está no grupo que contem todos os utilizadores registados.
     */
    public boolean existeUtilizadorPorEmail(String eml) {
     for(Utilizador urz : users){
       if(this.urz.getEmail().equals(eml)) return true;
        }
     return false;  
    }
    
     /**
     * Método que verifica se um utilizador, cuja morada é conhecida, 
     * está no grupo que contem todos os utilizadores registados.
     */
    public boolean existeUtilizadorPorMorada(String addr) {
     for(Utilizador urz : users){
       if(this.urz.getAdress().equals(addr)) return true;
        }
     return false;  
    }

     /**
     * Método que verifica se um veículo, cuja data de nascimento é conhecida, 
     * está no grupo que contem todos os utilizadores registados.
     */
    public boolean existeUtilizadorPorDN(String data) {
     for(Utilizador urz : users){
       if(this.urz.getBthdate().equals(data)) return true;
        }
     return false;  
    }
    
    

    /**
     * equals
     * 
     */
    public boolean equals(Object o) {
    if(this==o) {
      return true;
     }
     if ((o==null)||(this.getClass()!=o.getClass())) {
      return false;
     }
    else{
      Utilizadores a = (Utilizadores) o;
      return (this.nome_grupo.equals(a.getNGrupo()) && this.capacidade==(a.getCapacidade()) && this.users.equals(a.getUtilizadores()));
    }       
   }
        
    /**
     * toString
     */
   public String toString() {
      int tamanho=users.size;
      StringBuilder sb = new StringBuilder();
      sb.append("Nome do grupo de utilizadores é ");
      sb.append(this.nome_grupo+"\n");
      sb.append("Lista de utilizadores: ");
      for(Utilizador urz : users){
         sb.append(urz.toString()+"\n");
        }  
      sb.append("A capacidade do grupo de utilizadores é ");
      sb.append(this.capacidade+"\n");
      return (sb.toString());
    }
    
    /**
     * clone
     */
    public Utilizadores clone() {
     return new Utilizadores(this);
    }

    /*
    public int hascode() {
     return 0;
    }

    public boolean compare() {
     return True;
    }
    */

}