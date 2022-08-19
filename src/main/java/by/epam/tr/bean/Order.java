package by.epam.tr.bean;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable{
  private static final long serialVersionUID = 7366414920112831376L;
  private int orderId;
  private Payment payment;
  private boolean orderStatus;

  public Order() {
    this.payment = new Payment();
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public boolean isOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(boolean orderStatus) {
    this.orderStatus = orderStatus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, orderStatus, payment);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Order other = (Order) obj;
    return orderId == other.orderId && orderStatus == other.orderStatus
        && Objects.equals(payment, other.payment);
  }

  @Override
  public String toString() {
    return "Order [orderId=" + orderId + ", payment=" + payment + ", orderStatus=" + orderStatus
        + "]";
  }
}
