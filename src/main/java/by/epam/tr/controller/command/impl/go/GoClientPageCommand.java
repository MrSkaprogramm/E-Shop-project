package by.epam.tr.controller.command.impl.go;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.epam.tr.bean.User;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.command.Command;

/**
 * 
 * Class - the command to go to the user's page as a client
 *
 */
public class GoClientPageCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession(true);
    User user = (User) session.getAttribute("user");
    request.setAttribute("user", user);
    RequestDispatcher dispatcher =
        request.getRequestDispatcher(JSPPageName.USER_CLIENT_PROFILE_PAGE);
    dispatcher.forward(request, response);
  }
}
