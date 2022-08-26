package by.epam.tr.controller.command.impl.go;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.command.Command;

/**
 * 
 * Class - the command to go to the order payment page
 *
 */
public class GoPayCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.PAYMENT_PAGE);
    dispatcher.forward(request, response);
  }
}
