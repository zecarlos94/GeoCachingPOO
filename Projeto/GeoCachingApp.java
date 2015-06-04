import java.util.*;
import static java.lang.System.*;
import java.io.*;
public class GeoCachingApp {
    
    // Construtor privado
    private GeoCachingApp() {}

    // instance variables 

    private static GeoCaching geo;
    private static Menu menuinicial, menuadmin, menuser;

    // M?todo principal
    public static void main(String[] args) {
        
        
        carregarMenus();
        carregarDados();

        GeoCaching c=new GeoCaching();
        Utilizador user=null;

        do {
            menuinicial.executa();
            switch (menuinicial.getOpcao()) {
                case 1: user = login(c.getUtilizadores(), c.getAdmins());
                        break;
                case 2: user = signin(c.getUtilizadores());
                        break;
            }

            if(user.isAdmin(c.getAdmins())){
                    do {
                            Utilizador u = user;
                            Utilizadores utilizadores =  c.getUtilizadores();
                            Caches caches = c.getCaches();
                            CacheReports reports = c.getReports();
                            String email;
                            Scanner sc=new Scanner(System.in); 
                            menuadmin.executa();
                            switch (menuadmin.getOpcao()) {
                            case 1: infoUser(u);
                                    break;
                            case 2: out.printf("\nInsira o email do amigo que deseja adicionar: "); email=sc.next();
                                    if(u.getAmigos().contains(email)) out.printf("\nVocê já adicionou este amigo!\n");
                                    else if(u.getEmail().equals(email)) out.printf("\nVocê não se pode adicionar como amigo!\n");
                                    else if(utilizadores.existe(email)) {
                                        utilizadores.addAmizade(u.getEmail(),email);
                                        out.printf("\nAmigo adicionado com sucesso!\n");
                                    }
                                    else out.printf("\nNão existe nenhum utilizador registado com esse email!\n");
                                    break;
                            case 3: out.printf("\nInsira o email do amigo que deseja remover: "); email=sc.next();
                                    if(!u.getAmigos().contains(email)) out.printf("\nNão existe nenhum amigo com este email, por isso não é possível remover!\n");
                                    else {
                                        utilizadores.removeAmizade(u.getEmail(),email);
                                        out.printf("\nAmigo removido!\n");
                                    }
                                    break;
                            case 4: out.printf("\nInsira o email do amigo cuja informação deseja ver: "); email=sc.next();
                                    if(!u.getAmigos().contains(email)) out.printf("\nNão existe nenhum amigo com este email!\n");
                                    else {
                                        Utilizador friend=utilizadores.get(email).clone();
                                        infoUser(friend);
                                    }
                                    break;
                            case 5: out.printf("\nInsira a latitude e a longitude da cache que deseja reportar:");
                                    Coordenadas coordenadas=scanCoordenadas();
                                    out.printf("\nDescreva a razão do seu report numa linha\n"); 
                                    String texto=sc.next(); 
                                    Report report=(Report) new Report(coordenadas, texto);      // Cria um report com as horas do sistema
                                    reports.add(report);
                                    out.printf("\nReport adicionado com sucesso\n");
                                    break;
                            case 6: Cache ce;
                                    ce=criaCache();
                                    caches.add(ce);
                                    break;
                            case 7: u.getMyCaches().toString();
                                    break;
                            case 8: out.printf("\nInsira a latitude e a longitude da cache que deseja remover:");
                                    Coordenadas coord=scanCoordenadas();
                                    caches.getCaches().remove(coord);
                                    break;   
                            case 9: reports.getReports().toString();
                                    break;
                            case 10: 
                                    break; 
                            default:
                                    System.out.printf("\nInsira uma opção válida!\n");    

                            }
                        } while (menuadmin.getOpcao()!=0);
            }
            else{
                    do {
                            Scanner sc=new Scanner(System.in); 
                            Utilizador u = user;
                            Utilizadores utilizadores =  c.getUtilizadores();
                            Caches systemCaches = c.getCaches();
                            CacheReports reports = c.getReports();
                            String email;
                            menuser.executa();
                            switch (menuser.getOpcao()) {
                            case 1: infoUser(u);
                                    break;
                            case 2: out.printf("\nInsira o email do amigo que deseja adicionar: "); email=sc.next();
                                    if(u.getAmigos().contains(email)) out.printf("\nVocê já adicionou este amigo!\n");
                                    else if(u.getEmail().equals(email)) out.printf("\nVocê não se pode adicionar como amigo!\n");
                                    else if(utilizadores.existe(email)) {
                                        utilizadores.addAmizade(u.getEmail(),email);
                                        out.printf("\nAmigo adicionado com sucesso!\n");
                                    }
                                    else out.printf("\nNão existe nenhum utilizador registado com esse email!\n");
                                    break;
                            case 3: out.printf("\nInsira o email do amigo que deseja remover: "); email=sc.next();
                                    if(!u.getAmigos().contains(email)) out.printf("\nNão existe nenhum amigo com este email, por isso não é possível remover!\n");
                                    else {
                                        utilizadores.removeAmizade(u.getEmail(),email);
                                        out.printf("\nAmigo removido!\n");
                                    } 
                                    break;
                            case 4: out.printf("\nInsira o email do amigo cuja informação deseja ver: "); email=sc.next();
                                    if(!u.getAmigos().contains(email)) out.printf("\nNão existe nenhum amigo com este email!\n");
                                    else {
                                        Utilizador friend=utilizadores.get(email).clone();
                                        infoUser(friend);
                                    }
                                    break;
                            case 5: out.printf("\nInsira a latitude e a longitude da cache que deseja reportar:");
                                    Coordenadas coordenadas=scanCoordenadas();
                                    out.printf("\nDescreva a razão do seu report numa linha\n"); 
                                    String texto=sc.next(); 
                                    Report report=(Report) new Report(coordenadas, texto);      // Cria um report com as horas do sistema
                                    reports.add(report);
                                    out.printf("\nReport adicionado com sucesso\n");
                                    break;
                            case 6: Cache ce;
                                    ce=criaCache();
                                    systemCaches.add(ce);
                                    break;
                            case 7: u.getMyCaches().toString();
                                    break;
                            case 8: out.printf("\nInsira as coordenadas da  cache que deseja remover:");
                                    Coordenadas cds=scanCoordenadas();
                                    systemCaches.remove(cds);
                                    out.printf("\nCache removida com sucesso\n");
                                    break;     
                            default:
                                     System.out.printf("\nInsira uma opção válida!\n");
                            }
                        } while (menuser.getOpcao()!=0);
            }

        } while (menuinicial.getOpcao()!=0);
        try {
            gravaObj(geo,"estado.geoemp");
        }
        catch (IOException e) {
            System.out.println("Não consegui gravar os dados!");
        }
        System.out.println("Até breve!...");
      
 
    }

    
    // M?todos auxiliares
    
