# 회원가입+로그인 기능 구현(spring security)
## 1. JPA와 Mysql 연동하기
application.properties 파일
```
# MySQL 을 사용할 것.
spring.jpa.database=mysql

spring.datasource.driver-class-name = com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/DB이름?serverTimezone=UTC&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=비밀번호

spring.jpa.hibernate.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update

# MySQL 상세 지정
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect

# 사용되는 SQL 콘솔창에 출력
spring.jpa.show-sql=true

```
🎈 .yml 파일인 경우
```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://codic-db.cfgbs9nzcfco.ap-northeast-2.rds.amazonaws.com/codicdb
    username: codic
    password: qwer1234
  jpa:
    database: mysql
    show-sql: true
    generate-ddl: true
    ddl-auto: update

```
## 2. SpringSecurity가 제공하는 함수 override하여 구성
@Entity 등 구성하여 DB 만들기

- - -

## 📚 References
- jpa @Entity 매핑 https://doublesprogramming.tistory.com/260
- jpa mysql 연동하기 https://velog.io/@2yeseul/Spring-Boot-JPA-MySQL-%EC%97%B0%EB%8F%99

### 🍄 알아두자
- **언더스코어** 표기법이란? : ```user_info```   
  (파이썬에서 주로 사용)
- **카멜표기법**이란? : ```UserInfo```   
  (자바에서 사용)    
   
```@Table(name=이름)``` 속성 없이 ```@Entity``` 속성으로만 테이블 매핑해주면,    
**카멜표기법으로 표기된 클래스명**을 **언더스코어 표기법으로 자동으로 바꾸어 테이블을 생성**한다.
