package by.epam.tr.controller.command;

import java.util.HashMap;
import java.util.Map;
import by.epam.tr.controller.command.impl.AddItemCommand;
import by.epam.tr.controller.command.impl.AddItemToCartCommand;
import by.epam.tr.controller.command.impl.AddToBlacklistCommand;
import by.epam.tr.controller.command.impl.AuthorizationCommand;
import by.epam.tr.controller.command.impl.ChangeItemsDetailsCommand;
import by.epam.tr.controller.command.impl.DeleteItemCommand;
import by.epam.tr.controller.command.impl.DeleteItemFromCartCommand;
import by.epam.tr.controller.command.impl.ExitCommand;
import by.epam.tr.controller.command.impl.MakeOrderCommand;
import by.epam.tr.controller.command.impl.MakePaymentCommand;
import by.epam.tr.controller.command.impl.NoSuchCommand;
import by.epam.tr.controller.command.impl.RegistrationCommand;
import by.epam.tr.controller.command.impl.ShowCartCommand;
import by.epam.tr.controller.command.impl.ShowCatalogCommand;
import by.epam.tr.controller.command.impl.ShowOrderListCommand;
import by.epam.tr.controller.command.impl.ShowPaymentEvaderListCommand;
import by.epam.tr.controller.command.impl.go.GoAddItemCommand;
import by.epam.tr.controller.command.impl.go.GoAdminPageCommand;
import by.epam.tr.controller.command.impl.go.GoAuthorizationCommand;
import by.epam.tr.controller.command.impl.go.GoChangeItemsDetailsCommand;
import by.epam.tr.controller.command.impl.go.GoClientPageCommand;
import by.epam.tr.controller.command.impl.go.GoPayCommand;
import by.epam.tr.controller.command.impl.go.GoRegistrationCommand;

/**
 * 
 * The explorer class redirects to a specific command in accordance with the request
 *
 */
public class CommandProvider {
  private static final CommandProvider commandProvider = new CommandProvider();
  private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

  public CommandProvider() {
    commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
    commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
    commands.put(CommandName.REGISTRATION, new RegistrationCommand());
    commands.put(CommandName.EXIT, new ExitCommand());
    commands.put(CommandName.ADD_TO_CART, new AddItemToCartCommand());
    commands.put(CommandName.MAKE_ORDER, new MakeOrderCommand());
    commands.put(CommandName.MAKE_PAYMENT, new MakePaymentCommand());
    commands.put(CommandName.ADD_ITEM, new AddItemCommand());
    commands.put(CommandName.ADD_TO_BLACKLIST, new AddToBlacklistCommand());
    commands.put(CommandName.CHANGE_ITEM_DETAILS, new ChangeItemsDetailsCommand());
    commands.put(CommandName.DELETE_FROM_CART, new DeleteItemFromCartCommand());
    commands.put(CommandName.DELETE_ITEM, new DeleteItemCommand());
    commands.put(CommandName.SHOW_CATALOG, new ShowCatalogCommand());
    commands.put(CommandName.SHOW_CART, new ShowCartCommand());
    commands.put(CommandName.SHOW_PAY_EVADERS_LIST, new ShowPaymentEvaderListCommand());
    commands.put(CommandName.SHOW_ORDER_LIST, new ShowOrderListCommand());
    commands.put(CommandName.GO_ADD_ITEM, new GoAddItemCommand());
    commands.put(CommandName.GO_ADMIN_PROFILE, new GoAdminPageCommand());
    commands.put(CommandName.GO_AUTHORIZATION, new GoAuthorizationCommand());
    commands.put(CommandName.GO_CHANGE_ITEMS_DETAILS, new GoChangeItemsDetailsCommand());
    commands.put(CommandName.GO_CLIENT_PROFILE, new GoClientPageCommand());
    commands.put(CommandName.GO_PAY, new GoPayCommand());
    commands.put(CommandName.GO_REGISTRATION, new GoRegistrationCommand());
  }

  public Command getCommand(String commandName) {
    CommandName nameCommand = CommandName.valueOf(commandName.toUpperCase());
    Command command;
    if (null != nameCommand) {
      command = commands.get(nameCommand);
    } else {
      command = commands.get(CommandName.NO_SUCH_COMMAND);
    }
    return command;
  }

  public static CommandProvider getInstance() {
    return commandProvider;
  }
}