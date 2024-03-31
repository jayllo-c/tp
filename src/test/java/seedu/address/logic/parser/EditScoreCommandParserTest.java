package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SCORE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.EditScoreCommand;
import seedu.address.model.person.Score;

public class EditScoreCommandParserTest {

    private EditScoreCommandParser parser = new EditScoreCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Index index = Index.fromOneBased(1);
        Score score = new Score(17);

        assertParseSuccess(parser, "1 " + PREFIX_SCORE + "17",
                new EditScoreCommand(index, score));
    }

    @Test
    public void parse_multipleRepeatedFields_failure() {
        assertParseFailure(parser, "1 " + PREFIX_SCORE + "17 " + PREFIX_SCORE + "17",
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_SCORE));
    }

    @Test
    public void parse_invalidScore_failure() {
        String expectedMessage = Score.MESSAGE_CONSTRAINTS;
        assertParseFailure(parser, "1 " + PREFIX_SCORE + "hello", expectedMessage);
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditScoreCommand.MESSAGE_USAGE);

        assertParseFailure(parser, " " + PREFIX_SCORE + "17", expectedMessage);
        assertParseFailure(parser, "1", expectedMessage);
        assertParseFailure(parser, "", expectedMessage);
    }
}
