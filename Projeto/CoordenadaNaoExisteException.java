public class CoordenadaNaoExisteException extends Exception
{
    /**
     * COnstrutor para objetos da classe CoordenadaNaoExisteException
     */
    public CoordenadaNaoExisteException()
    {
        super();
    }

    public CoordenadaNaoExisteException(double x)
    {
        String str=null;
        try {
            x = Double.parseDouble(str);
            System.out.println( "O número é " + x );
        }
        catch ( NumberFormatException e ) {
            System.out.println( "Número ilegal" );
            x = Double.NaN;
        }
    }
}
