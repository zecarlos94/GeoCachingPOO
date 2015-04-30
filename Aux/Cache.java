import java.util.ArrayList;

public class Cache {

        private ArrayList<User> registos;
        private WGS84_Coordinates coordinates;
        
        public Cache()
        {
            registos = new ArrayList<User>();
            coordinates = new WGS84_Coordinates();
        }

        public Cache(ArrayList<User> registos, WGS84_Coordinates coordinates)
        {
            this.setRegistos(registos);
            this.setCoordinates(coordinates);
        }
        
        public Cache(Cache cache)
        {
            registos = cache.getRegistos();
            coordinates = cache.getCoordinates();
        }
        
        public ArrayList<User> getRegistos()
        {
            ArrayList<User> v = new ArrayList<User>();
            for( User u : this.registos )
                v.add(u.clone());
            return v;
        }
        
        public WGS84_Coordinates getCoordinates()
        {
            return this.coordinates.clone();
        }
        
        public void setRegistos(ArrayList<User> users)
        {
            registos = new ArrayList<User>();
            for( User u : users )
                registos.add(u.clone());
        }
        
        public void setCoordinates(WGS84_Coordinates c)
        {
            this.coordinates = new WGS84_Coordinates(c);
        }
        
       public boolean equals(Object obj)
       {
           if(this == obj) return true; 
           if((obj == null) || (this.getClass() != obj.getClass())) return false;
           Cache c = (Cache) obj;
           return( registos.equals(c.getRegistos()) && coordinates.equals(c.getCoordinates()));
        }
   
        public String toString(){
            StringBuilder sb = new StringBuilder(); 
            sb.append("Registos de Utilizadores:\n");
            sb.append(this.registos.toString() + "\n");
            sb.append("Posição da Cache:\n");
            sb.append(this.coordinates.toString() + "\n");
            return sb.toString();
        }
    
        public Cache clone(){
            return new Cache(this);
        }
}