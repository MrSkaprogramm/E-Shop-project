package by.epam.tr.service.impl;

import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.DaoProvider;
import by.epam.tr.dao.PaymentDao;
import by.epam.tr.service.PaymentService;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.validation.PaymentValidator;
import by.epam.tr.service.validation.ValidatorProvider;

/**
 * 
 * A class of the Service layer containing methods for working with the Order and Payment entity
 *
 */
public class PaymentServiceImpl implements PaymentService {
  private static final DaoProvider daoProvider = DaoProvider.getDaoprovider();
  private static final PaymentDao paymentDao = daoProvider.getPaymentDao();
  private static final ValidatorProvider validatorProvider =
      ValidatorProvider.getValidatorprovider();
  private static final PaymentValidator paymentValidator = validatorProvider.getPaymentValidator();

  /**
   * 
   * Order payment method
   *
   */
  @Override
  public void makePayment(int orderId, String bankCardNum, String expiringDate)
      throws ServiceException {

    if (!paymentValidator.checkPaymentInfo(bankCardNum, expiringDate)) {
      throw new ServiceException("Wrong payment data");
    }

    try {
      paymentDao.makePayment(orderId, bankCardNum, expiringDate);;
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
  }
}