    private static void carregarMenus() {
        String[] ops = {"Aceder à conta","Criar nova conta"};
        String [] opsadmin = {"Informações",
                           "Adicionar Amigo","Remover Amigo",
                           "Informação dos Amigos","Reportar Cache",
                           "Adicionar Cache","Ver as minhas caches",
                           "Remover uma das caches","Ver Reports","Criar Evento"};
        String [] opsauser = {"Informações",
                           "Adicionar Amigo",
                           "Remover Amigo","Informação dos Amigos",
                           "Reportar Cache","Adicionar Conta",
                           "Ver as minhas Caches","Remover uma das minhas Caches"};       

        menuinicial = new Menu(ops);
        menuadmin = new Menu(opsadmin);
        menuser = new Menu(opsauser);
    }
    
    
    private static void carregarDados() {
        try {
            geo = leObj("estado.geoemp");
        }
        catch (IOException e) {
            geo = new GeoCaching();
            System.out.println("Não consegui ler os dados!\nErro de leitura.");
        } 
        catch (ClassNotFoundException e) {
            geo = new GeoCaching();
            System.out.println("Não consegui ler os dados!\nErro de formato.");
        }
        catch (ClassCastException e) {
            geo = new GeoCaching();
            System.out.println("Não consegui ler os dados!\nErro de formato.");        }
    }
    

    /**
     * Acede à conta do utilizador, devolvendo a mesma
     */
    public static Utilizador login(Utilizadores utilizadores, ArrayList<String> admins) {
        Scanner sc=new Scanner(System.in); 
        Utilizador u = null;
        String dados;
        int cicle=0, i=0;
        out.printf("\nInsira o seu email: ");
        dados=sc.next();
        boolean isAdmin = false;
        for(String adminName : admins) if(adminName.equals(dados)) isAdmin=true;         // Temporario estas verificaçoes de admins visto que n temos estados guardados
        if(utilizadores.existe(dados) && !isAdmin) {
            u=utilizadores.get(dados);
            do {
                out.printf("Introduza a password: ");
                dados=sc.next();
                if(u.getPassword().equals(dados)) break;        // login bem sucedido return u;
                else {
                    out.printf("\nPassword Incorreta!\n");
                    cicle=1; i++;
                }
            } while(cicle==1 && i<3);
            if(i==3) {
                u=null ;      // Acesso negado uma vez que falhou as tentativas todas, de volta ao menu principal
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
    
    public static void gravaObj(GeoCaching e,String filename) throws IOException{
    FileOutputStream fos = new FileOutputStream(filename);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(e);/*empresaPOO*/
    oos.close();
   }
 
   public static GeoCaching leObj(String filename) throws IOException, ClassNotFoundException {
    ObjectInputStream ois = new ObjectInputStream (new FileInputStream(filename));
    GeoCaching e = (GeoCaching) ois.readObject();
    ois.close();
    return e;
   }
}


