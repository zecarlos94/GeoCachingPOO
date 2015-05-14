import java.util.*;
import java.lang.System;
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
        File file=new File("/home/tiago/Desktop/data.txt");
        HashMap<String, Utilizador> utilizadores=new HashMap<String, Utilizador>();
        insertData(utilizadores, file);
        Scanner sc=new Scanner(System.in); 
        int opção=0;
        System.out.printf("Bem-vindo à aplicação de GeoCaching!\n");
        do {
            System.out.printf("\nInsira uma opção:\n   1-Sair\n   2-Aceder à conta\n   3-Criar nova conta\n\n");
            opção=sc.nextInt();
            if(opção==1) {
                System.out.printf("\nTem a certeza que deseja sair?\n   1-Sim\n   2-Não\n\n");
                opção=sc.nextInt();
            }
            else if(opção==2) login(utilizadores);
            else if(opção==3) signin(utilizadores);
            else System.out.printf("Introduza uma opção válida!\n\n");
        } while(opção!=1);
        System.out.printf("\nVoçê saiu da aplicação! Adeus!\n");
        file.delete(); // se não eliminar ficheiro antes de gravar os dados, estes vão ficar guardados por cima
        saveData(utilizadores, file);
    }
    
    /**
     * Insere dados de um ficheiro de texto na lista de utilizadores
     */
    public static void insertData(HashMap<String, Utilizador> utilizadores, File file) {
        BufferedReader br=null;
        HashMap<String, Utilizador> friendList=new HashMap<String, Utilizador>();
        Data newData=new Data();
        try {
            String line;
            br=new BufferedReader(new FileReader(file));
            while((line=br.readLine())!=null) {
                Utilizador u=new Utilizador();
                StringTokenizer st=new StringTokenizer(line, " ");
                while(st.hasMoreElements()) {
                    String email=st.nextElement().toString(); u.setEmail(email);
                    String password=st.nextElement().toString(); u.setPassword(password); 
                    String nome=st.nextElement().toString(); u.setNome(nome);
                    String genero=st.nextElement().toString(); u.setGenero(genero.charAt(0));
                    String morada=st.nextElement().toString(); u.setMorada(morada); 
                    String data=st.nextElement().toString(); createData(data, newData); u.setDataNascimento(newData); 
                    if(st.hasMoreElements()) {
                        String amigos=st.nextElement().toString(); createFriendList(u, amigos, utilizadores, friendList); u.setAmigos(friendList);
                    }
                }
                utilizadores.put(u.getEmail(), u.clone());
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br!=null) br.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Acede à conta do utilizador
     */
    public static void login(HashMap<String, Utilizador> utilizadores) {
        Scanner sc=new Scanner(System.in); 
        Utilizador u;
        String dados;
        int cicle=0, i=0;
        System.out.printf("\nInsira o seu email: ");
        dados=sc.next();
        if(utilizadores.containsKey(dados)) {
            u=utilizadores.get(dados);
            do {
                System.out.printf("Introduza a password: ");
                dados=sc.next();
                if(u.getPassword().equals(dados)) user(u, utilizadores);
                else {
                    System.out.printf("\nPassword Incorreta!\n");
                    cicle=1; i++;
                }
            } while(cicle==1 && i<3);
            if(i==3) System.out.printf("\n\nEsgotou o limite de tentativas!\n\n");
        }
        else System.out.printf("\nNão existe nenhum utilizador com o email dado!\n");
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
            System.out.printf("\nInsira o email: "); 
            dados=sc.next();
            if(utilizadores.containsKey(dados)) {
                System.out.printf("O email já existe!");
                cicle=1;
            }
            else cicle=0;
        } while(cicle==1);
        u.setEmail(dados);
        System.out.printf("Insira a password: "); 
        dados=sc.next(); u.setPassword(dados);
        System.out.printf("Insira o nome: "); 
        dados=sc.next(); u.setNome(dados);
        System.out.printf("Insira o género: ");
        dados=sc.next(); u.setGenero(dados.charAt(0));
        System.out.printf("Insira a morada: "); 
        dados=sc.next(); u.setMorada(dados);
        do {
            System.out.printf("Insira a data de nascimento:\n");
            System.out.printf("   Dia: "); dia=sc.nextInt();
            System.out.printf("   Mês: "); mes=sc.nextInt();
            System.out.printf("   Ano: "); ano=sc.nextInt();
            if(!validate(dia, mes, ano)) cicle=1;
            else cicle=0;
        } while(cicle==1);
        Data dataNasc=new Data(dia, mes, ano);
        u.setDataNascimento(dataNasc);
        utilizadores.put(u.getEmail(), u.clone());
        System.out.printf("\nConta criada com sucesso!\n");
    }
    
    /**
     * Insere os dados da lista de utilizadores num ficheiro de texto
     */
    public static void saveData(HashMap<String, Utilizador> utilizadores, File file) {
        try {
             FileWriter writer=new FileWriter(file, true);
             BufferedWriter bw=new BufferedWriter(writer);
             Collection<Utilizador> col=utilizadores.values();
             Iterator<Utilizador> it=col.iterator();
             while(it.hasNext()) {
                 Utilizador u=it.next();
                 bw.write(u.toString());
                 if(it.hasNext()) bw.newLine();
             }
             bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
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
     * Pega numa string referenta a uma data e cria um novo objeto da classe Data com esses dados
     */
    public static void createData(String data, Data newData) {
        StringTokenizer st=new StringTokenizer(data, "/");
        while(st.hasMoreElements()) {
            Integer dia=Integer.parseInt(st.nextElement().toString()); newData.setDay(dia);
            Integer mes=Integer.parseInt(st.nextElement().toString()); newData.setMonth(mes);
            Integer ano=Integer.parseInt(st.nextElement().toString()); newData.setYear(ano);
        }
    }
    
    /**
     * Mexer na conta do utilizador
     */
    public static void user(Utilizador u, HashMap<String, Utilizador> utilizadores) {
        Scanner sc=new Scanner(System.in); 
        int optn;
        String email;
        do {
            System.out.printf("\nOpções de Conta:\n   1-Informações\n   2-Adicionar Amigo\n   3-Sair\n");
            optn=sc.nextInt();
            if(optn==1) {
                System.out.printf("\nInformação do Utilizador:\n");
                System.out.println("   Email: " +u.getEmail());
                System.out.println("   Password: " +u.getPassword());
                System.out.println("   Nome: " +u.getNome());
                System.out.println("   Género: " +u.getGenero());
                System.out.println("   Morada: " +u.getMorada());
                System.out.println("   Data de Nascimento: " +u.getDataNascimento().toString());
                System.out.println("   Emails dos amigos: " +u.printAmigos());
            }
            else if(optn==2) {
                System.out.printf("\nInsira o email do seu amigo: "); email=sc.next();
                if(u.getAmigos().containsKey(email)) System.out.printf("\nVoçê já adicionou este amigo!\n");
                else if(utilizadores.containsKey(email)) {
                    Utilizador friend=utilizadores.get(email).clone();
                    u.getAmigos().put(email, friend);
                    friend.getAmigos().put(u.getEmail(), u.clone());
                    System.out.printf("\nAmigo adicionado com sucesso!\n");
                }
                else System.out.printf("\nNão existe nenhum utilizador registado com esse email!\n");
            }
            else if(optn!=1 && optn!=2 && optn!=3) System.out.printf("\nInsira uma opção válida!\n");
        } while(optn!=3);
    }
    
    /**
     * Pega na string com os emails dos amigos, procura os respetivos utilizadores e coloca-os na HashMap dos amigos
     */
    public static void createFriendList(Utilizador u, String amigos, HashMap<String, Utilizador> utilizadores, HashMap<String, Utilizador> friendList) {
        StringTokenizer st=new StringTokenizer(amigos, ",");
        Utilizador friend=new Utilizador();
        while(st.hasMoreElements()) {
            String amigo=st.nextElement().toString();
            if(utilizadores.containsKey(amigo)) {
                friend=utilizadores.get(amigo).clone(); 
                friendList.put(amigo, friend);
                friend.getAmigos().put(u.getEmail(), u.clone());
            }
        }
    }
}
