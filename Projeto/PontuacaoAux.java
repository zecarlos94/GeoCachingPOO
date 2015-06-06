
/**
 * Write a description of class PontuacaoAux here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PontuacaoAux
{
  private String email;
  private int multiCache;
  private int mysteryCache;
  private int microCache;
  private int pontos;
 
  public PontuacaoAux(String e){
      email = e;
      multiCache = 0;
      mysteryCache = 0;
      microCache = 0;
      pontos = 0;
    }
    public void addMultiCache(){this.multiCache++;}
    public void addMysteryCache(){this.mysteryCache++;}
    public void addMicroCache(){this.microCache++;}
    public void addPontos(int p){pontos+=p;}
    
    public int getPontos(){return pontos;}
    public int getMultiCache(){return multiCache;}
    public int getMysteryCache(){return mysteryCache;}
    public int getMicroCache(){ return microCache;}
    public String getEmail(){return email;}
}
