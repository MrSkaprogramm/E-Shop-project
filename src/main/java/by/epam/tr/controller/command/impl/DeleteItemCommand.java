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
import by.epam.tr.service.ItemService;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.ServiceProvider;

public class DeleteItemCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(DeleteItemCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int itemId;
    boolean itemDeleted;
    RequestDispatcher dispatcher;

    itemId = Integer.valueOf(request.getParameter(RequestParamName.REQ_PARAM_ITEM_ID));

    ItemService itemService = ServiceProvider.getServiceprovider().getItemService();

    try {

      itemDeleted = itemService.deleteItem(itemId);

      if (itemDeleted) {
        dispatcher = request.getRequestDispatcher(JSPPageName.DELETE_ITEM_SUCCESS_PAGE);
      } else {
        dispatcher = request.getRequestDispatcher(JSPPageName.DELETE_ITEM_DENIED_PAGE);
      }
      dispatcher.forward(request, response);
    } catch (ServiceException e) {
      LOGGER.error(e.getMessage());
    }
  }
}
