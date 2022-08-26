package by.epam.tr.service.validation;

import by.epam.tr.service.validation.impl.ItemValidatorImpl;
import by.epam.tr.service.validation.impl.PaymentValidatorImpl;
import by.epam.tr.service.validation.impl.UserValidatorImpl;

/**
 * 
 * Explorer class redirecting to a specific data validation class
 *
 */
public class ValidatorProvider {
  private static final ValidatorProvider validatorProvider = new ValidatorProvider();
  private ItemValidator itemValidator = new ItemValidatorImpl();
  private PaymentValidator paymentValidator = new PaymentValidatorImpl();
  private UserValidator userValidator = new UserValidatorImpl();

  private ValidatorProvider() {}

  public ItemValidator getItemValidator() {
    return itemValidator;
  }

  public void setItemValidator(ItemValidator itemValidator) {
    this.itemValidator = itemValidator;
  }

  public PaymentValidator getPaymentValidator() {
    return paymentValidator;
  }

  public void setPaymentValidator(PaymentValidator paymentValidator) {
    this.paymentValidator = paymentValidator;
  }

  public UserValidator getUserValidator() {
    return userValidator;
  }

  public void setUserValidator(UserValidator userValidator) {
    this.userValidator = userValidator;
  }

  public static ValidatorProvider getValidatorprovider() {
    return validatorProvider;
  }
}
