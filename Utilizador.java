import java.util.ArrayList;

/*
Utilizadores
Para cada utilizador guarda-se a seguinte informaçãoo pessoal:(setters allowed & getters allowed)
• email, que é a chave do utilizador; 
• password;
• nome;
• género;
• morada;
• data de nascimento;

Além desta informação, que deve poder ser editada, o utilizador regista também:(setters not allowed && getters allowed)
• A informação das actividades que realizou;
• As estatísticas dos seus registos nos diversos tipos de cache;
• E o conjunto dos utilizadores que pertencem á sua rede de amigos.
*/

public class Utilizador
{
    /** Variáveis de instância*/
    private String email;/**email que permite fazer o login á sua conta de utilizador.*/
    private String password;/**password que garante o acesso ao utilizador á sua conta.*/
    private String name;/**Nome do utilizador.*/
    private String gender;/**Se é Masculino ou Feminino.*/
    private String address;/**Dá a informação relativa á morada de um utilizador.*/
    private String bth_date;/**Dá a informação sobre a data de aniversário de um utilizador.*/

    public ArrayList<Actividades> actividades;/**As estatísticas dos seus registos nos diversos tipos de cache.*/
    public ArrayList<Estatísticas> estatisticas;/**A informação das actividades que realizou.*/
 	public ArrayList<Amigo> amigos;/**E o conjunto dos utilizadores que pertencem á sua rede de amigos.*/
   

    public static final int capacidade_inicial = 10000;/**Para ter espaço para muitos eventos e muitos amigos*/
    /**
     * Construtor para objetos da classe Utilizador
     */
    public Utilizador()
    {
        /** inicializa as variáveis de instância*/
        this.email="something@example.com";
        this.password="N/A";
        this.name="N/A";
        this.gender="M/F";
        this.address="Rua qualquer";
        this.bth_date="31-03-3015";
        this.actividades=new ArrayList<Actividades> (capacidade_inicial);
        this.estatísticas=new ArrayList<Estatísticas> (capacidade_inicial);
        this.amigos=new ArrayList<Amigo> (capacidade_inicial);
    }
    
     public Utilizador(String mail,String pass,String nm,String gd,String adrs,String bydate,int capacidade_actividades,int capacidade_estatisticas,int capacidade_amigos)
    {
    	this.email=mail;
        this.password=pass;
        this.name=nm;
        this.gender=gd;
        this.address=adrs;
        this.bth_date=bydate;
        this.actividades=new ArrayList<Actividades> (capacidade_actividades);
        this.estatísticas=new ArrayList<Estatísticas> (capacidade_estatisticas);
        this.amigos=new ArrayList<Amigo> (capacidade_amigos);
    }
    
     public Utilizador(Utilizador user)
    {
    	this.email=user.getEmail();
        this.password=user.getPassword();
        this.name=user.getUsername();
        this.gender=user.getGender();
        this.address=user.getAddress();
        this.bth_date=user.getBthdate();
    }
    
    /*Métodos de instância**/
    
    public String getEmail(){
     return email;
    }
    
    public float getPassword(){
     return password;
    }
    
    public String getUsername(){
     return name;
    }
    
    public float getGender(){
     return gender;
    }
    
    public float getAddress(){
     return address;
    }
    
    public float getBthdate(){
     return bth_date;
    }
    
    public void setEmail(String eml){
     this.email=eml;
    }
    
    public void setPassword(String psw){
     this.password=psw;
    }
    
    public void setUsername(String usnm){
     this.name=usnm;
    }
    
    public void setGender(String g){
     this.gender=g;
    }
    
    public void setAddress(String addrs){
     this.address=addrs;
    }
 
	public void setBthdate(String bdt){
     this.bth_date=bdt;
    }
    

    /*Equals & toString and clone**/
    
    public boolean equals(Utilizador usr){
    	return(email==usr.getEmail() && password==usr.getPassword() && name==usr.getUsername() && gender==usr.getGender() && address==usr.getAddress() && bth_date==usr.getBthdate());
    }
   
    public String toString(){
     return new String("O Utilizador possuí as seguintes caracteristicas: \n" + "Email de login é: " +email+ ".\nA password é " +password+ ".\nO nome é " +name+ ".\nO género é " +gender+ ".\nA morada é " + address + ".\nE a sua da de nascimento é " +bth_date+".\n");
    }
    
    public Utilizador clone(){
      return new Utilizador(this);
    }

    /*
    public int hascode(){
      return 0;
    }

    public boolean compare(){
      return True;
    }
	*/

   public void mudaEmail(Utilizador u,String mls){
       u.setEmail(mls);
    }

   public void mudaNome(Utilizador u,String str){
       u.setNome(str);
    }
    
   public void mudaPassword(Utilizador u,String pssw){
       u.setPassword(pssw);
    }

   public void mudaMorada(Utilizador u,String mrd){
       u.setAddress(mrd);
    }
 
   public void mudaDataN(Utilizador u,String date){
       u.setBthdate(date);
    }


   public void mudaGenero(Utilizador u,String gnr){
       u.setGender(gnr);
    }

}
