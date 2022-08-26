package by.epam.tr.service.validation;

/**
 * 
 * An interface containing methods for verifying the correctness of the Item entity data
 *
 */
public interface ItemValidator {
  public boolean checkItemInfo(String name, String itemInfo, int price);

  public boolean validateItemName(String name);

  public boolean validateItemInfo(String itemInfo);

  public boolean validateItemPrice(int price);

  public boolean checkItemInfo(String itemInfo, int price);
}
