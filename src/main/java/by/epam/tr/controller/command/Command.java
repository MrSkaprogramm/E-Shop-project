package by.epam.tr.controller.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Interface containing methods of all program commands
 *
 */
public interface Command {
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException;
}
