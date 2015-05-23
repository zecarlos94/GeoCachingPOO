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
    //private HashMap<String, Cache> caches;
    
    
    public static void main(String args[]) {
        // Criaçao das estruturas principais
        Utilizadores utilizadores=new Utilizadores();
        
        String[] admins = {"Gustavo","ZéBanana","Tiago"}; // Estes nomes são comparados com os emails dos users em isAdmin();
        
        
        
        Caches caches = new Caches();
        
        CacheReports reports = new CacheReports();
        
        Utilizador user= menuInicial(utilizadores,admins);
        
        if(user == null) // se o utilizador nao criar conta nem aceder à sua, então fechou a aplicação
            out.printf("\nSaiu da aplicação! Adeus!\n");
        
            else if(user.isAdmin(admins)) menuAdmin(user,utilizadores,caches,reports);
            
            else menuUser(user,utilizadores,caches,reports);
            
            out.printf("\nSaiu da aplicação! Adeus!\n");
                 
            
        
        
  
        
    }
    
    /**
     * 
     *  Menu inicial, devolve a conta do utilizador caso tenha feito login ou criado uma.
     *      Se nenhuma das ações se verifica, significa que o utilizador decidiu sair da aplicação e devolve null.
     *      Recebe a estrutura de dados com todos os utilizadores para verificar a autencidade do login ou para adicionar
     * a sua caso decida criar.
     * 
     */
    
    public static Utilizador menuInicial(Utilizadores utilizadores, String[] admins)
    {
        Utilizador user = null;
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
            else if(opção==2) user = login(utilizadores,admins);
            else if(opção==3) user = signin(utilizadores);
            else out.printf("Introduza uma opção válida!\n\n");
        } while(opção!=1);
        
        return user;
    }
    
    /**
     * Acede à conta do utilizador, devolvendo a mesma
     */
    public static Utilizador login(Utilizadores utilizadores, String[] admins) {
        Scanner sc=new Scanner(System.in); 
        Utilizador u = null;
        String dados;
        int cicle=0, i=0;
        out.printf("\nInsira o seu email: ");
        dados=sc.next();
        
        boolean isAdmin = false;
        
        for(String adminName : admins)
            if(adminName.equals(dados)) isAdmin = true;         // Temporario estas verificaçoes de admins visto que n temos estados guardados
        
        
        if(utilizadores.existe(dados) && isAdmin == false) {
            u=utilizadores.get(dados);
            do {
                out.printf("Introduza a password: ");
                dados=sc.next();
                if(u.getPassword().equals(dados)) break; // login bem sucedido return u;
                else {
                    out.printf("\nPassword Incorreta!\n");
                    cicle=1; i++;
                }
            } while(cicle==1 && i<3);
            if(i==3) {
                            u = null ; // Acesso negado uma vez que falhou as tentativas todas, de volta ao menu principal
                            out.printf("\n\nEsgotou o limite de tentativas!\n\n");
                           }
        }
        else out.printf("\nNão existe nenhum utilizador com o email dado!\n");
        
        return u;
    }
    
    /**
     * Cria um novo utilizador
     */
    public static Utilizador signin(Utilizadores utilizadores) {
        Scanner sc=new Scanner(System.in); 
        String dados;
        int cicle, dia, mes, ano;
        Utilizador u=new Utilizador();
        do {
            out.printf("\nInsira o email: "); 
            dados=sc.next();
            if(utilizadores.existe(dados)) {
                out.printf("O email já existe!");
                cicle=1;
            }
            else cicle=0;
        } while(cicle==1);
        u.setEmail(dados);
        out.printf("Insira a password: "); 
        dados=sc.next(); u.setPassword(dados);
        out.printf("Insira o nome: "); 
        dados=sc.next(); u.setNome(dados);
        out.printf("Insira o género: ");
        dados=sc.next(); u.setGenero(dados.charAt(0));
        out.printf("Insira a morada: "); 
        dados=sc.next(); u.setMorada(dados);
        do {
            out.printf("Insira a timeline de nascimento:\n");
            out.printf("   Dia: "); dia=sc.nextInt();
            out.printf("   Mês: "); mes=sc.nextInt();
            out.printf("   Ano: "); ano=sc.nextInt();
            if(!validate(dia, mes, ano)) cicle=1;
            else cicle=0;
        } while(cicle==1);
        Timeline timelineNasc=new Timeline(dia, mes, ano);
        u.setTimelineNascimento(timelineNasc);
        utilizadores.add(u);
        out.printf("\nConta criada com sucesso!\n");
        return u;
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
     *  
     *      Só tem acesso aos seus dados e aos dados dos outros utilizadores.
     *      
     *     Nota :
     *                  Não deixar o utilizador remover/adicionar livremente em SystemCaches nem em Utilizadores
     *                          tb nao pode remover reports
     *                  
     *                  O utilizador tem uma variável nova chamada myCaches com as caches que ele criou
     *                  
     *      Acrescentar funçoes noutras classes em vez de spamar codigo aqui ... Tudas as funçoes que nao sejam I/O devem ser feitas nas respectivas classes
     *  
     */
    public static void menuUser(Utilizador u, Utilizadores utilizadores,Caches systemCaches,CacheReports reports) {
        Scanner sc=new Scanner(System.in); 
        int optn;
        String email;
                     /* 
                 *  Depois de validar os dados da Cache ou Report(n se verifica se as coordenadas existem)
                 *      Adicionar no main a cache ou o report às respectivas estruturas
                 *      Voltar a abrir este menu
                 */
     
        do {
            // fazerr submenus, menu mycaches com (add remover ver)
            out.printf("\nOpções de Conta:\n   1-Informações\n   2-Adicionar Amigo\n   3-Remover Amigo\n   4-Informação dos amigos\n");
            out.printf("5-Reportar Cache\n 6-Adicionar Cache\n 8-Ver as minhas caches\n 9- Remover uma das minhas caches 10-");
            optn=sc.nextInt();
            
            
            switch(optn)
            {
                case 1: // Informações do utilizador (falta mostrar as 10 ultimas actividades)
                        infoUser(u);
                        break;
                case 2:// Adicionar amigo (falta gerar a actividade e adicionar ao perfil)
                         out.printf("\nInsira o email do amigo que deseja adicionar: "); email=sc.next();
                         if(u.getAmigos().contains(email)) out.printf("\nVocê já adicionou este amigo!\n");
                         else if(u.getEmail().equals(email)) out.printf("\nVocê não se pode adicionar como amigo!\n");
                         else if(utilizadores.existe(email)) {
                             utilizadores.addAmizade(u.getEmail(),email);
                             out.printf("\nAmigo adicionado com sucesso!\n");
                            }
                         else out.printf("\nNão existe nenhum utilizador registado com esse email!\n");
                         break;
                 case 3: // Remover amigo (falta gerar a actividade e adicionar ao perfil)
                        out.printf("\nInsira o email do amigo que deseja remover: "); email=sc.next();
                        if(!u.getAmigos().contains(email)) out.printf("\nNão existe nenhum amigo com este email, por isso não é possível remover!\n");
                        else {
                            utilizadores.removeAmizade(u.getEmail(),email);
                            out.printf("\nAmigo removido!\n");
                        }
                        break;
                 case 4: // Informações dos amigos
                        out.printf("\nInsira o email do amigo cuja informação deseja ver: "); email=sc.next();
                        if(!u.getAmigos().contains(email)) out.printf("\nNão existe nenhum amigo com este email!\n");
                        else {
                            Utilizador friend=utilizadores.get(email).clone();
                            infoUser(friend);
                        }
                        break;
                  case 5: // Reportar Cache
                     
                    out.printf("\nInsira a latitude e a longitude da cache que deseja reportar:");
                    Coordenadas coordenadas = scanCoordenadas();
             
                    out.printf("\nDescreva a razão do seu report numa linha\n"); 
                    String texto = sc.next(); 
                    
                    Report report = (Report) new Report(coordenadas,texto); // Cria um report com as horas do sistema
                   
                    reports.add(report);
                    
                    out.printf("\nReport adicionado com sucesso\n");
                   
                    break;
                  case 6: 
                  
                    break;
                  default:
                        System.out.printf("\nInsira uma opção válida!\n");
                        break;
               }
             
        } while(optn!=6);
        
    }
    
    /**
     *  Pede ao utilizador a latitude e longitude, validanda e devolve o par no final
     */
    public static Coordenadas scanCoordenadas()
    {
                    Scanner sc=new Scanner(System.in); 
                    
                    int i, graus, minutos, segundos;
                    do {
                        i=0;
                        out.printf("Insira os valores referentes à latitude:\n");
                        out.printf("    Graus: "); graus=sc.nextInt();
                        out.printf("    Minutos: "); minutos=sc.nextInt();
                        out.printf("    Segundos: "); segundos=sc.nextInt();
                        if(!validaCoord("latitude", graus, minutos, segundos)) {
                            i=1;
                            out.printf("\nInsira coordenadas válidas!");
                        }
                    } while(i==1);
                    Coordenada latitude=new Coordenada(graus, minutos, segundos);
                    do {
                        i=0;
                        out.printf("Insira os valores referentes à longitude:\n");
                        out.printf("    Graus: "); graus=sc.nextInt();
                        out.printf("    Minutos: "); minutos=sc.nextInt();
                        out.printf("    Segundos: "); segundos=sc.nextInt();
                        if(!validaCoord("longitude", graus, minutos, segundos)) {
                            i=1;
                            out.printf("\nInsira coordenadas válidas!");
                        }
                    } while(i==1);
                    Coordenada longitude=new Coordenada(graus, minutos, segundos);
                    return new Coordenadas(latitude, longitude);
    }
    

    public static void infoUser(Utilizador u) {
        out.printf("\nInformação do Utilizador:\n");
        out.println("   Email: " +u.getEmail());
        out.println("   Password: " +u.getPassword());
        out.println("   Nome: " +u.getNome());
        out.println("   Género: " +u.getGenero());
        out.println("   Morada: " +u.getMorada());
        out.println("   Timeline de Nascimento: " +u.getTimelineNascimento().toString());
        out.println("   Amigos: " +u.getAmigos().toString());
    }
    

    public static boolean validaCoord(String escala, int graus, int minutos, int segundos) {
        if(escala.equals("latitude") && (graus<0 || graus>90)) return false;
        else if(graus<0 || graus>180) return false;
        if(minutos<0 || minutos>59) return false;
        if(segundos<0 || segundos>59) return false;
        return true;
    }
    
    public static void menuAdmin(Utilizador user,Utilizadores utilizadores,Caches caches,CacheReports reports){;}
}
