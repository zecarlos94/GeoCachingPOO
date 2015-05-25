import java.util.*;

/**
 * Classe que contém todas as estruturas contidas na aplicação
 */
public class GeoCaching
{
    Utilizadores utilizadores;
    ArrayList<String> admins;           // Estes nomes são comparados com os emails dos users em isAdmin();
    Caches caches;
    CacheReports reports;
    
    public GeoCaching() {
        this.utilizadores=new Utilizadores();
        this.admins=new ArrayList<String>(); this.admins.add("Gustavo"); this.admins.add("Zé"); this.admins.add("Tiago"); 
        this.caches=new Caches();
        this.reports=new CacheReports();
    }
    
    public GeoCaching(Utilizadores users, Caches caches, CacheReports reports) {
        this.utilizadores=new Utilizadores(users);
        this.caches=new Caches(caches);
        this.reports=new CacheReports(reports);
    }
    
    public GeoCaching(GeoCaching gc) {
        this.utilizadores=gc.getUtilizadores();
        this.admins=gc.getAdmins();
        this.caches=gc.getCaches();
        this.reports=gc.getReports();
    }
    
    public Utilizadores getUtilizadores() {
        return this.utilizadores.clone();
    }
    
    public ArrayList<String> getAdmins() {
        return this.admins;
    }
    
    public Caches getCaches() {
        return this.caches.clone();
    }
    
    public CacheReports getReports() {
        return this.reports.clone();
    }
    
    public void setUtilizadores(Utilizadores u) {
        this.utilizadores=u.clone();
    }
    
    public void setCaches(Caches c) {
        this.caches=c.clone();
    }
    
    public void setReports(CacheReports reports) {
        this.reports=reports.clone();
    }
    
    public boolean equals(Object obj) {
       if(this == obj) return true;  // é o próprio
       if((obj == null) || (this.getClass() != obj.getClass())) return false;
       GeoCaching c = (GeoCaching) obj;
       return(this.utilizadores.equals(c.getUtilizadores()) && this.admins.equals(c.getAdmins()) && this.caches.equals(c.getCaches()) && this.reports.equals(c.getReports()));
    }
    
    public GeoCaching clone() {
        return new GeoCaching(this);
    }
}
