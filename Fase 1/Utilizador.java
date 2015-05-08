import java.util.*;

public class Utilizador
{
    /**
     * Variáveis de Instância
     */
    private String email;
    private String password;
    private String nome;
    private char genero;
    private String morada;                                          
    private Data data_nascimento;                                        
    private TreeMap<Date, Cache> atividades;    //Lista das atividades em que o utilizador participou, cuja chave corresponde à data em que o mesmo participou    
    private HashMap<String, Integer> estatisticas;    //Número de caches encontradas pelo utilizador por cada tipo
    private HashMap<String, Utilizador> amigos;     //Lista de amigos, cuja chave corresponde ao email de cada um      
}
