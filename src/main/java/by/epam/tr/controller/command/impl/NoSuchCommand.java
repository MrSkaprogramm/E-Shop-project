package by.epam.tr.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.tr.controller.command.Command;

public class NoSuchCommand implements Command {
  private static final Logger LOGGER = LogManager.getLogger(NoSuchCommand.class);

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) {
    // TODO Auto-generated method stub

  }

}
