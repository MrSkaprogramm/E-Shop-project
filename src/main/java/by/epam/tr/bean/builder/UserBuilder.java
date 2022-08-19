package by.epam.tr.bean.builder;

import by.epam.tr.bean.Role;
import by.epam.tr.bean.User;
import by.epam.tr.bean.UserStatus;

public class UserBuilder {
  private User user = new User();

  public void setUserId(int userId) {
    user.setUserId(userId);
  }

  public void setLogin(String login) {
    user.setLogin(login);
  }

  public void setPassword(String password) {
    user.setPassword(password);
  }

  public void setRole(Role role) {
    user.setRole(role);
  }

  public void setFio(String fio) {
    user.setFio(fio);
  }

  public void setEmail(String email) {
    user.setEmail(email);
  }

  public void setAddress(String address) {
    user.setAddress(address);
  }

  public void setStatus(UserStatus status) {
    user.setStatus(status);
  }

  public User build() {
    return user;
  }
}
