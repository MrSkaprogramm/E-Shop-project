package by.epam.tr.service.validation;

public class DataValidation {
  private static final DataValidation validation = new DataValidation();

  private DataValidation() {};
  // регулярные выражения
  public boolean check(String login, String password) {
    return false;
  };

  public static DataValidation getValidation() {
    return validation;
  }
}
