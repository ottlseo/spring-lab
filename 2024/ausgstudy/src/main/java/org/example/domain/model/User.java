package org.example.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userId;

    private String userName;
    private String userPassword;

// --- replaced by @AllArgsConstructor, @NoArgsConstructor
    //    public User() { }
    //
    //    public User(int userNo, String userName, String userId, String userPassword) {
    //        this.userNo = userNo;
    //        this.userName = userName;
    //        this.userId = userId;
    //        this.userPassword = userPassword;
    //    }

}
