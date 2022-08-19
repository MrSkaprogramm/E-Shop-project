package by.epam.tr.dao;

public class DaoException extends Exception{
  private static final long serialVersionUID = -3949015888945271637L;

  public DaoException() {
    super();
  }

  public DaoException(String message) {
    super(message);
  }

  public DaoException(Exception e) {
    super(e);
  }

  public DaoException(String message, Exception e) {
    super(message, e);
  }
}
