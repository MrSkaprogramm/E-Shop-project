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
import by.epam.tr.bean.Item;
import by.epam.tr.bean.User;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.OrderService;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.ServiceProvider;

/**
 * 
 * Class - command to place an order
 *
 */
public class MakeOrderCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(MakeOrderCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession(true);
    User user = (User) session.getAttribute("user");
    List<Item> cart = (List<Item>) session.getAttribute("cart");
    int userId = user.getUserId();
    boolean isOrdered;
    OrderService orderService = ServiceProvider.getServiceprovider().getOrderService();

    try {
      if (cart.size() > 0) {
        isOrdered = orderService.makeOrder(userId, cart);

        if (isOrdered) {
          RequestDispatcher dispatcher =
          request.getRequestDispatcher(JSPPageName.MAKE_ORDER_SUCCESS_PAGE);
          dispatcher.forward(request, response);
        } else {
          RequestDispatcher dispatcher =
              request.getRequestDispatcher(JSPPageName.WRONG_ORDER_PAGE);
          dispatcher.forward(request, response);
        }
      } else {
        RequestDispatcher dispatcher =
            request.getRequestDispatcher(JSPPageName.WRONG_ORDER_PAGE);
        dispatcher.forward(request, response);
      }
    } catch (ServiceException e) {
      LOGGER.error(e.getMessage());
    }
    cart.clear();
    session.removeAttribute("cart");
    session.setAttribute("cart", cart);
  }
}
