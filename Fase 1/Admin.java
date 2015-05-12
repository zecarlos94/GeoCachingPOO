import java.util.*;
import static java.lang.System.*;

public class Admin
{
    /**
     * Variáveis de Instância
     */
 private HashMap<String, Utilizador> utilizadores;   //Lista de utilizadores inscritos na aplicação, cuja chave corresponde ao email de cada um
 private HashMap<String, Cache> caches;  //Lista de caches disponíveis, cuja chave corresponde às coordenadas de cada uma
    
 public void main (String[] args) {
    Scanner sc = new Scanner (System.in); 
    Set<String> ks=utilizadores.keySet();
    Iterator<String> it = ks.iterator();
    String elem;
    Utilizador user;
        do{
       out.println("Bem vindo!!!\n");
       out.println("===================\n");
       out.println("Sair->S\nLogin->L\nRegistar->R\n");
       String ecra=sc.next();
       int opção;
       if (ecra.equals("R")) regista();
       else if (ecra.equals("L")) {
            out.print("Introduza o seu email de login: ");
            String email=sc.next();
            out.print("Insira a sua password: ");
            String password=sc.next();
            String copia="N/A";
            String auxiliar="N/A";
            /*procurar nos utilizadores*/
            while(it.hasNext()){
                elem=it.next();
                if(elem.equals(email)) {
                    user=this.utilizadores.get(elem).clone();
                    if(password.equals(user.getPassword())){
                    out.println("Bem Vindo " + user.getNome() + "\nQue operação deseja executar?\n");
                    out.println("Se desejar alterar informações pessoais insira 1\n");
                    out.println("Se desejar criar novo evento insira 2\n");
                    out.println("Se desejar consultar as suas estatisticas insira 3\n");
                    out.println("Se desejar ver um evento actual seu insira 4\n");
                    out.println("Se desejar consultar as suas actividades insira 5\n");
                    out.println("Se desejar consultar os seus amigos insira 6\n");
                    opção=sc.nextInt();
                    if(opção==1){
                        opção=0;
                        out.println("Se desejar alterar o seu email insira 1\n");
                        out.println("Se desejar alterar a sua password insira 2\n");
                        out.println("Se desejar alterar o seu nome insira 3\n");
                        out.println("Se desejar alterar o seu género insira 4\n");
                        out.println("Se desejar alterar a sua morada insira 5\n");
                        out.println("Se desejar alterar a sua data de nascimento insira 6\n");
                        out.println("Se desejar alterar os seus amigos insira 7\n");/*
                        out.println("Se desejar alterar as suas actividades insira 8\n");
                        out.println("Se desejar alterar as suas estatisticas insira 9\n");*/
                        opção=sc.nextInt();
                        if(opção==1){
                            auxiliar="N/A";opção=0;
                            copia="N/A";
                            out.println("Pretende mesmo mudar de Email?Sim->1 e Não->0\n");
                            if(opção==1) {
                                out.println("Insira o novo email.\n"); 
                                auxiliar=sc.next();
                                out.println("Insira novamente o novo email.\n"); 
                                copia=sc.next();
                                if(auxiliar.equals(copia)){
                                    user.setEmail(auxiliar);
                                    copia="N/A";
                                    auxiliar="N/A";
                                    out.println("Email modificado com sucesso.\n"); 
                                }
                            }
                        }
                        else if(opção==2){
                            auxiliar="N/A";opção=0;
                            copia="N/A";
                            out.println("Pretende mesmo mudar de Password?Sim->1 e Não->0\n");
                            if(opção==1) {
                                out.println("Insira a nova password\n"); 
                                auxiliar=sc.next();
                                out.println("Insira novamente a nova password\n"); 
                                copia=sc.next();
                                if(auxiliar.equals(copia)){
                                    user.setPassword(auxiliar);
                                    copia="N/A";
                                    auxiliar="N/A";
                                    out.println("Password modificada com sucesso.\n"); 
                                }
                            }
                        }
                        else if(opção==3){
                            auxiliar="N/A";opção=0;
                            copia="N/A";
                            out.println("Pretende mesmo mudar de Nome?Sim->1 e Não->0\n");
                            if(opção==1) {
                                out.println("Insira o novo nome\n"); 
                                auxiliar=sc.next();
                                out.println("Insira novamente o novo nome\n"); 
                                copia=sc.next();
                                if(auxiliar.equals(copia)){
                                    user.setNome(auxiliar);
                                    copia="N/A";
                                    auxiliar="N/A";
                                    out.println("Nome modificado com sucesso.\n"); 
                                }
                            }
                        }
                        else if(opção==4){
                            auxiliar="N/A";opção=0;
                            copia="N/A";
                            out.println("Pretende mesmo mudar o género?Sim->1 e Não->0\n");
                            if(opção==1) {
                                out.println("Insira o novo género\n"); 
                                auxiliar=sc.next();
                                out.println("Insira novamente o novo género\n"); 
                                copia=sc.next();
                                if(auxiliar.equals(copia)){
                                    user.setGenero((char)auxiliar);
                                    copia="N/A";
                                    auxiliar="N/A";
                                    out.println("Género modificado com sucesso.\n"); 
                                }
                            }
                        }
                        else if(opção==5){
                            auxiliar="N/A";opção=0;
                            copia="N/A";
                            out.println("Pretende mesmo mudar a sua morada?Sim->1 e Não->0\n");
                            if(opção==1) {
                                out.println("Insira o novo género\n"); 
                                auxiliar=sc.next();
                                out.println("Insira novamente a sua morada\n"); 
                                copia=sc.next();
                                if(auxiliar.equals(copia)){
                                    user.setMorada(auxiliar);
                                    copia="N/A";
                                    auxiliar="N/A";
                                    out.println("Morada modificada com sucesso.\n"); 
                                }
                            }
                        }
                        else if(opção==6){
                             auxiliar="N/A";opção=0;
                            copia="N/A";
                            out.println("Pretende mesmo mudar a sua data de nascimento?Sim->1 e Não->0\n");
                            if(opção==1) {
                                out.println("Insira o novo género\n"); 
                                auxiliar=sc.next();
                                out.println("Insira novamente a sua data de nascimento\n"); 
                                copia=sc.next();
                                if(auxiliar.equals(copia)){
                                    user.setDataNascimento(auxiliar);
                                    copia="N/A";
                                    auxiliar="N/A";
                                    out.println("Data de Nascimento modificada com sucesso.\n"); 
                                }
                            }
                        }
                        else if(opção==7){
                            opção=0;
                            out.println("Deseja adicionar amigo ou remover?Adicionar->1 e Remover->0\n"); 
                            if(opção==1){}
                            else if(opção==0){}
                            else { out.println("Opção inválida,tente outra vez por favor se quiser!!!");}
                        }
                        else {out.println("Opção inválida,tente outra vez por favor se quiser!!!");}
                    
                    }
                    else if(opção==2){}
                    else if(opção==3){}
                    else if(opção==4){}
                    else if(opção==5){}
                    else if(opção==6){}
                    else {out.println("Opção inválida,tente outra vez por favor se quiser!!!");}
                    
                    }
                    /*Marcar o timeline de entrada no sistema e depois o de logout e calcular a diferença*/
                    
                    
                }
            }
            
        }
       else if (ecra.equals("S")) {out.println("Adeus e Obrigado!");sc.close();exit(0);}
       else out.println("Erro,opção inválida!!!");
    } while(true);
 }
 
