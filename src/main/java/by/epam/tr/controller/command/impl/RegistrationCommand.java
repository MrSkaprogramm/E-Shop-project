package by.epam.tr.controller.command.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.RequestParamName;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.ServiceProvider;
import by.epam.tr.service.UserService;

/**
 * 
 * Class - user registration command
 *
 */
public class RegistrationCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher;

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

    UserService userService = ServiceProvider.getServiceprovider().getClientService();

    try {

      boolean isRegistered =
          userService.userRegistration(login, password, fio, email, phoneNum, address, role);
      if (isRegistered) {
      dispatcher =
          request.getRequestDispatcher(JSPPageName.USER_REGISTER_SUCCESS_PAGE);
      dispatcher.forward(request, response);
    } else {
      dispatcher = request.getRequestDispatcher(JSPPageName.WRONG_DATA_PAGE);
      dispatcher.forward(request, response);
    }
    } catch (ServiceException e) {
      if (e.getMessage().equals("Wrong registration data")) {
        dispatcher = request.getRequestDispatcher(JSPPageName.WRONG_DATA_PAGE);
        dispatcher.forward(request, response);
      }
      LOGGER.error(e.getMessage());
    }
  }

}
