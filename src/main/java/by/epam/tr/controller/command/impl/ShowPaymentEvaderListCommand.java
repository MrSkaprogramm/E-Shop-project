package by.epam.tr.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.tr.bean.User;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.ServiceProvider;
import by.epam.tr.service.UserService;

/**
 * 
 * Class - the command to show the list of defaulters
 *
 */
public class ShowPaymentEvaderListCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(ShowPaymentEvaderListCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<User> paymentEvaders = new ArrayList<User>();
    UserService userService = ServiceProvider.getServiceprovider().getClientService();
    try {
      paymentEvaders = userService.getAllPaymentEvaders();
    } catch (ServiceException e) {
      LOGGER.error(e.getMessage());
    }
    request.setAttribute("paymentEvaders", paymentEvaders);
    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.PAYMENT_EVADERS_PAGE);
    dispatcher.forward(request, response);
  }
}