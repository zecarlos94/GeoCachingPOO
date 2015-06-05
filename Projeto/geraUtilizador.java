import java.util.*;
 
 public class geraUtilizador
{

  private Utilizador utilizador;
 
  public geraUtilizador() { 
      Timeline t = geraData();
      String password = new String("pw");
      String morada = geraMorada();
      char genero = geraGenero();
      String email; 
      String nome;
      //String aux = genero+" ";
      // aux.equals("M")
      if(genero == 'M' ){
         nome = geraNomesMas();
        
      }else{
       
        nome = geraNomesFem();
        }
        

       email = geraEmail(nome);
        
       this.utilizador = new Utilizador(email,password,nome,genero,morada,t);
      
	}
 

  public Utilizador getUtilizador(){
        return this.utilizador;
  }

 
  public static char geraGenero() {
    final String alphabet = "MF";
    Random r = new Random();
    return alphabet.charAt(r.nextInt(2));
 }
 
 
 public static String geraNomesMas() {
    String estados[] = {"Manuel","João","José","Carlos","Gustavo","Tiago","Ricardo","António","Rui",
    "Diogo","André","Luís"};
    Random rn = new Random();
    int i = rn.nextInt(12);
    return estados[i];
 }
 
 public static String geraNomesFem(){
    String estados[] = {"Joana","Daniela","Rita","Beatriz","Ana","Cristina","Vanessa","Sara",
    "Bruna","Paula","Sofia","Erica","Maria","Rosa","Olga","Matilde","Leonor","Francisca","Teresa"};
    Random rn = new Random();
    int i = rn.nextInt(18);
    return estados[i];
 }
 
 public static Timeline geraData() {
     int dia;
     int anos[]={1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997};
     Random rn = new Random();
     int ano=rn.nextInt(17)+1; 
     int mes=rn.nextInt(12)+1; 
     if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12) dia=rn.nextInt(31)+1;
     else if(mes==2) {
         if(ano%4==0) dia=rn.nextInt(29)+1;
         else dia=rn.nextInt(28)+1;
     }
     else dia=rn.nextInt(30)+1;
     return new Timeline(dia, mes, anos[ano]);
 }
 
  
 public static String geraEmail(String nome) {
    Random rn = new Random();
    StringBuilder sb = new StringBuilder();
    int n = rn.nextInt(2000);
    sb.append(nome + n + "@hotmail.com");
    return sb.toString();
 }
 
 public static String geraMorada() {
    String estados[] = {"Rua Braga","Rua Porto","Rua Gaia","Rua Maia","Rua Coimbra","Rua Viana","Rua Lisboa","Rua Algarve",
    "Rua Viseu","Rua Aveiro"};
    Random rn = new Random();
    int i = rn.nextInt(10);
    return estados[i];
 }
 
}

