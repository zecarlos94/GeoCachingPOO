
import java.util.Random;
/**
 * Escreva a descrição da classe Random aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class geraUtilizador
{
    /*
  private String Email;
  private String Nome;
  private String Password;
  private String Morada;
  private char Genero;
  */
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
    final int N = alphabet.length();
    Random r = new Random();
    return alphabet.charAt(r.nextInt(N));
 }
 /*
 public static String geraPasswords() { 
    String estados[] = {"123456"};
    Random rn = new Random();
    int i = 0;
    return estados[i];
 }
 */
 public static String geraNomesMas() {
    String estados[] = {"Manuel","João","José","Carlos","Gustavo","Tiago","Ricardo","António","Rui",
    "Diogo","André","Luís"};
    Random rn = new Random();
    int i = rn.nextInt(12);
    return estados[i];
 }
 
 public static String geraNomesFem() {
    String estados[] = {"Joana","Daniela","Rita","Beatriz","Ana","Cristina","Vanessa","Sara",
    "Bruna","Paula","Sofia","Erica","Maria","Rosa","Olga","Matilde","Leonor","Francisca","Teresa"};
    Random rn = new Random();
    int i = rn.nextInt(19);
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
 
 
 
  /*
   *public static String geraEmail() {
   *String estados[] = {"Manuel@gmail.com","João@gmail.com","José@gmail.com","Carlos@gmail.com","Gustavo@gmail.com","Tiago@gmail.com","Ricardo@gmail.com","António@gmail.com","Rui@gmail.com",
   *"Diogo@gmail.com","André@gmail.com","Luís@gmail.com","Joana@gmail.com","Daniela@gmail.com","Rita@gmail.com","Beatriz@gmail.com","Ana@gmail.com","Cristina@gmail.com","Vanessa@gmail.com","Sara@gmail.com",
   *"Bruna@gmail.com","Paula@gmail.com","Sofia@gmail.com","Erica@gmail.com","Maria@gmail.com","Rosa@gmail.com","Olga@gmail.com","Matilde@gmail.com","Leonor@gmail.com","Francisca@gmail.com","Manuel@hotmail.com","João@hotmail.com","José@hotmail.com","Carlos@hotmail.com","Gustavo@hotmail.com","Tiago@hotmail.com","Ricardo@hotmail.com","António@hotmail.com","Rui@hotmail.com",
   *"Diogo@hotmail.com","André@hotmail.com","Luís@hotmail.com","Joana@hotmail.com","Daniela@hotmail.com","Rita@hotmail.com","Beatriz@hotmail.com","Ana@hotmail.com","Cristina@hotmail.com","Vanessa@hotmail.com","Sara@hotmail.com",
   *"Bruna@hotmail.com","Paula@hotmail.com","Sofia@hotmail.com","Erica@hotmail.com","Maria@hotmail.com","Rosa@hotmail.com","Olga@hotmail.com","Matilde@hotmail.com","Leonor@hotmail.com","Francisca@hotmail.com","Manuel@di.uminho.pt","João@di.uminho.pt","José@di.uminho.pt","Carlos@di.uminho.pt","Gustavo@di.uminho.pt","Tiago@di.uminho.pt","Ricardo@di.uminho.pt","António@di.uminho.pt","Rui@di.uminho.pt",
   *"Diogo@di.uminho.pt","André@di.uminho.pt","Luís@di.uminho.pt","Joana@di.uminho.pt","Daniela@di.uminho.pt","Rita@di.uminho.pt","Beatriz@di.uminho.pt","Ana@di.uminho.pt","Cristina@di.uminho.pt","Vanessa@di.uminho.pt","Sara@di.uminho.pt",
   *"Bruna@di.uminho.pt","Paula@di.uminho.pt","Sofia@di.uminho.pt","Erica@di.uminho.pt","Maria@di.uminho.pt","Rosa@di.uminho.pt","Olga@di.uminho.pt","Matilde@di.uminho.pt","Leonor@di.uminho.pt","Francisca@di.uminho.pt"};
   *Random rn = new Random();
   *int i = rn.nextInt(90) + 1;
   *return estados[i];}
 */
}
