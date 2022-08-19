package by.epam.tr.service;

public interface PaymentService {
  public void makePayment(int orderId, String bankCardNum, String expiringDate)
      throws ServiceException;
}
