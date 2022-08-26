package by.epam.tr.controller.command.impl.go;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.RequestParamName;
import by.epam.tr.controller.command.Command;

/**
 * 
 * Class - the command to go to the product information change page
 *
 */
public class GoChangeItemsDetailsCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("itemId", request.getParameter(RequestParamName.REQ_PARAM_ITEM_ID));
    RequestDispatcher dispatcher =
        request.getRequestDispatcher(JSPPageName.CHANGE_ITEM_DETAILS_PAGE);
    dispatcher.forward(request, response);
  }
}
