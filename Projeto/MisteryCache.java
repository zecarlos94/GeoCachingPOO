
import java.util.*;
//import java.lang.*;

public class MisteryCache extends Cache implements Tesouro{
    private ArrayList<ArrayList<String>> perguntasRespostas;
    private int geocoins; // geo coins minimos (50-100)
   
    
    public MisteryCache() {
           super();
           perguntasRespostas=new ArrayList<ArrayList<String>>();
           geocoins=(new geraGeoCoins()).getGeoCoins();
    }
    
    public MisteryCache(HashMap<String,Timeline> livro_registos, Timeline timeline, Coordenadas coordenadas, ArrayList<ArrayList<String>> perguntasRespostas, int geocoins) throws NumberFormatException  {
            super(livro_registos,timeline,coordenadas);
            setPerguntasRespostas(perguntasRespostas);
            this.geocoins=geocoins;
    }
    
    public MisteryCache(Coordenadas coordenadas, ArrayList<ArrayList<String>> perguntasRespostas) throws NumberFormatException {
            super(coordenadas);
            setPerguntasRespostas(perguntasRespostas);
            this.geocoins=geocoins;
    }

    public MisteryCache(MisteryCache c) throws NumberFormatException {
            super(c);
            perguntasRespostas =c.getPerguntasRespostas();
            geocoins=c.getGeoCoins();
    }
    
    
    public int getGeoCoins(){
        return geocoins;
    }
    /**
     *  Devolve o numero de geocoins que o utilizador ganhou com esta cache
     *      Depende dos geocoins base (50-100) e do numero de respostas certas
     */
    public int getGeoCoinsTotais(int respostasCertas)
    {
        return geocoins + (geocoins/4) * respostasCertas;
    }
    
    public ArrayList<ArrayList<String>> getPerguntasRespostas(){
        return perguntasRespostas;
    }
    
    public int getNumeroPerguntas(){
        return this.perguntasRespostas.size();
    }
    
    public void setGeocoins(int coins) throws NumberFormatException {
        this.geocoins=coins;
    }
    
    public void setPerguntasRespostas(ArrayList<ArrayList<String>> perguntasRespostas) {
        this.perguntasRespostas = new ArrayList<ArrayList<String>>();
        for(ArrayList<String> par : perguntasRespostas){
            par = new ArrayList<String>(2);
            for(String s : par)
                par.add(s);
            this.perguntasRespostas.add(par);
        }
    }
    
    public MisteryCache clone() {
        return new MisteryCache(this);
    }
    
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      MisteryCache c = (MisteryCache) obj;
      if( super.equals(obj) && this.geocoins == c.getGeoCoins() && this.perguntasRespostas.equals(c.getPerguntasRespostas())) return true;   
      else return false;
    }
    
    public int respostasCertas(ArrayList<ArrayList<String>> perguntasRespostas) {
        int certas=0;
        String res="N/A";
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<String>> aux = new ArrayList<ArrayList<String>>();
        for(ArrayList<String> par : perguntasRespostas){
            for(String s : par)
                System.out.println("A pergunta é: "+par.get(1)+"\n");
                System.out.println("Escreva a sua resposta\n");
                res=sc.next();
                if(res.equals(par.get(2))){certas++;}
        }
        return certas;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo: MysteryCache \n " + super.toString());
        for ( ArrayList<String> par : this.perguntasRespostas)
            {
                sb.append("Pergunta:"+par.get(0) + "\n");
                sb .append("Resposta:" + par.get(1) + "\n");
            }
        sb.append("Tesouro máximo:" + getGeoCoinsTotais( perguntasRespostas.size() ) + "\n");
        return sb.toString();
    }
}