package domain;

public class Posts {

    //@Entity
    public class Posts {

        //@Id @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 알아서 생성해주는 전략-
        private long id; //요구사항: 아이디(자동생성), 제목, 내용

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
        public void setContents(String name) { this.contents = contents; }

    }

}
