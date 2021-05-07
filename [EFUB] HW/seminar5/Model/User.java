package yoonseo.seminar5.Model;

public class User {
    private int userNo;
    private String userName;
    private String userId;
    private String userPassword;  //속성들 정의

    /* 생성자 */
    public User(int userNo, String userName, String userId, String userPassword){
        this.userNo = userNo;
        this.userName = userName;
        this.userId = userId;
        this.userPassword = userPassword;
    }

    /* Alt+Insert 눌러 Getter/Setter 생성 */
    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
