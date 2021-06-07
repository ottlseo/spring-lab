import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Controller {
    @FXML
    Button chartButton, categoryButton, awardButton, likeMovieButton, searchButton;

    @FXML
    private void goChart(ActionEvent event) {
        Stage stage = (Stage)chartButton.getScene().getWindow();
        try {
            Parent next = FXMLLoader.load(getClass().getResource("./chart/chart_main.fxml"));
            Scene sc = new Scene(next);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goCategory(ActionEvent event) {
        Stage stage = (Stage)categoryButton.getScene().getWindow();
        try {
            Parent next = FXMLLoader.load(getClass().getResource("./category/category.fxml"));
            Scene sc = new Scene(next);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goSearch(ActionEvent event) {
        Stage stage = (Stage)searchButton.getScene().getWindow();
        try {
            Parent next = FXMLLoader.load(getClass().getResource("./search/search_main.fxml"));
            Scene sc = new Scene(next);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goLikes(ActionEvent event) {
        Stage stage = (Stage)likeMovieButton.getScene().getWindow();
        try {
            Parent next = FXMLLoader.load(getClass().getResource("login/login.fxml")); //먼저 로그인하도록
            Scene sc = new Scene(next);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goAwards(ActionEvent event) {
        Stage stage = (Stage)awardButton.getScene().getWindow();
        try {
            Parent next = FXMLLoader.load(getClass().getResource("./watchagain/watchagain.fxml"));
            Scene sc = new Scene(next);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
