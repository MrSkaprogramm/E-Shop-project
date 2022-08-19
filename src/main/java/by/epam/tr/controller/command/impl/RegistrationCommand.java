package by.epam.tr.controller.command.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.tr.bean.User;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.RequestParamName;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.ServiceProvider;
import by.epam.tr.service.UserService;

public class RegistrationCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("Hello Word");

    String login;
    String password;
    String fio;
    String email;
    String phoneNum;
    String address;
    int role;

    login = request.getParameter(RequestParamName.REQ_PARAM_LOGIN);
    password = request.getParameter(RequestParamName.REQ_PARAM_PASS);
    fio = request.getParameter(RequestParamName.REQ_PARAM_FIO);
    email = request.getParameter(RequestParamName.REQ_PARAM_EMAIL);
    phoneNum = request.getParameter(RequestParamName.REQ_PARAM_PHONE_NUM);
    address = request.getParameter(RequestParamName.REQ_PARAM_ADDRESS);
    role = Integer.valueOf(request.getParameter(RequestParamName.REQ_PARAM_ROLE));
    System.out.println(login);
    System.out.println(password);

    UserService userService = ServiceProvider.getServiceprovider().getClientService();

    User user;

    try {

      user = userService.userRegistration(login, password, fio, email, phoneNum, address, role);
      System.out.println(user);

      if (user != null) {
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
      }

      RequestDispatcher dispatcher =
          request.getRequestDispatcher(JSPPageName.USER_REGISTER_SUCCESS_PAGE);
      dispatcher.forward(request, response);
    } catch (ServiceException e) {
      LOGGER.error(e.getMessage());
    }
  }

}
