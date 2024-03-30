package seedu.address.ui;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.exam.Exam;

/**
 * An UI component that displays information of a {@code Exam}.
 */
public class ExamCard extends UiPart<Region> {

    private static final String FXML = "ExamListCard.fxml";

    public final Exam exam;

    @FXML
    private HBox examCardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label maxScore;

    /**
     * Creates a {@code ExamCard} with the given {@code Exam} and index to display.
     */
    public ExamCard(Exam exam, int displayedIndex, ObservableValue<Exam> selectedExam) {
        super(FXML);
        this.exam = exam;
        id.setText(displayedIndex + ". ");
        name.setText(exam.getName());
        maxScore.setText(String.valueOf(exam.getMaxScore()));

        if (this.exam.equals(selectedExam.getValue())) {
            highlight();
        } else {
            removeHighlight();
        }
    }

    public void highlight() {
        examCardPane.setStyle("-fx-background-color: #3884a1;");
    }

    public void removeHighlight() {
        examCardPane.setStyle("-fx-background-color: transparent;");
    }
}
