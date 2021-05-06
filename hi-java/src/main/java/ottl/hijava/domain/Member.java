package ottl.hijava.domain;

public class Member {

    private long id; //요구사항: 아이디, 회원 이름
    private String name;

    // Getter/Setter
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
