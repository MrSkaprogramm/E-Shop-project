package by.epam.tr.service;

/**
 * 
 * Interface of the Service layer containing methods that work with the Payment and Order entity
 *
 */
public interface PaymentService {
  public void makePayment(int orderId, String bankCardNum, String expiringDate)
      throws ServiceException;
}
