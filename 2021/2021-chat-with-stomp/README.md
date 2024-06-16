# 채팅 기능 고도화- STOMP를 이용한 pub/sub 구조 만들기

## 1. 채팅방 생성

### Request

| Method | URL | 설명 |
| --- | --- | --- |
| POST | http://localhost:8080/chat/room | 채팅방 만들기 |

### Request 형식

| Name | type | 설명 |
| --- | --- | --- |
| name | String | 채팅방 이름 |

### Response

| roomNo | String | 채팅방 고유 ID 생성하여 반환 |
| --- | --- | --- |
| name | String | 입력받은 값으로 채팅방 이름 설정 |

![Untitled (4)](https://user-images.githubusercontent.com/61778930/144475615-c081225e-9ee6-4f87-9955-c56ec30e671b.png)

채팅방이 만들어진 것임. 고유 ID(roomNo)반환. 

이제 이 roomNo로 채팅방에 입장 가능.

## 2. 채팅방 입장

### Request

채팅 메소드는 `@MessageMapping` 사용, URL도 [http://가](http://가) 아닌 ws:// 사용함.

| Method | URL | 설명 |
| --- | --- | --- |
| Message | localhost:8080/pub/chat/message | 채팅 메시지 전송 |

### Request 형식

| Name | type | 설명 |
| --- | --- | --- |
| ChatMsgDto | JSON | ChatMsgDto json 형태로 |

Request 예시

```json
{
  "type":"ENTER",
  "roomNo":"5007fc94-ebbe-486c-ae00-7e21f632109b",
  "sender":"yoonseo",
  "content":""
}
```

### Response

[localhost:8080/sub/chat/room/{roomNo}](http://localhost:8081/sub/chat/room/{roomNo}) 로 채팅이 전송됨.

## 3. 메시지 전송

### Request

type이 `TALK` 인 것만 다름.

| Method | URL | 설명 |
| --- | --- | --- |
| Message | localhost:8080/pub/chat/message | 채팅 메시지 전송 |

### Request 형식

| Name | type | 설명 |
| --- | --- | --- |
| ChatMsgDto | JSON | ChatMsgDto json 형태로 |

Request 예시

```json
{
  "type":"TALK",
  "roomNo":"5007fc94-ebbe-486c-ae00-7e21f632109b",
  "sender":"yoonseo",
  "content":"hihi"
}
```

### Response

[localhost:8080/sub/chat/room/{roomNo}](http://localhost:8081/sub/chat/room/{roomNo}) 로 채팅이 전송됨.

## 4. 채팅방 목록 조회

### Request

| Method | URL | 설명 |
| --- | --- | --- |
| GET | localhost:8080/chat/rooms |  |
