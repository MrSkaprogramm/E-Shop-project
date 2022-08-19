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
import by.epam.tr.controller.command.Command;

public class ShowCartCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(ShowCartCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    List<Item> cart = (List<Item>) session.getAttribute("cart");

    request.setAttribute("cart", cart);
    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.CART_PAGE);
    dispatcher.forward(request, response);
  }
}
