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
    
   }
    
   public void problema(){
    
   } 
}

