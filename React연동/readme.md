# 리액트와 연동하여 서버에 배포하기

## 상황
- 리액트 코드에 route는 사용 X
- gradle 프로젝트, 자바8

## 배포
### intelij Gradle jar 파일 생성 방법

build.gradle에 추가하기 => 실행 => 우측 gradle 탭 :bootjar 실행
```java
bootJar{
   archiveBaseName='-'
   archiveFileName='아무거나.jar'
   archiveVersion="0.0.0"
   jar.enabled=true
}
```
### cmd창에서 jar 파일 실행방법 
```
java -jar ebs-final.jar
```
EC2 서버에서 실행하면 배포 ok   
무중단 배포하려면 nohup 명령어 사용

### Reference
[react-spring 개발환경 합치기](https://joshua-dev-story.blogspot.com/2020/01/react-spring-2.html)
