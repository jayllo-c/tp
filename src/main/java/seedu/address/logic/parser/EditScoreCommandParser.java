package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SCORE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditScoreCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Score;

/**
 * Parses input arguments and creates a new EditScoreCommand object.
 */
public class EditScoreCommandParser implements Parser<EditScoreCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditScoreCommand
     * and returns an EditScoreCommand object for execution.
     *
     * @return EditScoreCommand object with relevant parameters.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public EditScoreCommand parse(String args) throws ParseException {
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(args, PREFIX_SCORE);

        if (argumentMultimap.getPreamble().isEmpty() || !argumentMultimap.getValue(PREFIX_SCORE).isPresent()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditScoreCommand.MESSAGE_USAGE));
        }

        argumentMultimap.verifyNoDuplicatePrefixesFor(PREFIX_SCORE);

        Index index = ParserUtil.parseIndex(argumentMultimap.getPreamble());
        Score score = ParserUtil.parseScore(argumentMultimap.getValue(PREFIX_SCORE).get());

        return new EditScoreCommand(index, score);
    }
}
