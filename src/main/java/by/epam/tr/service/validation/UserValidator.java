package by.epam.tr.service.validation;

/**
 * 
 * An interface containing methods for verifying the correctness of the User entity data
 *
 */
public interface UserValidator {
  public boolean checkUserAuthInfo(String login, String password);

  public boolean checkUserRegisterInfo(String login, String password, String fio, String email,
      String address);

  public boolean validateUserLogin(String login);

  public boolean validateUserPassword(String password);

  public boolean validateUserFio(String password);

  public boolean validateUserEmail(String email);

  public boolean validateUserAddress(String email);
}
