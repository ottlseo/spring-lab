package chart;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    private Model model = new Model();
    @FXML
    Button menu;

    // Model에서 받아온 SELECT 결과들 콘솔에 출력
    // 그냥 model 함수 자체가 print 작업해주므로 함수 호출만
    @FXML
    private void printChart(ActionEvent event) {
        model.sort_sql(((Button)event.getSource()).getText());
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