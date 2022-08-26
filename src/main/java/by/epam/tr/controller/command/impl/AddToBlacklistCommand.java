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
 * Class - a command to add a user to the blacklist
 *
 */
public class AddToBlacklistCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(AddToBlacklistCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int userId;

    userId = Integer.valueOf(request.getParameter(RequestParamName.REQ_PARAM_ID));

    UserService userService = ServiceProvider.getServiceprovider().getClientService();

    try {

      userService.addtoBlackList(userId);

      RequestDispatcher dispatcher =
          request.getRequestDispatcher(JSPPageName.ADD_TO_BLACKLIST_SUCCESS_PAGE);
      dispatcher.forward(request, response);
    } catch (ServiceException e) {
      LOGGER.error("paymentEvaders", e);
    }
  }
}
