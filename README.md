# notification-api

## architecture

### DB

- topic 테이블과 notification 테이블이 존재하고 1:N 관계를 갖습니다.

- topic table

|id| topic | status | createdAt | updatedAt |
|------|---|---|---|---|
| 1 | news | ACTIVE | 2020-10-11T01:01:01 | 2020-10-11T01:01:01 |

-notification table

|id| topicId | message | createdAt | updatedAt |
|------|---|---|---|---|
| 1 | 1 | message | 2020-10-11T01:01:01 | 2020-10-11T01:01:01 |


### rest api (웹 - 서버)

> 토픽 api prefix : /api/v1/topic

- [ ] : 토픽 저장
    + 성공 : 200 success
    + 실패 : 4xx (BAD_REQUEST- topic length), 5xx(INTERNAL_SERVER_ERROR)
- [ ] : 토픽 활성화
    + 성공 : 200 success
    + 실패 : 4xx (BAD_REQUEST- 존재x), 5xx(INTERNAL_SERVER_ERROR)
- [ ] : 토픽 비활성화
    + 성공 : 200 success
    + 실패 : 4xx(BAD_REQUEST- 존재x), 5xx(INTERNAL_SERVER_ERROR)
     
> 알림 api prefix : /api/v1/notification

- [ ] : 메시지 전송
 + 성공 : 200 success
 + 실패 : 4xx(BAD_REQUEST- 토픽 존재x), 5xx(INTERNAL_SERVER_ERROR)

#### firebase api

- [ ] : 메시지 전송 구현