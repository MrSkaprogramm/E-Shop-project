package by.epam.tr.service;

import java.util.List;
import by.epam.tr.bean.User;

/**
 * 
 * Interface of the Service layer containing methods that work with the User entity
 *
 */
public interface UserService {
  public User userAuth(String login, String password) throws ServiceException;

  public boolean userRegistration(String login, String password, String fio, String email,
      String phoneNum, String address, int role) throws ServiceException;

  public void addtoBlackList(int userId) throws ServiceException;

  public List<User> getAllPaymentEvaders() throws ServiceException;
}
