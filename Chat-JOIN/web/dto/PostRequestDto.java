package efub.insta.web.dto;

import efub.insta.domain.Post;
import efub.insta.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private Long postNo;
    private User user;
    private String content;

    @Builder
    public PostRequestDto(Post entity){
        this.postNo = entity.getPostNo();
        this.user = entity.getUser();
        this.content = entity.getContent();
    }
}
