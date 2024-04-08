package seedu.address.storage;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.model.exam.Exam;
import seedu.address.model.person.Score;

/**
 * Jackson-friendly version of {@link Exam}.
 */
public class JsonAdaptedExamScore {
    private final String examName;
    private final String examMaxScore;
    private final String score;

    /**
     * Constructs a {@code JsonAdaptedExamScore} with the given exam details.
     */
    @JsonCreator
    public JsonAdaptedExamScore(@JsonProperty("examName") String examName,
                                @JsonProperty("examMaxScore") String examMaxScore,
                                @JsonProperty("score") String score) {
        this.examName = examName;
        this.examMaxScore = examMaxScore;
        this.score = score;
    }

    /**
     * Converts a given {@code Exam} into this class for Jackson use.
     */
    public JsonAdaptedExamScore(Exam source, Score score) {
        examName = source.getName();
        examMaxScore = Double.toString(source.getMaxScore().getScore());
        this.score = Double.toString(score.getScore());
    }

    /**
     * Converts a given {@code Exam} into this class for Jackson use.
     */
    public Exam toModelTypeExam() throws IllegalValueException {
        return new Exam(ParserUtil.parseExamName(examName), ParserUtil.parseExamScore(examMaxScore));
    }

    /**
     * Converts a given {@code Score} into this class for Jackson use.
     */
    public Score toModelTypeScore() throws IllegalValueException {
        return ParserUtil.parseScore(score);
    }
}
