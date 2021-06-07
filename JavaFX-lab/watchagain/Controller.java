package watchagain;


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
    Button festival, now, award, menu;

    @FXML
    private void byFestival(ActionEvent event) {
        Stage stage = (Stage)festival.getScene().getWindow();
        try {
            Parent next = FXMLLoader.load(getClass().getResource("filmfestival.fxml"));
            Scene sc = new Scene(next);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void nowShowing(ActionEvent event) { // 현재 상영 중인 영화 조회
        model.printNowShowing();
    }

    @FXML
    private void byAward(ActionEvent event) { // 수상 부문별 조회
        Stage stage = (Stage)festival.getScene().getWindow();
        try {
            Parent next = FXMLLoader.load(getClass().getResource("awards.fxml"));
            Scene sc = new Scene(next);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchByFestival(ActionEvent event) {
        String festivalName = ((Button)event.getSource()).getText();
        // 영화제 별로 조회하기
        model.searchByFestival(festivalName);
    }

    @FXML
    private void awardType(ActionEvent event) {
        String awardName = ((Button)event.getSource()).getText();
        // awardName으로 조회하기
        model.searchByAward(awardName);
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
