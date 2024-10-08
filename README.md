# 숙박 서비스 샘플
프론트 없이 백엔드만 구현해봄

## 프로젝트 환경
* java21
* Springboot 3.3.4
* H2 (embeded)
* REDIS (testcontainers)

## 목적
* srpingmvc의 기본적인 사용법 활용
* JPA와 관련된 기본적인 사용법 활용
* 테스트코드를 만들면서 개발하기 (커버리지가 아닌 브라우저나 POSTMAN없이 개발하기)

## testcontainers
### 사전 준비 사항
* 도커가 로컬에 이미 띄워져있어야 합니다.
### ES 관련 특이사항
* 사전설정 필요 
  * Reuse가 지원하지 않아서 이렇게 해줘야된다고하는데...옳지 않아~~~ 다른 방법 찾는 중
  * 사용자 홈 디렉토리(~)에 .testcontainers.properties라는 이름의 파일을 생성 (나는 이미 존재하는 파일이었음)
  * 이 파일에 아래 내용을 추가 (이 설정은 Testcontainers가 컨테이너를 재사용할 수 있도록 허용하는 옵션)
```
testcontainers.reuse.enable=true
```
### Reuse관련
* 테스트가 끝나도 도커이미지는 RUN상태이다.
* 모든 테스트가 끝나도 도커이미지는 RUN상태이다.
* 필요없으면 수동으로 종료 시키라고 가이드한다.
