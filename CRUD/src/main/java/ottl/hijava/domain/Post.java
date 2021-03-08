package ottl.hijava.domain;

import javax.persistence.*;

@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 알아서 생성해주는 전략-
    private long id; //요구사항: 아이디, 회원이름

    private String title;
    private String contents;

    // Getter/Setter
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

}
