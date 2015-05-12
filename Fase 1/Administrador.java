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
                    //char genero=char.parseChar(st.nextElement().toString()); u.setGenero(genero);
                    String morada=st.nextElement().toString(); u.setMorada(morada);
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
        System.out.printf("Insira o seu email: ");
        dados=sc.next();
        if(utilizadores.containsKey(dados)) {
            u=utilizadores.get(dados);
            do {
                System.out.printf("\nIntroduza a password: ");
                dados=sc.next();
                if(u.getPassword().equals(dados)) {
                    System.out.printf("\n\nInformação do Utilizador:\n");
                    System.out.println("   Email: " +u.getEmail());
                    System.out.println("   Password: " +u.getPassword());
                    System.out.println("   Nome: " +u.getNome());
                    System.out.println("   Género: " +u.getGenero());
                    System.out.println("   Morada: " +u.getMorada());
                    System.out.println("   Data de Nascimento: " +u.getDataNascimento().toString());
                }
                else {
                    System.out.printf("\n\nPassword Incorreta!");
                    cicle=1; i++;
                }
            } while(cicle==1 && i<3);
            if(i==3) System.out.printf("\n\nEsgotou o limite de tentativas!\n\n");
        }
        else System.out.printf("\n\nNão existe nenhum utilizador com o email dado!");
    }
    
    /**
     * Cria um novo utilizador
     */
    public static void signin(HashMap<String, Utilizador> utilizadores) {
        Scanner sc=new Scanner(System.in); 
        String dados;
        Utilizador u=new Utilizador();
        System.out.printf("\n\nInsira o email: "); 
        dados=sc.next(); u.setEmail(dados);
        System.out.printf("Insira a password: "); 
        dados=sc.next(); u.setPassword(dados);
        System.out.printf("Insira o nome: "); 
        dados=sc.next(); u.setNome(dados);
        System.out.printf("Insira a morada: "); 
        dados=sc.next(); u.setMorada(dados);
        utilizadores.put(u.getEmail(), u.clone());
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
                 bw.write(u.getEmail()+ " " +u.getPassword()+ " " +u.getNome()+ " " +u.getMorada());
                 if(it.hasNext()) bw.newLine();
             }
             bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
