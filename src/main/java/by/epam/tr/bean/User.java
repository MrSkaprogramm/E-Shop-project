package by.epam.tr.bean;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
  private static final long serialVersionUID = 6723503339297760504L;
  private int userId;
  private String login;
  private String password;
  private Role role;
  private String fio;
  private String email;
  private String phoneNum;
  private String address;
  private UserStatus status;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Role getRole() {
    return role;
  }
  public void setRole(Role role) {
    this.role = role;
  }
  public String getFio() {
    return fio;
  }
  public void setFio(String fio) {
    this.fio = fio;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhoneNum() {
    return phoneNum;
  }
  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public UserStatus getStatus() {
    return status;
  }
  public void setStatus(UserStatus status) {
    this.status = status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, email, fio, login, password, phoneNum, role, status, userId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    return Objects.equals(address, other.address) && Objects.equals(email, other.email)
        && Objects.equals(fio, other.fio) && Objects.equals(login, other.login)
        && Objects.equals(password, other.password) && Objects.equals(phoneNum, other.phoneNum)
        && role == other.role && status == other.status && userId == other.userId;
  }

  @Override
  public String toString() {
    return "User [userId=" + userId + ", login=" + login + ", password=" + password + ", role="
        + role + ", fio=" + fio + ", email=" + email + ", phoneNum=" + phoneNum + ", address="
        + address + ", status=" + status + "]";
  }
}
