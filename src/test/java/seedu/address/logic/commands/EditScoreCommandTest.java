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

class EditScoreCommandTest {

    @Test
    public void constructor_nullScore_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new EditScoreCommand(null, null));
    }

    @Test
    public void execute_validIndexAndScore_success() throws CommandException {
        Model model = new ModelManager();
        Exam validExam = new Exam("mock exam", new Score(100));
        Score validInitialScore = new Score(17);
        Score validFinalScore = new Score(13);
        Map<Exam, Score> validInitialExamScore = new HashMap<>();
        validInitialExamScore.put(validExam, validInitialScore);
        Person validPerson = new PersonBuilder().withScores(validInitialExamScore).build();
        model.addPerson(validPerson);
        model.addExam(validExam);
        model.selectExam(validExam);
        Index validIndex = Index.fromZeroBased(model.getFilteredPersonList().size() - 1);
        CommandResult commandResult = new EditScoreCommand(validIndex, validFinalScore).execute(model);

        String expectedMessage = String.format(EditScoreCommand.MESSAGE_EDIT_SCORE_SUCCESS, validExam.getName(),
                validFinalScore, validPerson.getName(), validPerson.getEmail());

        assertEquals(expectedMessage, commandResult.getFeedbackToUser());

        Map<Exam, Score> expectedExamScore = new HashMap<>();
        expectedExamScore.put(validExam, validFinalScore);
        assertEquals(expectedExamScore, model.getFilteredPersonList().get(validIndex.getZeroBased()).getScores());
    }

    @Test
    public void execute_invalidIndex_throwsCommandException() {
        Model model = new ModelManager();
        Exam validExam = new Exam("mock exam", new Score(100));
        Score validScore = new Score(17);
        Map<Exam, Score> validInitialExamScore = new HashMap<>();
        validInitialExamScore.put(validExam, validScore);
        Person validPerson = new PersonBuilder().withScores(validInitialExamScore).build();
        model.addPerson(validPerson);
        model.addExam(validExam);
        model.selectExam(validExam);
        Index invalidIndex = Index.fromZeroBased(model.getFilteredPersonList().size());

        EditScoreCommand command = new EditScoreCommand(invalidIndex, validScore);
        assertThrows(CommandException.class, () -> command.execute(model));
    }

    @Test
    public void execute_noExamSelected_throwsCommandException() {
        Model model = new ModelManager();
        Exam validExam = new Exam("mock exam", new Score(100));
        Score validScore = new Score(17);
        Map<Exam, Score> validInitialExamScore = new HashMap<>();
        validInitialExamScore.put(validExam, validScore);
        Person validPerson = new PersonBuilder().withScores(validInitialExamScore).build();
        model.addPerson(validPerson);
        model.addExam(validExam);
        Index validIndex = Index.fromZeroBased(model.getFilteredPersonList().size() - 1);

        EditScoreCommand command = new EditScoreCommand(validIndex, validScore);
        assertThrows(CommandException.class, () -> command.execute(model));
    }

    @Test
    public void execute_newScoreLargerThanMaxScore_throwsCommandException() {
        Model model = new ModelManager();
        Exam exam = new Exam("mock exam", new Score(100));
        Score oldScore = new Score(17);
        Map<Exam, Score> initialExamScore = new HashMap<>();
        initialExamScore.put(exam, oldScore);
        Person validPerson = new PersonBuilder().withScores(initialExamScore).build();
        model.addPerson(validPerson);
        model.addExam(exam);
        model.selectExam(exam);
        Index validIndex = Index.fromZeroBased(model.getFilteredPersonList().size() - 1);

        Score invalidNewScore = new Score(150);
        EditScoreCommand command = new EditScoreCommand(validIndex, invalidNewScore);
        assertThrows(CommandException.class, () -> command.execute(model));
    }

    @Test
    public void execute_noInitialScore_throwsCommandException() {
        Model model = new ModelManager();
        Person validPerson = new PersonBuilder().build();
        Exam exam = new Exam("mock exam", new Score(100));
        Score score = new Score(17);
        model.addPerson(validPerson);
        model.addExam(exam);
        model.selectExam(exam);
        Index validIndex = Index.fromZeroBased(model.getFilteredPersonList().size() - 1);

        EditScoreCommand command = new EditScoreCommand(validIndex, score);
        assertThrows(CommandException.class, () -> command.execute(model));
    }

}
