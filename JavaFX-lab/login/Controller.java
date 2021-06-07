package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    TextField idField;

    @FXML
    private void idEnter(ActionEvent event) {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        try {
            String nickName = idField.getText();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../like/like.fxml"));
            Parent next = (Parent) loader.load();
            Scene sc = new Scene(next);
            like.Controller likeController = loader.getController();
            likeController.setNickname(nickName);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}