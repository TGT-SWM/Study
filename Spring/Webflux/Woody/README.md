# WebFlux

## Reactive Programming
- 서버에서 요청이 처리되는 시간동안 멍때리는게 않고 다른 요청을 받을 수 있음
- 요청이 없어도 응답해줄 수 있다

## WebFlux
- 이벤트 루프를 통해 요청을 처리하는 시간동안 다른 요청을 받을 수 있음
    - 기존에는 멀티쓰레딩을 통해 해결했지만, 컨텍스트 스위칭의 오버헤드가 커지는 경우 발생
- SSE를 통해 추가적인 요청 없이 지속적으로 여러번 응답해줄 수 있음 (Flux)
    - Publisher-Subscriber 패턴
- WebFlux를 사용하면 서버는 Reactive하게 짤 수 있지만… DB는?
    - [Spring Data R2DBC](https://spring.io/projects/spring-data-r2dbc) 라이브러리를 통해 DB에서 비동기 처리가 가능

## 예제 프로젝트

- [YouTube 메타코딩 채널: Springboot WebFlux 강좌](https://www.youtube.com/playlist?list=PL93mKxaRDidFH5gRwkDX5pQxtp0iv3guf)
- WebFlux와 SSE 사용해, 추가되는 고객 정보를 별도 요청 없이 지속적으로 수신
