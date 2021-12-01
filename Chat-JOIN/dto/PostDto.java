package efub.insta.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import efub.insta.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostDto {
    private Long postNo;
    private UserDto userInfo;
    private String content;
    private Long fileSize;
    private String originalFileName;
    private String filePath;

    @Builder
    public PostDto(Post post){
        this.postNo = post.getPostNo();
        this.content = post.getContent();
        this.fileSize = post.getFileSize();
        this.originalFileName = post.getOriginalFileName();
        this.filePath = post.getFilePath();
        this.userInfo = UserDto.builder()
                .userNo(post.getUser().getUserNo())
                .userId(post.getUser().getUserId())
                .fileSize(post.getUser().getFileSize())
                .originalFileName(post.getUser().getOriginalFileName())
                .filePath(post.getUser().getFilePath())
                .build();
    }
}
