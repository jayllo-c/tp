package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteScoreCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteScoreCommand object.
 */
public class DeleteScoreCommandParser implements Parser<DeleteScoreCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteScoreCommand
     * and returns a DeleteScoreCommand object for execution.
     * @throws if the user input does not conform the expected format.
     */
    public DeleteScoreCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeleteScoreCommand(index);
        } catch (ParseException e) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteScoreCommand.MESSAGE_USAGE), e);
        }
    }
}
