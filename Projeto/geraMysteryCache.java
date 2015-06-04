import java.util.*;
/**
 * Escreva a descrição da classe geraCaches aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class geraMysteryCache
{
 public static ArrayList<ArrayList<String>> geraMysteryCache() {
   Random rn = new Random();
   int quantos=0,l,j=0;
   String s="N/A";
   int optn=rn.nextInt(20);
   quantos=rn.nextInt(20);
    ArrayList<String> par;
    ArrayList<ArrayList<String>> pR = new ArrayList<ArrayList<String>>(quantos);
    for(l=0;l<quantos;l++){
       par=new ArrayList<String>(2);
       if(j==0){s=perguntas(optn);j=1;}
       if(j==1){s=respostas(optn);j=0;}
       par.add(s);
    return pR;
   }
   return null;
 }
 
 public static String perguntas(int opção) {
       if(opção==1)  return "Como se chama o pai das ciências de computação?";
       else if(opção==2) return "Quem inventou a lâmpada elétrica incandescente?";
       else if(opção==3) return "Quem formulou a famosa Teoria da Relatividade?";
       else if(opção==4) return "Quem inventou o primeiro automovel movimentado por um motor de combustão interna?";
       else if(opção==5) return "Quem inventou a penincilina?";
       else if(opção==6) return "Qual o planeta principal do sistema solar que foi despromovido em 24 de agosto de 2006?";
       else if(opção==7) return "Qual o valor aconselhado do pH do sangue humano?";
       else if(opção==8) return "A cerveja Duff aparece em que desenhos animados?";
       else if(opção==9) return "Qual é o nome da primeira linguagem de programação?";
       else if(opção==10) return "Qual o nome da primeira nave espacial da NASA?";
       else if(opção==11) return "Quem pintou o famoso quadro da Mona Lisa?";
       else if(opção==12) return "Que nome se dá a técnica Japonesa de dobrar papel?";
       else if(opção==13) return "Em que ano começaram os Descobrimentos, efectuados por Portugal?";
       else if(opção==14) return "Quem disse a famosa frase em latim 'Alea Jacta Est',isto é, 'O dado está lançado'?";
       else if(opção==15) return "Por qual elemento principal está constituída a maioria dos seres vivos?";
       else if(opção==16) return "Pessoas diabéticas tem a falta de...?";
       else if(opção==17) return "Qual é o planeta considerado planeta dos anéis?";
       else if(opção==18) return "Onde fica o México?";
       else if(opção==19) return "Em que ano acabou a Ditadura Militar no Brasil?";
       else return "De que cor eram as bandeiras dos piratas?";
 }
   
 public static String respostas(int pergunta){
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
}
