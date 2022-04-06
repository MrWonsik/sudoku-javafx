package JavaFx;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class Controller3x3 {

    @FXML
    private GridPane grill00 = new GridPane();

    @FXML
    private GridPane grill01 = new GridPane();

    @FXML
    private GridPane grill02 = new GridPane();

    @FXML
    private GridPane grill10 = new GridPane();

    @FXML
    private GridPane grill11 = new GridPane();

    @FXML
    private GridPane grill12 = new GridPane();

    @FXML
    private GridPane grill20 = new GridPane();

    @FXML
    private GridPane grill21 = new GridPane();

    @FXML
    private GridPane grill22 = new GridPane();

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

    public GridPane getGrill02() {
        return grill02;
    }

    public void setGrill02(GridPane grill02) {
        this.grill02 = grill02;
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

    public GridPane getGrill12() {
        return grill12;
    }

    public void setGrill12(GridPane grill12) {
        this.grill12 = grill12;
    }

    public GridPane getGrill20() {
        return grill20;
    }

    public void setGrill20(GridPane grill20) {
        this.grill20 = grill20;
    }

    public GridPane getGrill21() {
        return grill21;
    }

    public void setGrill21(GridPane grill21) {
        this.grill21 = grill21;
    }

    public GridPane getGrill22() {
        return grill22;
    }

    public void setGrill22(GridPane grill22) {
        this.grill22 = grill22;
    }

    public GridPane[][] getGrills(){
        GridPane[][] gridPanes = new GridPane[][] {{grill00, grill01, grill02}, {grill10, grill11, grill12}, {grill20, grill21, grill22}};
        return gridPanes;
    }
}
