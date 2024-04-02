package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.exam.Exam;
import seedu.address.model.person.Score;

class JsonAdaptedExam {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Exam's %s field is missing!";

    private final String name;
    private final String maxScore;

    /**
     * Constructs a {@code JsonAdaptedExam} with the given {@code name}.
     */
    @JsonCreator
    public JsonAdaptedExam(@JsonProperty("name") String name, @JsonProperty("score") String maxScore) {
        this.name = name;
        this.maxScore = maxScore;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedExam(Exam source) {
        name = source.getName();
        maxScore = source.getMaxScore().toString();
    }

    public String getname() {
        return name;
    }

    public String getMaxScore() {
        return maxScore;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Exam toModelType() throws IllegalValueException {

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "name"));
        }
        if (Exam.isValidExamName(name) == false) {
            throw new IllegalValueException(Exam.MESSAGE_CONSTRAINTS);
        }
        if (maxScore == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "maxScore"));
        }
        if (Exam.isValidExamScoreString(maxScore) == false) {
            throw new IllegalValueException(Exam.MESSAGE_CONSTRAINTS);
        }

        final String modelName = this.name;
        final Score modelMaxScore = new Score(Double.parseDouble(this.maxScore));

        return new Exam(modelName, modelMaxScore);
    }
}
