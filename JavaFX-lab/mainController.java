package sample;

import com.sun.webkit.Timer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.text.AsyncBoxView;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller {
    public Model model = new Model(); //함수가 저장되어있는 Model 객체도 생성해줌

    Controller(){ //생성자 -> 필요한 화면 모두 로드
        
        VBox loadLoginPage = new VBox();
        VBox loadMainPage = new VBox();

        try {
            loadLoginPage = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            loadMainPage =  FXMLLoader.load(getClass().getResource("view/main.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    private Text movie_name; // 검색창에 뜨는

    /* //--일단 없애주긴 했는데 다시 만들수도..
    @FXML
    private void initialize() throws IOException { //필요한 화면 모두 로드

        VBox loadLoginPage = new VBox();
        VBox loadMainPage = new VBox();

        loadLoginPage = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        loadMainPage =  FXMLLoader.load(getClass().getResource("view/main.fxml"));
    }
*/
    @FXML
    private void login(ActionEvent event){ //로그인-> 메인화면으로 이동
        Parent main = null;
        try {
            main = FXMLLoader.load(getClass().getResource("View/main.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(main);
        Stage primaryStage = (Stage)btnLogin.getScene().getWindow(); // 현재 윈도우 가져오기
        primaryStage.setScene(scene);

        primaryStage.show();


    }

    private void func1(ActionEvent event){ //영화 순위 보기
        model.show(1);

    }
    private void func2(ActionEvent event){
        model.show(2);
    }
    private void func3(ActionEvent event){

    }
    private void func4(ActionEvent event){

    }
}
