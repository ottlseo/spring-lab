package ottl.hijava.controller;

public class PostForm { // 웹 등록 화면에서 데이터를 전달받을 폼 객체
    private String title;
    private String contents;

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
