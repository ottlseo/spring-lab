package ottl.hijava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ottl.hijava.domain.Post;
import ottl.hijava.service.PostService;

import java.util.List;

@Controller
public class PostController {
    private final PostService postService; //postService와 연결하려고

    @Autowired //자동으로 연결 (DI)
    public PostController(PostService postService){
        this.postService = postService; //이 컨트롤러와 postService 연결
    }
    @GetMapping("/posts/new") // 홈 화면에서 이동할 페이지와 연동
    public String createForm(){
        return "Posts/createPostForm";
    }

    @PostMapping(value = "/posts/new")
    public String create(PostForm form){
        Post post = new Post();
        post.setTitle(form.getTitle()); //인자로 받은 form의 값을 멤버 객체의 이름으로 set
        post.setContents(form.getContents()); //인자로 받은 form의 값을 멤버 객체의 이름으로 set

        postService.addPost(post); //회원가입

        return "redirect:/";
    }
    @GetMapping(value = "/posts")
    public String list(Model model){
        List<Post> posts = postService.findPosts(); //모든 멤버 찾아와 리스트로 저장
        model.addAttribute("post",posts); //model에 저장
        return "Posts/postList"; //템플릿으로 보냄
    }

}
