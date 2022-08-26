package by.epam.tr.service;

/**
 * 
 * A class that collects all exceptions of the Service layer
 *
 */
public class ServiceException extends Exception{
  private static final long serialVersionUID = -4623415741722203526L;

  public ServiceException() {
    super();
  }

  public ServiceException(String message) {
    super(message);
  }

  public ServiceException(Exception e) {
    super(e);
  }

  public ServiceException(String message, Exception e) {
    super(message, e);
  }
}
