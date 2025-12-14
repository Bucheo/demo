# 🌱 JAVA 웹 프로젝트 포트폴리오

20210916 박지호 자바웹프로그래밍2 수업을 진행했습니다.

## 기술 스택
- ![Spring](https://img.shields.io/badge/-Spring-6DB33F?style=flat-square&logo=spring&logoColor=white) Spring Boot 3.5.x
- ![JPA](https://img.shields.io/badge/-JPA-59666C?style=flat-square&logo=hibernate&logoColor=white) Spring Data JPA
- ![Security](https://img.shields.io/badge/-Spring%20Security-6DB33F?style=flat-square&logo=springsecurity&logoColor=white) Spring Security
- ![MySQL](https://img.shields.io/badge/-MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white) MySQL 8.0

- ![Thymeleaf](https://img.shields.io/badge/-Thymeleaf-005F0F?style=flat-square&logo=thymeleaf&logoColor=white) Thymeleaf
- ![Bootstrap](https://img.shields.io/badge/-Bootstrap-7952B3?style=flat-square&logo=bootstrap&logoColor=white) Bootstrap 5
- ![JavaScript](https://img.shields.io/badge/-JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black) JavaScript

- ![Git](https://img.shields.io/badge/-Git-F05032?style=flat-square&logo=git&logoColor=white) Git
- ![Maven](https://img.shields.io/badge/-Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white) Maven

## 개발 진행 상황

### 2주차 - 개발 환경 구축
- Spring Boot 프로젝트 초기 설정 완료
- Hello World 페이지 구현 및 컨트롤러 매핑 완료
- 추가 구현: URL 맵핑과 컨트롤러 추가 - 완료
> **느낀점**: Spring Boot를 사용하기에 긴장을 했지만 설치부터 환경설정까지 자세히 알려주셔서 간편했습니다.

### 3주차 - 포트폴리오 페이지 개발 
- 개인 포트폴리오 템플릿 커스터마이징
- 상세 페이지 제작 및 JavaScript confirm 기능 구현
- 추가 구현: 상세 페이지 수정 완료!(confirmClose()함수 추가) - 상세 페이지를 누를 경우 서비스로 넘어가서 자세한 내용을 출력해주고 돌아가기 버튼을 누르면 메인페이지로 돌아가게 구현했습니다.
> **느낀점**: 프론트엔드와 백엔드를 어떻게 결합하고 작성을 하는지를 배울 수 있었습니다.

### 4주차 - MVC 패턴 & DB 연동
- MVC 아키텍처 패턴 구현
- MySQL 데이터베이스 연동 및 CRUD 기능 구현
- 추가 구현: 사용자 추가 및 출력 - MySQL에 새로운 사용자를 추가했습니다.
> **느낀점**: 데이터베이스를 필요성과 영속성을 배울 수 있어서 좋았습니다.

### 5-6주차 - 게시판 기능 구현
- 게시글 CRUD 기능 완성
- 추가 구현: 페이지 리다이렉트 구현 완료 - cotroller를 만들어서 직접 제어를 하니 매우 편리합니다.
- 추가 구현: 예외처리 구현 완료 (예외처리 클래스 추가 완료)템 구축!

### 7-8주차 - 게시판 고도화 
- 추가 구현> **느낀점**: 견고한 예외 처리의 중요성을 깊이 이해하게 되었습니다.
: PUT 매핑을 통한 수정/삭제 구현 완료(서비스 로직 추가 완료)
- 추가 구현: 게시글 번호 자동 재정렬 구현 완료(메서드 추가 완료)
> **느낀점**: RESTful 설계의 중요성과 HTTP 메소드의 적절한 활용법을 배웠습니다.
> **도전과제**: 페이징 처리 시 성능 최적화가 어려웠으나, 인덱싱 전략으로 해결했습니다.
> **추가 구현 완료**: 완벽한 RESTful API 설계 달성!

### 9주차 - 보안 시스템 구축 
- 추가 구현: 입력값 필터링 구현 완료(Validation 모듈 추가 완료)
- 추가 구현: 강력한 입력값 검증 및 정규식 필터링(회원가입)
> **느낀점**: 보안의 중요성과 사용자 데이터 보호의 책임감을 느꼈습니다.
> **도전과제**: 보안 취약점 대응이 까다로웠으나, Spring Security의 다양한 기능으로 해결했습니다.
> **추가 구현 완료**: 완벽한 보안 시스템 구축!

### 10주차 - 세션 관리 시스템 
- 추가 구현: 작성자 권한 관리 구현 완료(세션 추가 완료)
- 추가 구현: 게시글 작성자 권한 관리 수정/삭제 구현 완료(서비스 로직 추가 완료)
> **느낀점**: 상태 관리와 사용자 경험의 균형이 중요함을 배웠습니다.
> **도전과제**: 동시 접속 처리가 어려웠으나, 세션 전략 최적화로 해결했습니다.
> **추가 구현 완료**: 완벽한 권한 관리 시스템 구축!

### 11주차 - 파일 시스템 & API 통합 
- 추가 구현: 다중 파일 업로드 시스템 구현 완료(파일 업로드 추가 완료)
- 추가 구현: 동시 사용자 세션 관리 구현 완료(세션 추가 완료)
- 추가 구현: FileService.java 추가구현
> **느낀점**: 대용량 데이터 처리와 성능 최적화의 중요성을 깨달았습니다.
> **도전과제**: 파일 업로드 시 메모리 관리가 어려웠으나, 스트림 처리로 해결했습니다.
> **추가 구현 완료**: 모든 파일 시스템 기능 구현 성공!

## 향후 개발 계획
- 실시간 알림 시스템 구현
- 댓글 시스템 고도화
- 사용자 프로필 관리 기능 확장
- 검색 기능 최적화
