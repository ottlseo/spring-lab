package efub.insta.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "\"like\"")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeNo;

    @Column
    private Long postNo;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @Column
    private Boolean deletedFlag;

    @Builder
    public Like(Long postNo, User user){
        this.postNo = postNo;
        this.user = user;
        deletedFlag = false;
    }

    public Like likeChange(Like likeDto){
        boolean flag = !likeDto.getDeletedFlag();
        Like like = likeDto;
        like.setDeletedFlag(flag);

        return like;
    }
}
