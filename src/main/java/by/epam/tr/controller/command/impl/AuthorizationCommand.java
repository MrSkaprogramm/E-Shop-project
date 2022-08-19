package by.epam.tr.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.tr.bean.Item;
import by.epam.tr.bean.Role;
import by.epam.tr.bean.User;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.RequestParamName;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.ServiceProvider;
import by.epam.tr.service.UserService;

public class AuthorizationCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(AuthorizationCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("Hello Word");

    String login;
    String password;

    login = request.getParameter(RequestParamName.REQ_PARAM_LOGIN);
    password = request.getParameter(RequestParamName.REQ_PARAM_PASS);
    System.out.println(login);
    System.out.println(password);

    UserService userService = ServiceProvider.getServiceprovider().getClientService();
    RequestDispatcher dispatcher;

    User user;

    try {

      user = userService.userAuth(login, password);
      List<Item> cart = new ArrayList<Item>();
      System.out.println(user);
      request.setAttribute("user", user);

      if (user != null) {
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        session.setAttribute("cart", cart);
      }
      if (user.getRole() == Role.CLIENT) {
        dispatcher = request.getRequestDispatcher(JSPPageName.USER_CLIENT_PROFILE_PAGE);
      } else {
        dispatcher = request.getRequestDispatcher(JSPPageName.USER_ADMIN_PROFILE_PAGE);
      }
      dispatcher.forward(request, response);
    } catch (ServiceException e) {
      LOGGER.error(e.getMessage());
    }
  }

}
