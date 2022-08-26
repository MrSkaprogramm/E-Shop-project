package by.epam.tr.controller.command.impl;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.tr.bean.Item;
import by.epam.tr.bean.Role;
import by.epam.tr.bean.User;
import by.epam.tr.controller.JSPPageName;
import by.epam.tr.controller.command.Command;
import by.epam.tr.service.ItemService;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.ServiceProvider;

/**
 * 
 * Class - the command to display all products in the catalog
 *
 */
public class ShowCatalogCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(ShowCatalogCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ItemService itemService = ServiceProvider.getServiceprovider().getItemService();
    List<Item> catalog = null;
    
    try {
      catalog = itemService.getAllItems();
    } catch (ServiceException e) {
      LOGGER.error(e.getMessage());
    }
    request.setAttribute("catalog", catalog);

    HttpSession session = request.getSession(true);
    User user = (User) session.getAttribute("user");
    RequestDispatcher dispatcher;

    if (user.getRole() == Role.CLIENT) {
      dispatcher = request.getRequestDispatcher(JSPPageName.CLIENT_CATALOG_PAGE);
    } else {
      dispatcher = request.getRequestDispatcher(JSPPageName.ADMIN_CATALOG_PAGE);
    }
    dispatcher.forward(request, response);
  }
}
