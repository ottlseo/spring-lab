package efub.insta.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNo;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @Column
    private String content;

    @Column
    private Long fileSize;

    @Column
    private String originalFileName;

    @Column
    private String filePath;

    @Builder
    public Post(User user, String content){
        this.user = user;
        this.content = content;
    }

    public void updateImage(Long fileSize, String originalFileName, String filePath){
        this.fileSize = fileSize;
        this.originalFileName = originalFileName;
        this.filePath = filePath;
    }
}
