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
import by.epam.tr.service.PaymentService;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.ServiceProvider;

/**
 * 
 * Class - order payment execution command
 *
 */
public class MakePaymentCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(MakePaymentCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher;
    int orderId = Integer.valueOf(request.getParameter(RequestParamName.REQ_PARAM_ORDER_ID));
    String bankCardNum = request.getParameter(RequestParamName.REQ_PARAM_BANK_CARD_NUM);
    String expiringDate = request.getParameter(RequestParamName.REQ_PARAM_EXPIRING_DATE);

    PaymentService paymentService = ServiceProvider.getServiceprovider().getPaymentService();
    try {
      paymentService.makePayment(orderId, bankCardNum, expiringDate);
      dispatcher = request.getRequestDispatcher(JSPPageName.PAYMENT_SUCCESS_PAGE);
      dispatcher.forward(request, response);
    } catch (ServiceException e) {
      if (e.getMessage().equals("Wrong payment data")) {
        dispatcher = request.getRequestDispatcher(JSPPageName.WRONG_DATA_PAGE);
        dispatcher.forward(request, response);
      }
      LOGGER.error(e.getMessage());
    }
  }
}
