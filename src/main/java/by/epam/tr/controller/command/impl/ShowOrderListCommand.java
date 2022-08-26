package by.epam.tr.controller.command.impl;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.tr.bean.Order;
import by.epam.tr.bean.User;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.OrderService;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.ServiceProvider;

/**
 * 
 * Class - the command to display all user orders
 *
 */
public class ShowOrderListCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(ShowOrderListCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    OrderService orderService = ServiceProvider.getServiceprovider().getOrderService();
    List<Order> orders = null;
    HttpSession session = request.getSession(true);
    User user = (User) session.getAttribute("user");
    int userId = user.getUserId();

    try {
      orders = orderService.getAllOrders(userId);
    } catch (ServiceException e) {
      LOGGER.error(e.getMessage());
    }
    request.setAttribute("orders", orders);
    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ORDERS_LIST_PAGE);
    dispatcher.forward(request, response);
  }
}
