package by.epam.tr.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.epam.tr.bean.User;
import by.epam.tr.controller.command.Command;
import by.epam.tr.controller.command.CommandProvider;

@WebServlet("/controller")
public class Controller extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static CommandProvider provider = CommandProvider.getInstance();

  public Controller() {

  };

  protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
      throws ServletException, IOException {
    super.service(arg0, arg1);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    String commandName = request.getParameter(RequestParamName.REQ_PARAM_COMMAND_NAME);
    if (commandName.equals("goAuthorization")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE);
      dispatcher.forward(request, response);
    } else if (commandName.equals("goAddItem")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ADD_ITEM_PAGE);
      dispatcher.forward(request, response);
    } else if (commandName.equals("goAdminPage")) {
      HttpSession session = request.getSession(true);
      User user = (User) session.getAttribute("user");
      request.setAttribute("user", user);
      RequestDispatcher dispatcher =
          request.getRequestDispatcher(JSPPageName.USER_ADMIN_PROFILE_PAGE);
      dispatcher.forward(request, response);
    } else if (commandName.equals("goRegistration")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_REGISTER_PAGE);
      dispatcher.forward(request, response);
    } else if (commandName.equals("goClientPage")) {
      HttpSession session = request.getSession(true);
      User user = (User) session.getAttribute("user");
      request.setAttribute("user", user);
      RequestDispatcher dispatcher =
          request.getRequestDispatcher(JSPPageName.USER_CLIENT_PROFILE_PAGE);
      dispatcher.forward(request, response);
    } else if (commandName.equals("goPay")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.PAYMENT_PAGE);
      dispatcher.forward(request, response);
    } else if (commandName.equals("goChangeItemsDetails")) {
      RequestDispatcher dispatcher =
          request.getRequestDispatcher(JSPPageName.CHANGE_ITEM_DETAILS_PAGE);
      dispatcher.forward(request, response);
    }
  };

  protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    String commandName = request.getParameter(RequestParamName.REQ_PARAM_COMMAND_NAME);

    Command command = provider.getCommand(commandName);
    try {
      command.execute(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }

  };

}
