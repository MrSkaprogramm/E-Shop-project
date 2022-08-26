package by.epam.tr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.epam.tr.controller.command.Command;
import by.epam.tr.controller.command.CommandProvider;

/**
 * 
 * Servlet class
 *
 */
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
    doPost(request, response);
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
