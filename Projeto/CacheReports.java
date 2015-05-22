import java.util.*;

/**
 *  Contem todos os reports ordenados por data.
 *
 */
public class CacheReports
{
    // instance variables - replace the example below with your own
    private TreeMap<Data,Report> reports;

    /**
     * Constructor for objects of class CacheReports
     */
    public CacheReports()
    {
        reports = new TreeMap<Data,Report>();
    }
    
    public CacheReports(TreeMap<Data,Report> reports)
    {
        setReports(reports);   
    }
    
    public CacheReports(CacheReports cr)
    {
        reports = cr.getReports();
    }
    
    public TreeMap<Data,Report> getReports()
    {
        TreeMap<Data,Report> res = new TreeMap<Data,Report>(new DataComparator());
        Iterator<Map.Entry<Data,Report>> it = this.reports.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Data,Report> elem = it.next();
            res.put(elem.getKey().clone(),elem.getValue().clone());
        }
        return res;
    }

     public  void setReports(TreeMap<Data,Report> input)
     {
        this.reports = new TreeMap<Data,Report>(new DataComparator());
        Iterator<Map.Entry<Data,Report>> it = input.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Data,Report> elem = it.next();
            this.reports.put(elem.getKey().clone(),elem.getValue().clone());
        }
   
     }
     
     /*
      * Adiciona um report à respetiva Cache 
      */
     
     public void addReport(Cache c,String texto,Data d)
     {
         Report report = new Report(c.getCoordenadas(),texto);
         this.reports.put(d,report);
      }
      /*
       *  Adiciona um report recebendo as coordenadas da cache 
       */
      public void addReport(Coordenadas c,String texto,Data d)
      {
          Report report = new Report(c,texto);
          this.reports.put(d,report);
      }
      
      public void removeReport(Data d)
      {
          reports.remove(d);
       }
    
     public CacheReports clone()
     {
        return new CacheReports(this);
     }
    
    public boolean equals(Object obj)
    {
       if(this == obj) return true;  // é o próprio
       if((obj == null) || (this.getClass() != obj.getClass())) return false;
      CacheReports cr = (CacheReports) obj;
      return this.reports.equals(cr.getReports());
    }
    //falta tostring
    
}
