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
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.RequestParamName;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.OrderService;
import by.epam.tr.service.ServiceProvider;

/**
 * 
 * Class - the command to add an item to the cart
 *
 */
public class AddItemToCartCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(AddItemToCartCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession(true);
    List<Item> cart = (List<Item>) session.getAttribute("cart");

    int itemId = Integer.valueOf(request.getParameter(RequestParamName.REQ_PARAM_ITEM_ID));
    String name = request.getParameter(RequestParamName.REQ_PARAM_ITEM_NAME);
    String itemInfo = request.getParameter(RequestParamName.REQ_PARAM_ITEM_INFO);
    int price =
        Integer.valueOf(request.getParameter(RequestParamName.REQ_PARAM_ITEM_PRICE));

    OrderService orderService = ServiceProvider.getServiceprovider().getOrderService();

    cart = orderService.addItemToCart(cart, itemId, name, itemInfo, price);
    session.removeAttribute("cart");
    session.setAttribute("cart", cart);
    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ADD_ITEM_TO_CART_PAGE);
    dispatcher.forward(request, response);
  }
}
