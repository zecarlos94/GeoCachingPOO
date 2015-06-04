import java.util.Random;
 
 public class geraUtilizador
{

  private Utilizador utilizador;
 
  public geraUtilizador() { 
      Timeline t = new Timeline();
      String password = new String("pw");
      String morada = geraMorada();
      char genero = geraGenero();
      String email; 
      String nome;
      String aux = genero+" ";
      if(aux.equals("M")){
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

