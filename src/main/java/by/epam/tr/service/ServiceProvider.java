package by.epam.tr.service;

import by.epam.tr.service.impl.ItemServiceImpl;
import by.epam.tr.service.impl.OrderServiceImpl;
import by.epam.tr.service.impl.PaymentServiceImpl;
import by.epam.tr.service.impl.UserServiceImpl;

/**
 * 
 * The explorer class redirects to a specific class of the Service layer
 *
 */
public class ServiceProvider {
  private static final ServiceProvider serviceProvider = new ServiceProvider();

  private UserService clientService = new UserServiceImpl();
  private ItemService itemService = new ItemServiceImpl();
  private OrderService orderService = new OrderServiceImpl();
  private PaymentService paymentService = new PaymentServiceImpl();

  public ServiceProvider() {}

  public UserService getClientService() {
    return clientService;
  }

  public void setClientService(UserService clientService) {
    this.clientService = clientService;
  }

  public ItemService getItemService() {
    return itemService;
  }

  public void setItemService(ItemService itemService) {
    this.itemService = itemService;
  }

  public OrderService getOrderService() {
    return orderService;
  }

  public void setOrderService(OrderService orderService) {
    this.orderService = orderService;
  }

  public PaymentService getPaymentService() {
    return paymentService;
  }

  public void setPaymentService(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  public static ServiceProvider getServiceprovider() {
    return serviceProvider;
  }
}
