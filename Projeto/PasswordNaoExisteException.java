public class PasswordNaoExisteException extends Exception
{
    /**
     * COnstrutor para objetos da classe PasswordNaoExisteException
     */
    public PasswordNaoExisteException()
    {
        super();
    }

    public PasswordNaoExisteException(String str)
    {
       super(str);
    }
}