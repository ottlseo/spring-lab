package efub.insta.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import efub.insta.domain.Like;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LikeDto {
    private Long likeNo;
    private Long postNo;
    private UserDto userInfo;
    private Boolean deletedFlag;

    @Builder
    public LikeDto(Like like){
        this.likeNo = like.getLikeNo();
        this.postNo = like.getPostNo();
        this.deletedFlag = like.getDeletedFlag();
        this.userInfo = UserDto.builder()
                .userNo(like.getUser().getUserNo())
                .userId(like.getUser().getUserId())
                .fileSize(like.getUser().getFileSize())
                .originalFileName(like.getUser().getOriginalFileName())
                .filePath(like.getUser().getFilePath())
                .build();
    }
}
