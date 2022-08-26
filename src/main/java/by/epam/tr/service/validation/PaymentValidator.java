package by.epam.tr.service.validation;

/**
 * 
 * An interface containing methods for verifying the correctness of the Payment entity data
 *
 */
public interface PaymentValidator {
  public boolean checkPaymentInfo(String bankCardNum, String expiringDate);

  public boolean validatePaymentBankCardNum(String bankCardNum);

  public boolean validatePaymentExpiringDate(String expiringDate);
}
