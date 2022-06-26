# 질문
- `Mono`와 `Flux` 클래스는 `Publisher`의 구현체이다. 그렇다면, `Subscriber`는 누가되는가?

# Notes
## Content-Type: text/event-stream
### `text/event-stream` 이란?
- 'text/event-stream'은 SSE(Server-Sent Events)의 데이터 형식 중 하나이다.
- SSE 는 HTML5 표준 권고사항으로, WebSocket과 유사함.
### SSE
- 양방향 통신이 아니다. 따라서 클라이언트(HTTP 요청자)는 서버가 주는 응답을 받기만 할 수 있다.
  - WebSocket은 양방향 통신 가능
- 클라이언트와 서버가 통신을 주고 받은 후 연결을 끊는 것이 아니라, 연결 상태를 유지하고 서버가 지속적으로 데이터를 내려준다.
- 채팅을 구현할 수는 있지만, 이때는 WebSocket을 사용하는 것이 더 나을 수도 있다.
- SSE는 주로 알림(Ex. 페이스북 알림) 등을 처리할 때 사용하면 유용하다.
  - 클라이언트가 서버에 데이터를 보낼 필요가 없기 때문에