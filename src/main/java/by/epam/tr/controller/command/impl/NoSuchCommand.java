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
 * Class - command in case of an error
 *
 */
public class NoSuchCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(NoSuchCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE);
    try {
      requestDispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      LOGGER.error(e.getMessage());
    }
  }

}
