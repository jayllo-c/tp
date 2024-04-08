package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.isAnyNonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.exam.Exam;
import seedu.address.model.person.Person;
import seedu.address.model.person.Score;

/**
 * Deletes a score of currently selected test for a person in the address book.
 */
public class DeleteScoreCommand extends Command {

    public static final String COMMAND_WORD = "deleteScore";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the score of the person identified by the index number used in the displayed person list. \n"
            + "Parameter: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted score for %s(%s) for %s.";
    public static final String MESSAGE_NO_EXAM_SCORE_TO_DELETE = "%s(%s) does not have a score to delete. ";

    private final Index index;

    /**
     * Creates a DeleteScoreCommand object to delete the specified score to the person at the specified {@code Index}.
     */
    public DeleteScoreCommand(Index index) {
        requireNonNull(index);
        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> filteredPersons = model.getFilteredPersonList();

        if (index.getZeroBased() >= filteredPersons.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Exam selectedExam = model.getSelectedExam().getValue();
        if (!isAnyNonNull(selectedExam)) {
            throw new CommandException(Messages.MESSAGE_NO_EXAM_SELECTED);
        }

        Person personWithScoreToDelete = filteredPersons.get(index.getZeroBased());
        Map<Exam, Score> scores = new HashMap<>(personWithScoreToDelete.getScores());

        if (!scores.containsKey(selectedExam)) {
            throw new CommandException(String.format(MESSAGE_NO_EXAM_SCORE_TO_DELETE,
                    personWithScoreToDelete.getName(),
                    personWithScoreToDelete.getEmail()));
        }

        model.removeExamScoreFromPerson(personWithScoreToDelete, selectedExam);
        return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS,
                personWithScoreToDelete.getName(),
                personWithScoreToDelete.getEmail(),
                selectedExam.getName()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof DeleteScoreCommand)) {
            return false;
        }

        DeleteScoreCommand otherDeleteScoreCommand = (DeleteScoreCommand) other;
        return index.equals(otherDeleteScoreCommand.index);
    }
}
