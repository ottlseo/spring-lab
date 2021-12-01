package efub.insta.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import efub.insta.dto.LikeDto;
import efub.insta.dto.PostDto;
import efub.insta.dto.UserDto;
import efub.insta.service.PostService;
import efub.insta.web.dto.PostRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class PostController {

    @Autowired
    PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/postList")
    public List<PostDto> getPostList(){
        return postService.getPostList();
    }

    @GetMapping("{postNo}/likeList")
    public List<UserDto> getLikeUser(@PathVariable("postNo") Long postNo){
        return postService.getLikeUserList(postNo);
    }

    @GetMapping("{postNo}/likeListCount")
    public Long getLikeCount(@PathVariable("postNo") Long postNo){
        return postService.getLikeUserCount(postNo);
    }

    @PatchMapping("/{postNo}/{userNo}/like")
    public ResponseEntity<String> likePost(@PathVariable("postNo") Long postNo, @PathVariable("userNo") Long userNo){
        postService.updateLike(postNo, userNo);
        return ResponseEntity.ok("ok");
    }


    @PostMapping("api/posts")
    public String createPost(@RequestParam(value = "image") MultipartFile image,
                             @RequestParam(value = "requestDto") String requestDtoString) throws Exception{
        PostRequestDto requestDto = new ObjectMapper().readValue(requestDtoString, PostRequestDto.class);
        String postNo = postService.createPost(requestDto, image);
        return postNo;
    }

    /*테스트용 좋아요 테이블 전체 출력
    @GetMapping("/likeList")
    public List<LikeDto> getLikeList(){
        return postService.getLikeUserAllList();
    }*/
}