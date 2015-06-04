import java.util.*;
import static java.lang.System.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class Main
{
    private Main() {}
    
    private static GeoCaching c=new GeoCaching();
    
    public static void main(String args[]) {

        String user = menuInicial();
        
        if(user==null) out.printf("\nSaiu da aplicação! Adeus!\n");     // se o utilizador nao criar conta nem aceder à sua, então fechou a aplicação
        else if(c.isAdmin( user )) {
                                                Scanner sc=new Scanner(System.in); 
                                                out.println("1- Aceder ao menu de utilizador\n 2- Aceder ao menu de admin\n 3 - Sair");
                                                int optn = sc.nextInt();
                                                do{
                                                        switch (optn){
                                                            case 1: menuUser(user);break;
                                                            case 2: menuAdmin(user);break;
                                                            default:break;}
                                                }while(optn!=3);
                                            }
        else menuUser(user);
        out.printf("\nSaiu da aplicação! Adeus!\n");
    }
    
    /**
     *  Menu inicial, devolve a conta do utilizador caso tenha feito login ou criado uma.
     *  Se nenhuma das ações se verifica, significa que o utilizador decidiu sair da aplicação e devolve null.
     *  Recebe a estrutura de dados com todos os utilizadores para verificar a autencidade do login ou para adicionar a sua caso decida criar.
     */
    public static String menuInicial() {
        String user = null;
        Scanner sc=new Scanner(System.in); 
        int opção=0;
        out.printf("Bem-vindo à aplicação de GeoCaching!\n");
        do {
            out.printf("\nInsira uma opção:\n   1-Sair\n   2-Aceder à conta\n   3-Criar nova conta\n\n");
            opção=sc.nextInt();
            if(opção==1) {
                out.printf("\nTem a certeza que deseja sair?\n   1-Sim\n   2-Não\n\n");
                opção=sc.nextInt();
            }
            else if(opção==2) user = login();
            else if(opção==3) user = signin();
            else out.printf("Introduza uma opção válida!\n\n");
        } while(opção!=1);
        return user;
    }
    
    /**
     * Acede à conta do utilizador, devolvendo o seu email caso o login seja bem sucedido
     */
    public static String login() {
        Scanner sc=new Scanner(System.in);     
        int cicle=0, i=0;
        
        out.printf("\nInsira o seu email: ");
        String email =sc.next();
   
        if(c.contaExiste(email)) {
      
            do {
                out.printf("Introduza a password: ");
                String pw =sc.next();
                if(c.passwordCerta(email,pw)) break;        // login bem sucedido return u;
                else {
                    out.printf("\nPassword Incorreta!\n");
                    cicle=1; i++;
                }
            } while(cicle==1 && i<3);
            if(i==3) {
                email =null ;      // Acesso negado uma vez que falhou as tentativas todas, de volta ao menu principal
                out.printf("\n\nEsgotou o limite de tentativas!\n\n");
            }
        }
        else {out.printf("\nNão existe nenhum utilizador com o email dado!\n"); return null;} 
        return email;
    }
    
    /**
     * Cria um novo utilizador
     */
    public static String signin() {
        Scanner sc=new Scanner(System.in); 
        String email;
        int cicle, dia, mes, ano;
        do {
            out.printf("\nInsira o email: "); 
            email =sc.next();
            if(c.contaExiste(email)) {
                out.printf("O email já existe!");
                cicle=1;
            }
            else cicle=0;
        } while(cicle==1);
        
        out.printf("Insira a password: "); 
        String password =sc.next();
        out.printf("Insira o nome: "); 
        String nome =sc.next();
        out.printf("Insira o género: ");
        String genero =sc.next(); 
        out.printf("Insira a morada: "); 
        String morada =sc.next(); 
        
        do {
            out.printf("Insira a timeline de nascimento:\n");
            out.printf("   Dia: "); dia=sc.nextInt();
            out.printf("   Mês: "); mes=sc.nextInt();
            out.printf("   Ano: "); ano=sc.nextInt();
            if(!validate(dia, mes, ano)) cicle=1;
            else cicle=0;
        } while(cicle==1);
        Timeline timeline_nascimento =new Timeline(dia, mes, ano);
        Utilizador novoUser = new Utilizador(email,password,nome, genero.charAt(0), morada, timeline_nascimento);
        c.addUtilizador(novoUser);
       
        out.printf("\nConta criada com sucesso!\n");
        return email;
    }
    
     /**
     * Valida uma timeline
     */
    public static boolean validate(int day, int month, int year) {
        if(month>=1 && month<=12) {
            if((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && day>0 && day<=31) return true;
            else if((month==4 || month==6 || month==9 || month==11) && day>0 && day<=30) return true;
            else if(month==2 && year%4==0 && day>0 && day<=29) return true;
            else if(month==2 && year%4!=0 && day>0 && day<=28) return true;
            else return false;
        }
        else return false;
    }     
    
    /**
     *  Menu do utilizador
     *  Só tem acesso aos seus dados e aos dados dos outros utilizadores.
     *  Nota: não deixar o utilizador remover/adicionar livremente em SystemCaches nem em Utilizadores e também nao pode remover reports
     *  O utilizador tem uma variável nova chamada myCaches com as caches que ele criou
     *  Adicionar no main a cache ou o report às respectivas estruturas
     */
    public static void menuUser(String email) {
        Scanner sc=new Scanner(System.in); 
        int optn;
        Utilizador u = c.getUtilizador(email);
        String emailAmigo;
        do {
            /* Falta opçoes de editar conta */
            // fazer submenus, menu mycaches com (add remover ver)
            if(c.getInscricoesAbertas() ) out.printf("Inscrições abertas para o evento , 9 - Para registar\n"); 
            out.printf("\nOpções de Conta:\n   1-Informações\n   2-Adicionar Amigo\n   3-Remover Amigo\n   4-Informação dos amigos\n");
            out.printf("   5-Reportar Cache\n   6-Adicionar Cache\n   7-Ver as minhas caches\n   8- Remover uma das minhas caches\n   0-Sair");
            optn=sc.nextInt();
            switch(optn) {
                case 1: 
                        infoUser(u);
                        break;
                case 2:
                         out.printf("\nInsira o email do amigo que deseja adicionar: "); emailAmigo =sc.next();
                         if(u.getAmigos().contains(emailAmigo)) out.printf("\nVocê já adicionou este amigo!\n");
                         else if(u.getEmail().equals(emailAmigo)) out.printf("\nVocê não se pode adicionar como amigo!\n");
                         else if(c.contaExiste(emailAmigo)) {
                             c.addAmizade(u.getEmail(),emailAmigo);
                             out.printf("\nAmigo adicionado com sucesso!\n");
                         }
                         else out.printf("\nNão existe nenhum utilizador registado com esse email!\n");
                         break;
                 case 3: 
                        out.printf("\nInsira o email do amigo que deseja remover: "); emailAmigo=sc.next();
                        if(!u.getAmigos().contains(emailAmigo)) out.printf("\nNão existe nenhum amigo com este email, por isso não é possível remover!\n");
                        else {
                            c.removeAmizade(u.getEmail(),emailAmigo);
                            out.printf("\nAmigo removido!\n");
                        }
                        break;
                 case 4: 
                        out.printf("\nInsira o email do amigo cuja informação deseja ver: "); emailAmigo=sc.next();
                        if(!u.getAmigos().contains(emailAmigo)) out.printf("\nNão existe nenhum amigo com este email!\n");
                        else {
                            Utilizador amigo =c.getUtilizador(emailAmigo);
                            infoUser(amigo);
                        }
                        break;
                  case 5: 
                        out.printf("\nInsira a latitude e a longitude da cache que deseja reportar:");
                        Coordenadas coordenadas=scanCoordenadas();
                        out.printf("\nDescreva a razão do seu report numa linha\n"); 
                        String texto=sc.next(); 
                        Report report=(Report) new Report(coordenadas, texto);      // Cria um report com as horas do sistema
                        c.addReport(report);
                        out.printf("\nReport adicionado com sucesso\n");
                        break;
                  case 6: 
                        Cache ce;
                        ce=criaCache();
                        c.addCache(ce);
                        break;
                  case 7:
                        u.getMyCaches().toString();
                        break;
                  case 8:
                        out.printf("\nInsira as coordenadas da  cache que deseja remover:");
                        Coordenadas coord=scanCoordenadas();
                        if(u.getMyCaches().existe(coord)){
                        c.removeCache(coord);
                        out.printf("\nCache removida com sucesso\n");
                    } else out.printf("\nEssa cache não lhe pertence\n");
                        break;
                  case 9:
                         if(c.getInscricoesAbertas())
                         {
                             try{
                             c.registarEvento(u.getEmail());
                            }
                            catch(EventoCheioException e ) { out.printf(" Desculpe mas o evento já excedeu o limite de participantes\n");  }
                         }
                            
                  default:
                        System.out.printf("\nInsira uma opção válida!\n");
                        break;
            }
        } while(optn!=0);
    }
    
    /**
     *  Pede ao utilizador a latitude e longitude, validanda e devolve o par no final
     */
    public static Coordenadas scanCoordenadas() {
         Scanner sc=new Scanner(System.in); 
         int i;
         double x,y;
         do {
             i=0;
             out.printf("Insira os valores referentes à latitude:\n");
             out.printf("    latitude: "); x=sc.nextInt();
             out.printf("Insira os valores referentes à longitude:\n");
             out.printf("    longitude: "); y=sc.nextInt();
             if(!validaCoord("latitude", x)){
                  i=1;
                  out.printf("\nInsira coordenadas válidas!");
             }
             if(!validaCoord("longitude", y)) {
                  i=1;
                  out.printf("\nInsira coordenadas válidas!");
             }
         } while(i==1);
         Coordenadas novo = new Coordenadas(x,y);
         return novo;
    }
    
    public static void infoUser(Utilizador u) {
        out.printf("\nInformação do Utilizador:\n");
        out.println("   Email: " +u.getEmail());
        out.println("   Password: " +u.getPassword());
        out.println("   Nome: " +u.getNome());
        out.println("   Género: " +u.getGenero());
        out.println("   Morada: " +u.getMorada());
        out.println("   Data de Nascimento: " +u.getTimelineNascimento().toString());
        out.println("   Amigos: " +u.getAmigos().toString());
        ArrayList<Actividade> last10=u.ultimasAtividades();
        out.printf("\nÚltimas 10 atividades: "); last10.toString();
    }
    
    public static boolean validaCoord(String escala, double x) {
        if(escala.equals("latitude") && (x<0))return false;
        else if(x<0) return false;
        return true;
    }
    

    public static void menuAdmin(String email) {
        Scanner sc=new Scanner(System.in); 
        int optn;
        Utilizador u = c.getUtilizador(email);
        do {
            // fazer submenus, menu mycaches com (add remover ver)
            out.printf("\nOpções de Administrador:\n 1 - Ver reports \n 2 - Remover uma cache\n 3 - Abrir inscrições de evento\n 0 - Sair");
            optn=sc.nextInt();
            switch(optn) {
                case 1: 
                        c.getReports().toString();
                        break;
                case 2:
                        out.printf("\nInsira a latitude e a longitude da cache que deseja remover:");
                        Coordenadas coord=scanCoordenadas();
                        c.removeCache(coord);
                        break;
                case 3:
                  // por completar
                        out.printf("\nInsira o limite de participantes\n");
                        int l = sc.nextInt(); c.setLimiteParticipantes(l);

                      break;
                default:
                        System.out.printf("\nInsira uma opção válida!\n");
                        break;
            }
        } while(optn!=0);
    }
    
    public static Cache criaCache() {
        Scanner cs = new Scanner(System.in);
        out.printf("\nInsira a cache que pretende criar: ");
        String escolha = cs.next();
        Cache a=null;
        if(escolha.equals("MicroCache")){
            out.printf("\nInsira a latitude e a longitude da cache que deseja remover:");
            Coordenadas crd=scanCoordenadas();
            MicroCache cache1 = new MicroCache(crd);
            a=cache1;
        }
        else if(escolha.equals("MisteryCache")){
            out.printf("\nInsira a latitude e a longitude da cache que deseja remover:");
            Coordenadas crd=scanCoordenadas();
            ArrayList<ArrayList<String>> p = criaPerguntasRespostas();
            MisteryCache cache1 = new MisteryCache(crd,p);
            a=cache1;
        }
        else if(escolha.equals("MultiCache")){
            out.printf("\nInsira a latitude e a longitude da cache que deseja remover:");
            Coordenadas crd=scanCoordenadas();
            ArrayList<Coordenadas> check = criaCheckpoints();
            MultiCache cache1 = new MultiCache(crd,check);
            a=cache1;
        }    
        return a;
    }
    
    public static ArrayList<ArrayList<String>> criaPerguntasRespostas(){
        Scanner pr=new Scanner(System.in);
        out.printf("\nInsira o número de perguntas que pretende criar:");
        int quantos=0,l,j=0;
        String s="N/A";
        quantos=pr.nextInt();
        ArrayList<String> par;
        ArrayList<ArrayList<String>> prsp = new ArrayList<ArrayList<String>>(quantos);
        for(l=0;l<quantos;l++){
          par=new ArrayList<String>(2);
          if(j==0){out.printf("\nInsira a pergunta:");s=pr.next();j=1;}
          if(j==1){out.printf("\nInsira a resposta:");s=pr.next();j=0;}
          par.add(s);
        }
        return prsp;
    }
    
    public static ArrayList<Coordenadas> criaCheckpoints(){
        Scanner a = new Scanner(System.in);
        out.printf("\nInsira o número de checkpoints que pretende criar:");
        int quantos=0,i;
        quantos=a.nextInt();
        ArrayList<Coordenadas> checkps = new ArrayList<Coordenadas>(quantos);
        for(i=0;i<quantos;i++){
            out.printf("\nInsira a latitude e a longitude da cache que deseja remover:");
            Coordenadas cd=scanCoordenadas();
            checkps.add(cd.clone());
        }
        return checkps;
    }
    
    
}
