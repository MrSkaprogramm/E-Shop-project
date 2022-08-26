package by.epam.tr.service.validation.impl;

import by.epam.tr.service.validation.PaymentValidator;

/**
 * 
 * Validation class for the Payment entity data
 *
 */
public class PaymentValidatorImpl implements PaymentValidator {
  private static final String BANK_CARD_NUM_REGEX = "[0-9]{16}";
  private static final String EXPIRING_DATE_REGEX = "[0-9]{4}";

  public boolean checkPaymentInfo(String bankCardNum, String expiringDate) {
    boolean isValid = true;

    if (!validatePaymentBankCardNum(bankCardNum)) {
      isValid = false;
    }

    if (!validatePaymentExpiringDate(expiringDate)) {
      isValid = false;
    }
    return isValid;
  }

  @Override
  public boolean validatePaymentBankCardNum(String bankCardNum) {
    return bankCardNum.matches(BANK_CARD_NUM_REGEX);
  }

  @Override
  public boolean validatePaymentExpiringDate(String expiringDate) {
    return expiringDate.matches(EXPIRING_DATE_REGEX);
  };
}
