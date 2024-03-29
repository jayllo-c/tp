package seedu.address.ui;

import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.logic.Logic;
import seedu.address.model.exam.Exam;

/**
 * A ui for the status bar that is displayed at the footer of the application.
 */
public class StatusBarFooter extends UiPart<Region> {

    private static final String FXML = "StatusBarFooter.fxml";

    @FXML
    private Label saveLocationStatus;
    @FXML
    private Label gradeStatistics;
    private Logic logic;

    /**
     * Creates a {@code StatusBarFooter} with the given {@code Path}.
     */
    public StatusBarFooter(Path saveLocation, Logic logic) {
        super(FXML);
        saveLocationStatus.setText(Paths.get(".").resolve(saveLocation).toString());
        this.logic = logic;
    }

    public void update() {
        Exam selectedExam = logic.getSelectedExam().getValue();
        if (selectedExam == null) {
            gradeStatistics.setText("");
        } else {
            gradeStatistics.setText(logic.getExamScoreStatistics(selectedExam).toString());
        }
    }

}
