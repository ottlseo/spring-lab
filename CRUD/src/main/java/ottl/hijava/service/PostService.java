package ottl.hijava.service;

import org.springframework.transaction.annotation.Transactional;
import ottl.hijava.domain.Post;
import ottl.hijava.repository.PostRepository;

import java.util.List;
import java.util.Optional;

//@Service //스프링 빈 등록
@Transactional // Jpa 사용하려면 서비스 계층에 트랜잭션 꼭 넣어줘야함!
public class PostService {
    private final PostRepository postRepository;

    //@Autowired
    public PostService(PostRepository postRepository){ //인자로 받도록-> Test코드에도 인자로 넣어줌
        this.postRepository = postRepository;
    }

    /**
     * 글쓰기
     */
    public Long addPost(Post post){
        postRepository.save(post);
        return post.getId(); //id를 반환
    }
    /*
        private void validateDuplicateMember(Member member) {
            memberRepository.findByName(member.getName())
                .ifPresent(member1 -> { //이미 존재할 경우 (ifPresent)
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        }
     */
    public List<Post> findPosts(){
        return postRepository.findAll(); //모든 회원 List 반환
    }
    public Optional<Post> findOne(Long postId){ //한 회원 찾기
        return postRepository.findById(postId); //객체 반환
    }
    //public
}
