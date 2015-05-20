import java.util.*;
import static java.lang.System.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;


public class testMC extends Cache
{
   private double pontos=0;
   public void main(String args[]) {
        Scanner sc=new Scanner(System.in); 
        int opção=0;
        out.printf("Vamos iniciar a cache mistério.\nPara tal terá de resolver um mistério que poderá ser:\n 1-Sair\n 2-Responder a 3 perguntas\n 3-Resolver um problema lógico\n\n");        
        do {
            out.printf("\nInsira uma opção:\n\n");
            opção=sc.nextInt();
            if(opção==1) {
                out.printf("\nTem a certeza que deseja sair?\n   1-Sim\n   2-Não\n\n");
                opção=sc.nextInt();
            }
            else if(opção==2) perguntas();
            else out.printf("Introduza uma opção válida!\n\n");
        } while(opção!=1);
        out.printf("\nConcluiu a cache mistério, Parabéns!!!\n");
    }  
    
   public void perguntas(){
        Scanner sc=new Scanner(System.in); 
        int opção=0;
        int sair=0;
        String resposta="N/A";
        String aux="N/A";
        int certas=0;
        int tentativa=0;
        boolean sucesso=false;
        out.printf("Vamos iniciar as perguntas\n Terá de responder correctamente a 3 perguntas para concluir o mistério.\n\n");   
        while(certas!=3){
            Random rn = new Random();
            opção = rn.nextInt(2) + 1;
            if(opção==1){
                out.printf("Se desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1){
                    out.printf("Saiu do mistério, logo não resolveu com sucesso.");
                    break;
                }
                out.printf("Vamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                for(tentativa=0;tentativa<3;tentativa++){
                   out.printf("Como se chama o pai das ciências de computação?\n");
                   sucesso=false;
                   aux="N/A";
                   aux=sc.next();
                   resposta="Alan Turing";
                   if(resposta.equals(aux)){
                       certas++;
                       sucesso=true;
                       opção = rn.nextInt(2) + 1;
                       if(tentativa==0)pontos+=5;
                       if(tentativa==1)pontos+=3;
                       else if(tentativa==2)pontos+=1;
                       else pontos+=0;
                       break;
                   } 
                }
                if(sucesso==false)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }else if(opção==2){
                out.printf("Se desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1){
                    out.printf("Saiu do mistério, logo não resolveu com sucesso.");
                    break;
                }
                out.printf("Vamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                for(tentativa=0;tentativa<3;tentativa++){
                   out.printf("Que cor eram as bandeiras dos piratas?\n");
                   sucesso=false;
                   aux="N/A";
                   aux=sc.next();
                   resposta="Pretas";
                   if(resposta.equals(aux)){
                       certas++;
                       sucesso=true;
                       opção = rn.nextInt(2) + 1;
                       if(tentativa==0)pontos+=5;
                       if(tentativa==1)pontos+=3;
                       else if(tentativa==2)pontos+=1;
                       else pontos+=0;
                       break;
                   } 
                }
                if(sucesso==false)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }else{
                out.printf("Se desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1){
                    out.printf("Saiu do mistério, logo não resolveu com sucesso.");
                    break;
                }
                out.printf("Vamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                for(tentativa=0;tentativa<3;tentativa++){
                   out.printf("Quem pintou a Mona Lisa?\n");
                   sucesso=false;
                   aux="N/A";
                   aux=sc.next();
                   resposta="Leonardo da Vinci";
                   if(resposta.equals(aux)){
                       certas++;
                       sucesso=true;
                       opção = rn.nextInt(2) + 1;
                       if(tentativa==0)pontos+=5;
                       if(tentativa==1)pontos+=3;
                       else if(tentativa==2)pontos+=1;
                       else pontos+=0;
                       break;
                   } 
                }
                if(sucesso==false)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
        }
        if(certas==3) out.printf("Parabéns concluiu as 3 perguntas com sucesso e com " + pontos + " pontos.\n");
    }
}

