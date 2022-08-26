package by.epam.tr.controller.command.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.command.Command;

/**
 * 
 * Class - exit command from the program
 *
 */
public class ExitCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(ExitCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getSession().invalidate();
    request.getSession(true);

    try {
      RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE);
      dispatcher.forward(request, response);
    } catch (IOException e) {
      LOGGER.error("Invalid address to redirect in QuitFromAccount", e);
    }
  }
}
