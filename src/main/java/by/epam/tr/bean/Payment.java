package by.epam.tr.bean;

import java.io.Serializable;
import java.util.Objects;

public class Payment implements Serializable {
  private static final long serialVersionUID = 580027163494227104L;
  private double paymentSum;
  private int bankCardNum;
  private String expiringDate;

  public double getPaymentSum() {
    return paymentSum;
  }

  public void setPaymentSum(double paymentSum) {
    this.paymentSum = paymentSum;
  }

  public int getBankCardNum() {
    return bankCardNum;
  }

  public void setBankCardNum(int bankCardNum) {
    this.bankCardNum = bankCardNum;
  }

  public String getExpiringDate() {
    return expiringDate;
  }

  public void setExpiringDate(String expiringDate) {
    this.expiringDate = expiringDate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankCardNum, expiringDate, paymentSum);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Payment other = (Payment) obj;
    return bankCardNum == other.bankCardNum && Objects.equals(expiringDate, other.expiringDate)
        && Double.doubleToLongBits(paymentSum) == Double.doubleToLongBits(other.paymentSum);
  }

  @Override
  public String toString() {
    return "Payment [paymentSum=" + paymentSum + ", bankCardNum=" + bankCardNum + ", expiringDate="
        + expiringDate + "]";
  }
}
