import java.util.*;
import static java.lang.System.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;


public class MisteryCache extends Cache
{
   private int pontos=0;
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
            else if(opção==2) geraPergunta();
            else if(opção==3) problema();
            else out.printf("Introduza uma opção válida!\n\n");
        } while(opção!=1);
        out.printf("\nConcluiu a cache mistério, Parabéns!!!\n");
   }  
   
   public void geraPergunta() {
       Scanner sc=new Scanner(System.in); 
       int opção=0;
       int sair;
       String resposta="N/A";
       String aux="N/A";
       int certas=0;
       out.printf("Vamos iniciar as perguntas\n Terá de responder correctamente a 3 perguntas para concluir o mistério.\n\n");
       do {
           Random rn=new Random();
           opção=rn.nextInt(19) + 1;//Vai ter 15 perguntas diferentes
           out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
           out.printf("Para cada resposta certa obtem 5 pontos\n\n");
           perguntas(opção); aux=sc.next();
           resposta=respostas(opção);
           if(aux.equals(resposta)==true) {
               certas++; pontos+=5;
               if(certas<3) {
                   out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                   sair=sc.nextInt();
                   if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso."); break;}
               }
           }
           else {
               out.printf("Resposta Errada! Já foste! Tente mais tarde!\n\n");
               break;
           }
       } while(certas<3);
       if(certas==3) out.printf("\nConclui com sucesso! Pontuação=%d\n", pontos);
       pontos=0;
   }
   
   public void perguntas(int opção) {
       if(opção==1)  out.printf("Como se chama o pai das ciências de computação?\n");
       else if(opção==2) out.printf("Quem inventou a lâmpada elétrica incandescente?\n");
       else if(opção==3) out.printf("Quem formulou a famosa Teoria da Relatividade?\n");
       else if(opção==4) out.printf("Quem inventou o primeiro automovel movimentado por um motor de combustão interna?\n");
       else if(opção==5) out.printf("Quem inventou a penincilina?\n");
       else if(opção==6) out.printf("Qual o planeta principal do sistema solar que foi despromovido em 24 de agosto de 2006?\n");
       else if(opção==7) out.printf("Qual o valor aconselhado do pH do sangue humano?\n");
       else if(opção==8) out.printf("A cerveja Duff aparece em que desenhos animados?\n");
       else if(opção==9) out.printf("Qual é o nome da primeira linguagem de programação?\n");
       else if(opção==10) out.printf("Qual o nome da primeira nave espacial da NASA?\n");
       else if(opção==11) out.printf("Quem pintou o famoso quadro da Mona Lisa?\n");
       else if(opção==12) out.printf("Que nome se dá a técnica Japonesa de dobrar papel?\n");
       else if(opção==13) out.printf("Em que ano começaram os Descobrimentos, efectuados por Portugal?\n");
       else if(opção==14) out.printf("Quem disse a famosa frase em latim 'Alea Jacta Est',isto é, 'O dado está lançado'?\n");
       else if(opção==15) out.printf("Por qual elemento principal está constituída a maioria dos seres vivos?\n");
       else if(opção==16) out.printf("Pessoas diabéticas tem a falta de...?\n");
       else if(opção==17) out.printf("Qual é o planeta considerado planeta dos anéis?\n");
       else if(opção==18) out.printf("Onde fica o México?\n");
       else if(opção==19) out.printf("Em que ano acabou a Ditadura Militar no Brasil?\n");
       else out.printf("De que cor eram as bandeiras dos piratas?\n");
   }
   
   public String respostas(int pergunta){
        if(pergunta==1) return "Alan_Turing";
        else if(pergunta==2) return "Thomas_Edison";
        else if(pergunta==3) return "Albert_Einstein";
        else if(pergunta==4) return "Karl_Benz";
        else if(pergunta==5) return "Alexander_Fleming";
        else if(pergunta==6) return "Plutao";
        else if(pergunta==7) return "7.4";
        else if(pergunta==8) return "Simpsons";
        else if(pergunta==9) return "Assembly";
        else if(pergunta==10) return "Columbia";
        else if(pergunta==11) return "Leonardo_da_Vinci";
        else if(pergunta==12) return "Origami";
        else if(pergunta==13) return "1415";
        else if(pergunta==14) return "Julio_Cesar";
        else if(pergunta==15) return "Carbono";
        else if(pergunta==16) return "Insulina";
        else if(pergunta==17) return "Saturno";
        else if(pergunta==18) return "America_Central";
        else if(pergunta==19) return "1985";
        else return "Pretas";
   }
    
   public void problema() {
    
   } 
}

