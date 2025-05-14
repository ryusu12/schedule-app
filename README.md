# 📅 schedule-app
내일배움캠프 - 일정 관리 앱

## 🐾 프로젝트 소개
schedule-app은 CRUD 기반의 일정 관리 앱입니다.

이 프로젝트를 통해 데이터베이스 설계, SQL 쿼리 작성, API 명세, 페이지네이션, 예외 처리, 유효성 검증 등 백엔드 개발의 핵심 역량을 실습합니다.

## 📌 주요 기능
- 일정 CRUD (생성, 조회, 수정, 삭제)

Lv 1. 일정 생성 및 조회<br>
Lv 2. 일정 수정 및 삭제

## 📑 API 명세서
아래 링크를 통해, 각 Method에 대한 요구사항 및 URL, Request, Response, 상태코드를 확인할 수 있습니다.

[API 명세서](https://documenter.getpostman.com/view/44733463/2sB2jAaTZM)

## 🗂️ ERD

![ERD.png](readme/ERD.png)
![sqlImg.png](readme/sqlImg.png)

## ✅ 요구사항
### 1️⃣ 필수 기능
Lv 0. API 명세 및 ERD 작성
- [x] API 명세서 작성하기
- [x] ERD 작성하기
- [x] SQL 작성하기

Lv 1. 일정 생성 및 조회
- [x] 일정 생성(일정 작성하기)
  - `AUTO_INCREMENT` 으로 각 일정의 고유 식별자(ID)를 자동으로 생성하여 관리
  - `LocalDateTime.now()` 으로 날짜와 시간을 저장함
- [x] 전체 일정 조회(등록된 일정 불러오기)
  -  Date(YYYY-MM-DD)으로 같은 날짜 일정을 확인함
  - `ORDER BY update_date DESC` 으로 내림차순 정렬 조회
- [x] 선택 일정 조회(선택한 일정 정보 불러오기)
  - `schedule_id`를 사용하여 조회함

Lv 2. 일정 수정 및 삭제
- [x] 선택한 일정 수정
  - `UPDATE schedule SET update_date = NOW()` 으로 수정일 갱신
- [x] 선택한 일정 삭제
  - `DELETE FROM schedule WHERE schedule_id = ? AND password = ?` 으로 비밀번호와 id가 맞아야 삭제됨
  
## 📁 프로젝트 구조

```
schedule-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/scheduleapp/
│   │   │       ├── controller/
│   │   │       │   └── ScheduleController.java
│   │   │       ├── dto/
│   │   │       │   ├── ScheduleDeleteRequestDto.java
│   │   │       │   ├── SchedulePostAndPatchRequestDto.java
│   │   │       │   └── ScheduleResponseDto.java
│   │   │       ├── entity/
│   │   │       │   └── Schedule.java
│   │   │       ├── repository/
│   │   │       │   ├── JdbcTemplateScheduleRepository.java
│   │   │       │   └── ScheduleRepository.java
│   │   │       └── service/
│   │   │           ├── ScheduleService.java
│   │   │           └── ScheduleServiceImpl.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── com/example/scheduleapp/
├── build.gradle
├── schedule.sql
├── readme/
└── README.md
```