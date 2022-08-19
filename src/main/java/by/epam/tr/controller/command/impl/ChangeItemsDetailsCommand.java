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

public class ChangeItemsDetailsCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(ChangeItemsDetailsCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int itemId = Integer.valueOf(request.getParameter(RequestParamName.REQ_PARAM_ITEM_ID));
    String itemInfo = request.getParameter(RequestParamName.REQ_PARAM_ITEM_INFO);
    int price = Integer.valueOf(request.getParameter(RequestParamName.REQ_PARAM_ITEM_PRICE));

    ItemService itemService = ServiceProvider.getServiceprovider().getItemService();

    try {
      itemService.changeItemsDetails(itemId, itemInfo, price);
      RequestDispatcher dispatcher =
          request.getRequestDispatcher(JSPPageName.CHANGE_ITEM_DETAILS_SUCCESS_PAGE);
      dispatcher.forward(request, response);
    } catch (ServiceException e) {
      LOGGER.error(e.getMessage());
    }
  }
}
