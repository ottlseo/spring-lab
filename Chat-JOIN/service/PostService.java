package efub.insta.service;

import efub.insta.domain.*;
import efub.insta.dto.LikeDto;
import efub.insta.dto.PostDto;
import efub.insta.dto.UserDto;
import efub.insta.web.dto.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final S3Uploader s3Uploader;

    @Transactional
    public String createPost(PostRequestDto requestDto, MultipartFile uploadFile) throws Exception{
        Post post = new Post(
                requestDto.getUser(),
                requestDto.getContent()
        );

        s3Uploader.upload(uploadFile, post);

        postRepository.save(post);
        return post.getPostNo().toString();
    }

    @Transactional
    public List<PostDto> getPostList(){
        return postRepository.findAll().stream().map(post -> new PostDto(post)).collect(Collectors.toList());
    }

    public List<UserDto> getLikeUserList(Long postNo){
        return likeRepository.findByPostNoAndDeletedFlagFalse(postNo).stream()
                .map(like -> new LikeDto(like).getUserInfo()).collect(Collectors.toList());
    }

    public Long getLikeUserCount(Long postNo){
        return likeRepository.findByPostNoAndDeletedFlagFalse(postNo).stream().count();
    }

    public void updateLike(Long postNo, Long userNo){
        Optional<User> user = userRepository.findById(userNo);
        Like like = likeRepository.findByPostNoAndUser(postNo, user.get());
        if(like == null){
            like = new Like(postNo, user.get());
            likeRepository.save(like);
        }
        else like.likeChange(like);
    }

    /*public List<LikeDto> getLikeUserAllList(){
        return likeRepository.findAll().stream().map(like -> new LikeDto(like)).collect(Collectors.toList());
    }*/
}
