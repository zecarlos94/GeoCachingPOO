
/**
 *  Um report e constituido por uma string com a informaçao do queixoso e  coordenadas que servem como chave da cache
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Report
{
    private Coordenadas coordenadas;
    
    private String texto;

    /**
     * Constructor for objects of class Report
     */
    public Report()
    {
       coordenadas = new Coordenadas();
       texto = "N/A";
    }

    public Report(Coordenadas coordenadas,String texto)
    {
       this.coordenadas = coordenadas.clone();
       texto = texto;
    }
    
    public Report(Report report)
    {
        coordenadas = report.getCoordenadas();
        texto = report.getTexto();
    }
    
    public Coordenadas getCoordenadas()
    {
        return coordenadas.clone();
    }
    
    public String getTexto()
    {
        return texto;
    }
    
    public void setTexto(String texto)
    {
        this.texto = texto;
    }
    
    public void setCoordenadas(Coordenadas coordenadas)
    {
        this.coordenadas = coordenadas.clone();
    }
    
    public Report clone()
    {
        return new Report(this);
    }
    
    public boolean equals(Object obj)
    {
         if(this == obj) return true;  // é o próprio
       if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Report report = (Report) obj;
      return (this.coordenadas.equals(report.getCoordenadas()) && this.texto.equals(report.getTexto()));
    }
    //falta toString
}