     import java.lang.Object;
     import javax.swing.table.AbstractTableModel;
     import javax.swing.table.DefaultTableModel;
     
/**
 * Write a description of class StatsUtilizador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatsUtilizador
{
    
    String[] columNames;
    String[] rowNames;
    int[][] data;
 
  
    public StatsUtilizador()
    {
        this.columNames = new String[] {"Caches Descobertas","GeoCoins Facturados","Nublado","Chuvas Fracas","Chuvas Fortes","Frio","Sol","Quente"};
        this.rowNames = new String[] {"MisteryCache","MultiCache","MicroCache"};
        this.data = new int[3][8];
    }
    
    public StatsUtilizador(String[] c,String[] r,int[][] d)
    {
        this.columNames = c;
        this.rowNames = r;
        this.data = d;
    }
    
    /**
     *  Actualiza a informação de descoberta de Cache
     *  
     *      Incrementa o numero de caches descobertas e o clima do tipo concreto de Cache
     *      Adiciona os geocoins à coluna dos GeoCoins Facturados
     */ 
    public void add(Cache cache,int geoCoins,String tempo) throws StringExisteException 
    {
        for( int i = 0; i < rowNames.length ; i++)
            if ( cache.getClass().getName().equals(rowNames[i]))
                for( int j = 0; j < columNames.length ; j++)
                    {
                        if( j == 0) data[i][j]++;
                        if( j == 1) data[i][j]+=geoCoins;
                        if( tempo.equals(columNames[j])) data[i][j]++;
                    }
    }
    
    /**
     *  Verifica se é o clima que o utilizador tem melhor performance 
     */
    public boolean climaFavorito(String clima) throws StringExisteException
    {
        String melhorClima = null;
        int max = -1;
        
        for( int i = 0; i < rowNames.length ; i++)
                for( int j = 0; j < columNames.length ; j++)
                    if( j > 2  && this.data[i][j] > max) 
                        {
                            melhorClima = this.columNames[j];
                            max = this.data[i][j];
                        }
        return melhorClima.equals(clima);
    }
    
    public String toString() {
      StringBuilder sb = new StringBuilder();
      for( int i = 0; i < rowNames.length ; i++){
         sb.append("RowNames: ");
         sb.append(this.rowNames[i]+" \n\n");
         for( int j = 0; j < columNames.length ; j++){
             sb.append("ColumNames: ");
             sb.append(this.columNames[j]+" \n");
         }
      }
      System.out.println(sb.toString());
      return sb.toString();
    }
  
}
