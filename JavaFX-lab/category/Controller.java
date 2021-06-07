package category;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Controller {
    Model model = new Model();
    @FXML
    Button genre, menu;

    @FXML
    private void goGenre(ActionEvent event) {
        Stage stage = (Stage)genre.getScene().getWindow();
        try {
            Parent next = FXMLLoader.load(getClass().getResource("genre.fxml"));
            Scene sc = new Scene(next);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void genre(ActionEvent event) {
        model.genre_sql(((Button)event.getSource()).getText());
    }

    @FXML
    private void commercial(ActionEvent event) {
        model.category_sql("상업");
    }

    @FXML
    private void independent(ActionEvent event) {
        model.category_sql("독립");
    }

    @FXML
    private void goMenu(ActionEvent event) {
        Stage stage = (Stage)menu.getScene().getWindow();
        try {
            Parent next = FXMLLoader.load(getClass().getResource("../main.fxml"));
            Scene sc = new Scene(next);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
