package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.exam.Exam;
import seedu.address.model.person.Score;

public class JsonAdaptedExamTest {

    @Test
    public void toModelType_validExamDetails_returnsExam() throws Exception {
        JsonAdaptedExam exam = new JsonAdaptedExam("Math", "100");
        assertEquals(new Exam("Math", new Score(100)), exam.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedExam exam = new JsonAdaptedExam("", "100");
        assertThrows(IllegalValueException.class, exam::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedExam exam = new JsonAdaptedExam(null, "100");
        assertThrows(IllegalValueException.class, exam::toModelType);
    }

    @Test
    public void toModelType_invalidScore_throwsIllegalValueException() {
        JsonAdaptedExam exam = new JsonAdaptedExam("Math", "-1");
        assertThrows(IllegalValueException.class, exam::toModelType);
    }

    @Test
    public void toModelType_nullScore_throwsIllegalValueException() {
        JsonAdaptedExam exam = new JsonAdaptedExam("Math", null);
        assertThrows(IllegalValueException.class, exam::toModelType);
    }
}
