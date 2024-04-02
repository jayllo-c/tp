package seedu.address.model.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Score;

public class ExamTest {

    @Test
    public void isValidName() {
        assertTrue(Exam.isValidExamName("Midterm")); // alphanumeric characters
        assertTrue(Exam.isValidExamName("Midterm Exam")); // alphanumeric characters with spaces
        assertFalse(Exam.isValidExamName("")); // empty string
        assertFalse(Exam.isValidExamName(" ")); // spaces only
        assertFalse(Exam.isValidExamName("^")); // contains non-alphanumeric characters
        assertFalse(Exam.isValidExamName("Midterm*")); // contains non-alphanumeric characters
    }

    @Test
    public void isValidExamScoreString() {
        assertTrue(Exam.isValidExamScoreString("1")); // positive score
        assertFalse(Exam.isValidExamScoreString("0")); // zero score
        assertFalse(Exam.isValidExamScoreString("-1")); // negative score
        assertFalse(Exam.isValidExamScoreString("")); // empty string
        assertTrue(Exam.isValidExamScoreString("1.2")); // one decimal place
        assertTrue(Exam.isValidExamScoreString("1.23")); // two decimal places
        assertTrue(Exam.isValidExamScoreString("0.1")); // one decimal place w zero
        assertFalse(Exam.isValidExamScoreString("1.")); // no decimal places but with decimal point
        assertFalse(Exam.isValidExamScoreString("1.234")); // three decimal places
        assertFalse(Exam.isValidExamScoreString("1.2345")); // four decimal places

    }

    @Test
    public void isSameExam() {
        Exam exam1 = new Exam("Midterm", new Score(100));
        Exam exam2 = new Exam("Midterm", new Score(100));
        Exam exam3 = new Exam("Final", new Score(100));

        assertTrue(exam1.isSameExam(exam2)); // same name, same score
        assertFalse(exam1.isSameExam(exam3)); // different name, same score
    }

    @Test
    public void equals() {
        Exam exam1 = new Exam("Midterm", new Score(100));
        Exam exam2 = new Exam("Midterm", new Score(100));
        Exam exam3 = new Exam("Final", new Score(100));

        assertEquals(exam1, exam2); // same name, same score
        assertFalse(exam1.equals(exam3)); // different name, same score
    }

    @Test
    public void hashCodeTest() {
        Exam exam = new Exam("Midterm", new Score(100));
        int expectedHashCode = exam.getName().hashCode() + exam.getMaxScore().hashCode();
        assertEquals(expectedHashCode, exam.hashCode());
    }
}
