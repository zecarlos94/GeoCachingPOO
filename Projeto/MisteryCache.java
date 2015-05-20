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
            else if(opção==3) problema();
            else out.printf("Introduza uma opção válida!\n\n");
        } while(opção!=1);
        out.printf("\nConcluiu a cache mistério, Parabéns!!!\n");
    }  
    
   public void perguntas(){
        Scanner sc=new Scanner(System.in); 
        int opção=0;
        int sair;
        String resposta="N/A";
        String aux="N/A";
        int certas=0;
        int tentativa;
        out.printf("Vamos iniciar as perguntas\n Terá de responder correctamente a 3 perguntas para concluir o mistério.\n\n");        
        do {
            Random rn = new Random();
            opção = rn.nextInt(20) + 1;//Vai ter 15 perguntas diferentes
            if(opção==1) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Como se chama o pai das ciências de computação?\n");
                   aux=sc.next();
                   resposta="Alan Turing";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==2) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1){out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Quem inventou a lâmpada elétrica incandescente?\n");
                   aux=sc.next();
                   resposta="Thomas Edison";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==3) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Quem formulou a famosa Teoria da Relatividade?\n");
                   aux=sc.next();
                   resposta="Albert Einstein";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==4) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Quem inventou o primeiro automovel movimentado por um motor de combustão interna?\n");
                   aux=sc.next();
                   resposta="Karl Benz";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==5) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Quem inventou a penincilina?\n");
                   aux=sc.next();
                   resposta="Alexander Fleming";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==6) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Qual o planeta principal do sistema solar que foi despromovido em 24 de agosto de 2006?\n");
                   aux=sc.next();
                   resposta="Plutão";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==7) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Qual o valor aconselhado do pH do sangue humano?\n");
                   aux=sc.next();
                   resposta="7.4";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==8) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("A cerveja Duff aparece em que desenhos animados?\n");
                   aux=sc.next();
                   resposta="Simpsons";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==9) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Qual é o nome da primeira linguagem de programação?\n");
                   aux=sc.next();
                   resposta="Assembly";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==10) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Qual o nome da primeira nave espacial da NASA?\n");
                   aux=sc.next();
                   resposta="Columbia";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==11) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Quem pintou o famoso quadro da Mona Lisa?\n");
                   aux=sc.next();
                   resposta="Leonardo da Vinci";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==12) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Que nome se dá a técnica Japonesa de dobrar papel?\n");
                   aux=sc.next();
                   resposta="Origami";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==13) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Em que ano começaram os Descobrimentos, efectuados por Portugal?\n");
                   aux=sc.next();
                   resposta="1415";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==14) {
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Quem disse a famosa frase em latim 'Alea Jacta Est',isto é, 'O dado está lançado'?\n");
                   aux=sc.next();
                   resposta="Júlio César";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==15){
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Por qual elemento principal está constituída a maioria dos seres vivos?\n");
                   aux=sc.next();
                   resposta="Carbono";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==16){
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Pessoas diabéticas tem a falta de...?\n");
                   aux=sc.next();
                   resposta="Insulina";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==17){
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Qual é o planeta considerado planeta dos anéis?\n");
                   aux=sc.next();
                   resposta="Saturno";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==18){
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Onde fica o México?\n");
                   aux=sc.next();
                   resposta="América Central";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else if(opção==19){
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("Em que ano acabou a Ditadura Militar no Brasil?\n");
                   aux=sc.next();
                   resposta="1985";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
            else{
                out.printf("\nSe desejar sair sem acabar\n 1-Sim 2-Não\n\n");
                sair=sc.nextInt();
                if(sair==1) {out.printf("Saiu do mistério, logo não resolveu com sucesso.");break;}
                out.printf("\nVamos então fazer a pergunta a que tem de responder e só tem 3 tentativas para acertar á pergunta\n");
                out.printf("Para cada resposta certa obtem 5 pontos\n\n");
                tentativa=3;
                while(tentativa!=0){
                   out.printf("De que cor eram as bandeiras dos piratas?\n");
                   aux=sc.next();
                   resposta="Pretas";
                   if(resposta.equals(aux)){
                       certas++;
                       opção = rn.nextInt(20) + 1;
                       if(tentativa==3)pontos+=5;
                       if(tentativa==2)pontos+=3;
                       else pontos+=1;
                       break;
                    }
                   else tentativa--;
                }
                if(tentativa==0)out.printf("Terminaram as suas tentativas, perdeu a caixa mistério e não ganhou pontos nenhuns.\n Tente mais tarde\n\n");
            }
        } while(certas!=3);
        if(certas==3) out.printf("Parabéns concluiu as 3 perguntas com sucesso e com " + pontos + " pontos.\n");
   }
    
   public void problema(){
    
   } 
}

