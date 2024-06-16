package ottl.crud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User{
    private int userNo;
    private String userName;
    private String userId;
    private String userPassword;

    public User(){
    }
    public User(int userNo, String userName, String userId, String userPassword){
        this.userNo = userNo;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
}