package by.epam.tr.service.impl;

import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.DaoProvider;
import by.epam.tr.dao.PaymentDao;
import by.epam.tr.service.PaymentService;
import by.epam.tr.service.ServiceException;

public class PaymentServiceImpl implements PaymentService {
  private static final DaoProvider daoProvider = DaoProvider.getDaoprovider();
  private static final PaymentDao paymentDao = daoProvider.getPaymentDao();

  @Override
  public void makePayment(int orderId, String bankCardNum, String expiringDate)
      throws ServiceException {

    try {
      paymentDao.makePayment(orderId, bankCardNum, expiringDate);;
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
  }
}
