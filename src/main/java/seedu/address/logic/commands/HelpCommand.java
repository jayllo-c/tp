package seedu.address.logic.commands;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {
    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;
    public static final String SHOWING_HELP_MESSAGE =
            "Copied user guide link to clipboard. Open the link in a browser to view it.";
    private static final StringSelection USER_GUIDE_URL =
            new StringSelection("https://ay2324s2-cs2103t-t10-1.github.io/tp/UserGuide.html");

    private void copyToClipboard(StringSelection stringSelection) {
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
    }

    @Override
    public CommandResult execute(Model model) {
        copyToClipboard(USER_GUIDE_URL);
        return new CommandResult(SHOWING_HELP_MESSAGE, false, false);
    }
}
