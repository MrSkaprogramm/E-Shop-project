package by.epam.tr.dao;

public interface PaymentDao {
  public void makePayment(int orderId, String bankCardNum, String expiringDate) throws DaoException;
}
