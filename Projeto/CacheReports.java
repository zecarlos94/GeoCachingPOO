import java.util.*;
import java.io.*;

/**
 *  Contem todos os reports ordenados por timeline.
 *
 */
public class CacheReports implements Serializable
{
    // instance variables - replace the example below with your own
    private TreeMap<Timeline,Report> reports;

    /**
     * Constructor for objects of class CacheReports
     */
    public CacheReports()
    {
        reports = new TreeMap<Timeline,Report>(new TimelineComparator());
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
      *     De notar que Report é constituídos por variáveis wrappers 
      */
     
     public void add(Report r)
     {
         this.reports.put(r.getTime(),r);
     }

      public void removeReport(Timeline d) 
      {
          this.reports.remove(d);
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
   
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Iterator<Report> it = this.reports.values().iterator();
        sb.append("Reports:\n");
        while(it.hasNext()){
            sb.append(it.next().toString() + "\n");
        }
        return sb.toString();
    }
    
    public Iterator<Map.Entry<Timeline, Report>> iterator() {
        return this.reports.entrySet().iterator();
    }
}
