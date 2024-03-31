package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ImportExamScoresCommand;

public class ImportExamScoresCommandParserTest {
    private ImportExamScoresCommandParser parser = new ImportExamScoresCommandParser();

    @Test
    public void parse_noArgsPassed_failure() {
        assertParseFailure(
                parser, "importExamScores i/",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ImportExamScoresCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_notCsvFile_failure() {
        assertParseFailure(
                parser, "importExamScores i/file.json",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ImportExamScoresCommand.MESSAGE_USAGE));
    }
}
