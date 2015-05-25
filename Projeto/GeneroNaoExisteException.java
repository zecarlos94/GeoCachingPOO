public class GeneroNaoExisteException extends Exception
{
    /**
     * COnstrutor para objetos da classe GeneroNaoExisteException
     */
    public GeneroNaoExisteException()
    {
        super();
    }

    public GeneroNaoExisteException(char str)
    {
       super(str);
    }
}