import java.util.*;
import static java.lang.System.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class Administrador
{
    //private HashMap<String, Cache> caches;
    
    public static void main(String args[]) {
        HashMap<String, Utilizador> utilizadores=new HashMap<String, Utilizador>();
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
            else if(opção==2) login(utilizadores);
            else if(opção==3) signin(utilizadores);
            else out.printf("Introduza uma opção válida!\n\n");
        } while(opção!=1);
        out.printf("\nSaiu da aplicação! Adeus!\n");
    }
    
    /**
     * Acede à conta do utilizador
     */
    public static void login(HashMap<String, Utilizador> utilizadores) {
        Scanner sc=new Scanner(System.in); 
        Utilizador u;
        String dados;
        int cicle=0, i=0;
        out.printf("\nInsira o seu email: ");
        dados=sc.next();
        if(utilizadores.containsKey(dados)) {
            u=utilizadores.get(dados);
            do {
                out.printf("Introduza a password: ");
                dados=sc.next();
                if(u.getPassword().equals(dados)) user(u, utilizadores);
                else {
                    out.printf("\nPassword Incorreta!\n");
                    cicle=1; i++;
                }
            } while(cicle==1 && i<3);
            if(i==3) out.printf("\n\nEsgotou o limite de tentativas!\n\n");
        }
        else out.printf("\nNão existe nenhum utilizador com o email dado!\n");
    }
    
    /**
     * Cria um novo utilizador
     */
    public static void signin(HashMap<String, Utilizador> utilizadores) {
        Scanner sc=new Scanner(System.in); 
        String dados;
        int cicle, dia, mes, ano;
        Utilizador u=new Utilizador();
        do {
            out.printf("\nInsira o email: "); 
            dados=sc.next();
            if(utilizadores.containsKey(dados)) {
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
            out.printf("Insira a data de nascimento:\n");
            out.printf("   Dia: "); dia=sc.nextInt();
            out.printf("   Mês: "); mes=sc.nextInt();
            out.printf("   Ano: "); ano=sc.nextInt();
            if(!validate(dia, mes, ano)) cicle=1;
            else cicle=0;
        } while(cicle==1);
        Data dataNasc=new Data(dia, mes, ano);
        u.setDataNascimento(dataNasc);
        utilizadores.put(u.getEmail(), u.clone());
        out.printf("\nConta criada com sucesso!\n");
    }
    
     /**
     * Valida uma data
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
     * Mexer na conta do utilizador
     */
    public static void user(Utilizador u, HashMap<String, Utilizador> utilizadores) {
        Scanner sc=new Scanner(System.in); 
        int optn;
        String email;
        do {
            out.printf("\nOpções de Conta:\n   1-Informações\n   2-Adicionar Amigo\n   3-Remover Amigo\n   4-Informação dos amigos\n   5-Sair\n");
            optn=sc.nextInt();
            if(optn==1) infoUser(u);
            else if(optn==2) {
                out.printf("\nInsira o email do amigo que deseja adicionar: "); email=sc.next();
                if(u.getAmigos().containsKey(email)) out.printf("\nVocê já adicionou este amigo!\n");
                else if(u.getEmail().equals(email)) out.printf("\nVocê não se pode adicionar como amigo!\n");
                else if(utilizadores.containsKey(email)) {
                    Utilizador friend=utilizadores.get(email).clone();
                    u.getAmigos().put(email, friend);
                    friend.getAmigos().put(u.getEmail(), u.clone());
                    out.printf("\nAmigo adicionado com sucesso!\n");
                }
                else out.printf("\nNão existe nenhum utilizador registado com esse email!\n");
            }
            else if(optn==3) {
                out.printf("\nInsira o email do amigo que deseja remover: "); email=sc.next();
                if(!u.getAmigos().containsKey(email)) out.printf("\nNão existe nenhum amigo com este email, por isso não é possível remover!\n");
                else {
                    Utilizador friend=utilizadores.get(email).clone();
                    u.getAmigos().remove(email);
                    friend.getAmigos().remove(u.getEmail());
                    out.printf("\nAmigo removido!\n");
                }
            }
            else if(optn==4) {
                out.printf("\nInsira o email do amigo cuja informação deseja ver: "); email=sc.next();
                if(!u.getAmigos().containsKey(email)) out.printf("\nNão existe nenhum amigo com este email!\n");
                else {
                    Utilizador friend=utilizadores.get(email).clone();
                    infoUser(friend);
                }
            }
            else if(optn>5 || optn<1) System.out.printf("\nInsira uma opção válida!\n");
        } while(optn!=5);
    }
    
    public static void infoUser(Utilizador u) {
        out.printf("\nInformação do Utilizador:\n");
        out.println("   Email: " +u.getEmail());
        out.println("   Password: " +u.getPassword());
        out.println("   Nome: " +u.getNome());
        out.println("   Género: " +u.getGenero());
        out.println("   Morada: " +u.getMorada());
        out.println("   Data de Nascimento: " +u.getDataNascimento().toString());
        out.println("   Amigos: " +u.getAmigos().toString());
    }
}
