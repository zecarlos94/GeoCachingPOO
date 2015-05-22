import java.util.*;

/**
 *  Contem todos os reports ordenados por timeline.
 *
 */
public class CacheReports
{
    // instance variables - replace the example below with your own
    private TreeMap<Timeline,Report> reports;

    /**
     * Constructor for objects of class CacheReports
     */
    public CacheReports()
    {
        reports = new TreeMap<Timeline,Report>();
    }
    
    public CacheReports(TreeMap<Timeline,Report> reports)
    {
        setReports(reports);   
    }
    
    public CacheReports(CacheReports cr)
    {
        reports = cr.getReports();
    }
    
    public TreeMap<Timeline,Report> getReports()
    {
        TreeMap<Timeline,Report> res = new TreeMap<Timeline,Report>(new TimelineComparator());
        Iterator<Map.Entry<Timeline,Report>> it = this.reports.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Timeline,Report> elem = it.next();
            res.put(elem.getKey().clone(),elem.getValue().clone());
        }
        return res;
    }

     public  void setReports(TreeMap<Timeline,Report> input)
     {
        this.reports = new TreeMap<Timeline,Report>(new TimelineComparator());
        Iterator<Map.Entry<Timeline,Report>> it = input.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Timeline,Report> elem = it.next();
            this.reports.put(elem.getKey().clone(),elem.getValue().clone());
        }
   
     }
     
     /*
      * Adiciona um report à respetiva Cache 
      */
     
     public void addReport(Cache c,String texto,Timeline d)
     {
         Report report = new Report(c.getCoordenadas(),texto);
         this.reports.put(d,report);
      }
      /*
       *  Adiciona um report recebendo as coordenadas da cache 
       */
      public void addReport(Coordenadas c,String texto,Timeline d)
      {
          Report report = new Report(c,texto);
          this.reports.put(d,report);
      }
      
      public void removeReport(Timeline d)
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
