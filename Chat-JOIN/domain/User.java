package efub.insta.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column
    private String userId;

    @Column
    private Long fileSize;

    @Column
    private String originalFileName;

    @Column
    private String filePath;

}