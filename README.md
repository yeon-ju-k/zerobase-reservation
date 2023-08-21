## 개요
간단한 매장 예약 서비스 

Use : Spring, Jpa, MariaDB, Redis, Docker, AWS

Goal : 셀러와 예약자 사이를 중개해 주는 예약 서버를 구축한다. 

## 회원 서버 

### 1. 고객
- [x] 회원 가입 - ID, 이름, 이메일, 비밀번호, 핸드폰번호
- [ ] 로그인 토큰 발행
- [ ] 로그인 토큰을 통한 제어 확인 (JWT, Filter를 사용해서 간략하게)

### 2. 관리자 (파트너)
- [x] 회원 가입 - ID, 이름, 이메일, 비밀번호, 핸드폰번호 
- [ ] 로그인 토큰 발행
- [ ] 로그인 토큰을 통한 제어 확인 (JWT, Filter를 사용해서 간략하게)




## 예약 서버

### 1. 관리자 
- [ ] 가게 등록, 수정 - 매장명, 상점위치, 상점설명
- [ ] 가게 삭제
- [ ] 예약 승인/거절 - 알림창 (FCM 기능 활용) 
- [ ] 예약 목록 조회
- [ ] 방문확인 기능 - 핸드폰 뒷자리를 입력하면 방문확인


### 2. 예약자
- [ ] 매장 검색
- [ ] 매장 정보 확인
- [ ] 예약 (로그인 확인) - 예약 대기중 알람 (FCM 기능 활용)
- [ ] 예약 확인 알림 - 관리자가 예약 승인을 했을 때의 안내 알림 (FCM 기능활용)
- [ ] 예약 취소
- [ ] 방문 확인 - 예약 10분전에 매장의 키오스크에서 핸드폰 뒷자리로 방문 확인
- [ ] 리뷰 작성 - 방문확인이 진행되고 30분뒤에 안내 알림 (FCM 기능활용)

