 public static void regista () {
  while(true){
    Scanner sc = new Scanner (System.in);
    sc.useDelimiter("\n");
    Utilizador novo = new Utilizador();
    
    out.print("Insira o seu Nome: ");
    String aux="N/A";
    aux = sc.nextLine();
    novo.setNome(aux);
    aux="N/A";
    
    out.print("Deseja Continuar?Sim->S e Não->N");
    aux=sc.next();
    if (aux.equals("N")) break;
    aux="N/A";
    
    do{
     out.print("Insira o seu Email: ");
     aux=sc.next();
     if(aux.contains("@")) {
         novo.setEmail(aux);
         break;
     }
     out.println("Email invalido");
    }while (!aux.contains("@"));
    
    aux="N/A";
    out.print("Deseja Continuar?Sim->S e Não->N");
    aux=sc.next();
    if (aux.equals("N")) break;
    aux="N/A";
    
    /*
       Console cnsl = System.console();
       if (cnsl != null) {
           char[] pwd = cnsl.readPassword("Password: ");
       }
      else {
          System.out.println("Aviso: não se encontra num terminal! Ao escrever a password, ela sera aqui apresentada!");
          System.out.print("Password: ");
          String pwd = ler.next();
       }

     */
    aux="N/A";
    out.print("Deseja Continuar?Sim->S e Não->N");
    aux=sc.next();
    if (aux.equals("N")) break;
    aux="N/A";
    
    out.print("Sexo Masculino->M ou Feminino->F ");
    aux="N/A";
    aux=sc.next();            
    while (((aux.charAt(0)!='M' && aux.charAt(0)!='m') && (aux.charAt(0)!='F' && aux.charAt(0)!='f')) || aux.length()!=1){
      out.println("Inseriu de forma inválida, tente outra vez!!!");
      out.print("Sexo Masculino->M ou Feminino->F ");
      aux=sc.next();
    }
    novo.setGenero(aux.charAt(0));/*OU novo.setGenero((char)aux);*/
    aux="N/A";
    
    out.print("Deseja Continuar?Sim->S e Não->N");
    aux=sc.next();
    if (aux.equals("N")) break;
    aux="N/A";
    
    out.print("Insira a sua Morada");
    aux=sc.nextLine();                
    novo.setMorada(aux);
    aux="N/A";
    
    out.print("Deseja Continuar?Sim->S e Não->N");
    aux=sc.next();
    if (aux.equals("N")) break;
    aux="N/A";
    
    out.print("Data de nascimento no formato dia-mês-ano");
    aux=sc.next(); 
    boolean valida=false;
    while(!valida){
     if (aux.length()!=12 || aux.charAt(3)!='-' || aux.charAt(5)!='-')
       out.println("Inseriu de forma inválida a sua data de nascimento, tente outra vez!!!");     
     if (aux.length()==10 || aux.charAt(3)=='-' || aux.charAt(5)!='-'){
       String[] tmp;
       tmp = aux.split("-");
       int dia = Integer.parseInt(tmp[0]);
       int mês = Integer.parseInt(tmp[1]);
       int ano = Integer.parseInt(tmp[2]);            
       while ((dia<1 || dia>31) || (mês<1 || mês>12) || (ano<0)){
         out.println("Não foi introduzida uma Data de Nascimento possível, verifique se inseriu os números pela ordem correta!!");
         aux=sc.next();
         tmp = aux.split("-");
         dia = Integer.parseInt(tmp[0]);
         mês = Integer.parseInt(tmp[1]);
         ano = Integer.parseInt(tmp[2]);                    
       }
       novo.setDataNascimento(dia,mês,ano);
       valida=true;
     }
    }
    sc.close();   
    out.println("Concluiu o seu registo.\nObrigado pelo seu registo.\nEsperamos que se divirta muito.\n");
  }
 }
}
