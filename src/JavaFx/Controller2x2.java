package JavaFx;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class Controller2x2 {
    @FXML
    private GridPane grill00 = new GridPane();

    @FXML
    private GridPane grill01 = new GridPane();

    @FXML
    private GridPane grill10 = new GridPane();

    @FXML
    private GridPane grill11 = new GridPane();

    public Controller2x2() {

    }

    public GridPane getGrill00() {
        return grill00;
    }

    public void setGrill00(GridPane grill00) {
        this.grill00 = grill00;
    }

    public GridPane getGrill01() {
        return grill01;
    }

    public void setGrill01(GridPane grill01) {
        this.grill01 = grill01;
    }

    public GridPane getGrill10() {
        return grill10;
    }

    public void setGrill10(GridPane grill10) {
        this.grill10 = grill10;
    }

    public GridPane getGrill11() {
        return grill11;
    }

    public void setGrill11(GridPane grill11) {
        this.grill11 = grill11;
    }
}
