package br.com.nfx;


public class InvalidEncryptException extends Exception
{
  public InvalidEncryptException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public InvalidEncryptException(String message) {
    super(message);
  }

  public InvalidEncryptException(Throwable cause) {
    super(cause);
  }
}
