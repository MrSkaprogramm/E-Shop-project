package by.epam.tr.dao;

/**
 * 
 * Interface of the DAO layer containing methods that work with the Order and Payment entities
 *
 */
public interface PaymentDao {
  public void makePayment(int orderId, String bankCardNum, String expiringDate) throws DaoException;
}
