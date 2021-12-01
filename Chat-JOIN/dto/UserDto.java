package efub.insta.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class UserDto {
    private Long userNo;
    private String userId;
    private Long fileSize;
    private String originalFileName;
    private String filePath;
}
