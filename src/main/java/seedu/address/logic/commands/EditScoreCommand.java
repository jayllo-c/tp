package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.isAnyNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SCORE;

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
 * Edits a score of a person in the address book.
 */
public class EditScoreCommand extends Command {

    public static final String COMMAND_WORD = "editScore";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the score for the person identified by "
            + "the index number used in the displayed person list. "
            + "Existing values will be overwritten by the input value.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_SCORE + "SCORE\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_SCORE + "17";

    public static final String MESSAGE_SCORE_GREATER_THAN_MAX =
            "Score for %s cannot be greater than the maximum score.";

    private final Index index;
    private final Score score;

    /**
     * Creates an EditScoreCommand object to edit the specified {@code Score} of the person at
     * the specified {@code Index}.
     */
    public EditScoreCommand(Index index, Score score) {
        requireNonNull(index);
        requireNonNull(score);

        this.index = index;
        this.score = score;
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

        if (selectedExam.getMaxScore().getScore() < score.getScore()) {
            throw new CommandException(String.format(MESSAGE_SCORE_GREATER_THAN_MAX, selectedExam.getName()));
        }

        Person personToEdit = filteredPersons.get(index.getZeroBased());

        Map<Exam, Score> updatedScores = new HashMap<>(personToEdit.getScores());
        updatedScores.put(selectedExam, score);

        Person editedPerson = createEditedPerson(personToEdit, updatedScores);

        model.setPerson(personToEdit, editedPerson);
        return new CommandResult(String.format("Edited score for %s for %s", score, editedPerson.getName()));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit} and the updated scores map.
     */
    private static Person createEditedPerson(Person personToEdit, Map<Exam, Score> updatedScores) {
        return new Person(
                personToEdit.getName(),
                personToEdit.getPhone(),
                personToEdit.getEmail(),
                personToEdit.getAddress(),
                personToEdit.getTags(),
                personToEdit.getMatric(),
                personToEdit.getReflection(),
                personToEdit.getStudio(),
                updatedScores
        );
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof EditScoreCommand
                && index.equals(((EditScoreCommand) other).index)
                && score.equals(((EditScoreCommand) other).score));
    }
}
