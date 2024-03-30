package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.exam.Exam;
import seedu.address.model.person.Person;
import seedu.address.model.person.Score;
import seedu.address.testutil.PersonBuilder;

class DeleteScoreCommandTest {

    @Test
    public void constructor_nullIndex_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DeleteScoreCommand(null));
    }

    @Test
    public void execute_validIndex_success() throws CommandException {
        Model model = new ModelManager();
        Exam validExam = new Exam("mock exam", new Score(100));
        Score validScore = new Score(17);
        Map<Exam, Score> validExamScore = new HashMap<>();
        validExamScore.put(validExam, validScore);
        Person validPerson = new PersonBuilder().withScores(validExamScore).build();

        model.addPerson(validPerson);
        model.addExam(validExam);
        model.selectExam(validExam);

        Index validIndex = Index.fromZeroBased(model.getFilteredPersonList().size() - 1);
        CommandResult commandResult = new DeleteScoreCommand(validIndex).execute(model);

        assertEquals(String.format(DeleteScoreCommand.MESSAGE_DELETE_PERSON_SUCCESS,
                validPerson.getName(),
                validPerson.getEmail(),
                validExam.getName()),
                commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_invalidIndex_throwsCommandException() {
        Model model = new ModelManager();
        Exam validExam = new Exam("mock exam", new Score(100));
        Score validScore = new Score(17);
        Map<Exam, Score> validExamScore = new HashMap<>();
        validExamScore.put(validExam, validScore);
        Person validPerson = new PersonBuilder().withScores(validExamScore).build();

        model.addPerson(validPerson);
        model.addExam(validExam);
        model.selectExam(validExam);

        Index invalidIndex = Index.fromZeroBased(model.getFilteredPersonList().size());

        DeleteScoreCommand command = new DeleteScoreCommand(invalidIndex);
        assertThrows(CommandException.class, () -> command.execute(model));
    }

    @Test
    public void execute_withNoExamSelected_throwsCommandException() {
        Model model = new ModelManager();
        Exam validExam = new Exam("mock exam", new Score(100));
        Score validScore = new Score(17);
        Map<Exam, Score> validExamScore = new HashMap<>();
        validExamScore.put(validExam, validScore);
        Person validPerson = new PersonBuilder().withScores(validExamScore).build();

        model.addPerson(validPerson);
        model.addExam(validExam);

        Index validIndex = Index.fromZeroBased(model.getFilteredPersonList().size() - 1);

        DeleteScoreCommand command = new DeleteScoreCommand(validIndex);
        assertThrows(CommandException.class, () -> command.execute(model));
    }

    @Test
    public void execute_noExamScoreToDelete_throwsCommandException() {
        Model model = new ModelManager();
        Exam validExam = new Exam("mock exam", new Score(100));
        Person validPerson = new PersonBuilder().build();

        model.addPerson(validPerson);
        model.addExam(validExam);
        model.selectExam(validExam);

        Index validIndex = Index.fromZeroBased(model.getFilteredPersonList().size() - 1);

        DeleteScoreCommand command = new DeleteScoreCommand(validIndex);
        assertThrows(CommandException.class, () -> command.execute(model));
    }
}
