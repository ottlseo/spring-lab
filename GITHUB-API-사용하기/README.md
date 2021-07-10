# github api 설명

### **[매일 시간당 커밋 수 가져 오기](https://docs.github.com/en/rest/reference/repos#get-the-hourly-commit-count-for-each-day)**
[GET] /repos/{owner}/{repo}/stats/punch_card   

```java
https://api.github.com/repos/EWHACODIC/back-end/stats/punch_card

https://api.github.com/repos/EWHACODIC/back-end/stats/punch_card
?since=2021-07-01T00:00:00Z&until=2021-07-08T23:59:59Z&author=ottl-seo
```

각 배열에는 일 번호, 시간 번호 및 커밋 수가 포함됩니다.   
- 0-6: Sunday - Saturday
- 0-23: Hour of day
- Number of commits

```java
[
  [
    0,
    0,
    0
  ],
  [
    0,
    1,
    0
  ],
  [
    0,
    2,
    0
  ],
  [
    0,
    3,
    0
  ], 
  
  ... 
  
  [
    6,
    20,
    0
  ],
  [
    6,
    21,
    0
  ],
  [
    6,
    22,
    0
  ],
  [
    6,
    23,
    2
  ]
]
```

## OAuth2

→ 구글 아이디로 로그인, 깃허브 아이디로 로그인 등

(토큰을 이용해서 로그인 정보 저장해주는 것)

### ⇒ 우리는 구현할 필요 없다고 생각됨

https://github.com/cheese10yun/springboot-oauth2

