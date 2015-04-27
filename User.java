import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
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

public class User
{
    /** Variáveis de instância*/
    private String email;/**email que permite fazer o login á sua conta de utilizador.*/
    private String password;/**password que garante o acesso ao utilizador á sua conta.*/
    private String name;/**Nome do utilizador.*/
    private String gender;/**Se é Masculino ou Feminino.*/
    private String address;/**Dá a informação relativa á morada de um utilizador.*/
    private String bth_date;/**Dá a informação sobre a data de aniversário de um utilizador.*/

    public TreeSet<User> friends;/**E o conjunto dos utilizadores que pertencem á sua rede de amigos.*/
    public TreeSet<Cache> stats;/**A informação das actividades que realizou.*/
    public TreeSet<Activities> activities;/**As estatísticas dos seus registos nos diversos tipos de cache.*/
   
    /**
     * Construtor para objetos da classe Utilizador
     */
    public User()
    {
        /** inicializa as variáveis de instância*/
        this.email="something@example.com";
        this.password="N/A";
        this.name="N/A";
        this.gender="M/F";
        this.address="Address";
        this.bth_date="00-00-0000";
        this.friends=new TreeSet<User> ();
        this.stats=new TreeSet<Cache> ();
        this.activities=new TreeSet<Activities> ();
    }
    
     public User(String mail,String pass,String nm,String gd,String adrs,String bydate)
    {
        this.email=mail;
        this.password=pass;
        this.name=nm;
        this.gender=gd;
        this.address=adrs;
        this.bth_date=bydate;
        this.friends=new TreeSet<User> ();
        this.stats=new TreeSet<Cache> ();
        this.activities=new TreeSet<Activities> ();
    }
    
     public User(User usr)
    {
        this.email=usr.getEmail();
        this.password=usr.getPassword();
        this.name=usr.getUsername();
        this.gender=usr.getGender();
        this.address=usr.getAddress();
        this.bth_date=usr.getBthdate();
        this.friends = new TreeSet<User>();
        this.friends = (TreeSet)usr.friends.clone();  
        this.stats= new TreeSet<Cache>();
        this.stats = (TreeSet)usr.stats.clone();  
        this.activities = new TreeSet<Activities>();
        this.activities = (TreeSet)usr.activities.clone();  
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
    
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      User usr = (User) obj;
      return(email==usr.getEmail() && password==usr.getPassword() && name==usr.getUsername() && gender==usr.getGender() && address==usr.getAddress() && bth_date==usr.getBthdate());
    }
   
    public String toString(){
     return new String("O Utilizador possuí as seguintes caracteristicas: \n" + "Email de login é: " +email+ ".\nA password é " +password+ ".\nO nome é " +name+ ".\nO género é " +gender+ ".\nA morada é " + address + ".\nE a sua da de nascimento é " +bth_date+".\n");
    }
    
    public User clone(){
      return new User(this);
    }

    /*
    public int hascode(){
      return 0;
    }

    public boolean compare(){
      return True;
    }
    */

   public void changeEmail(User u,String mls){
       u.setEmail(mls);
    }

   public void changeName(User u,String str){
       u.setName(str);
    }
    
   public void changePassword(User u,String pssw){
       u.setPassword(pssw);
    }

   public void changeAdress(User u,String mrd){
       u.setAddress(mrd);
    }
 
   public void changeBthdate(User u,String date){
       u.setBthdate(date);
    }


   public void changeGender(User u,String gnr){
       u.setGender(gnr);
    }

}
