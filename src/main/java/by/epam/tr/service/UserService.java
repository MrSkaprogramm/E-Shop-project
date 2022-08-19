package by.epam.tr.service;

import java.util.List;
import by.epam.tr.bean.User;

public interface UserService {
  public User userAuth(String login, String password) throws ServiceException;

  public User userRegistration(String login, String password, String fio, String email,
      String phoneNum, String address, int role) throws ServiceException;

  public void addtoBlackList(int userId) throws ServiceException;

  public List<User> getAllPaymentEvaders() throws ServiceException;
}
