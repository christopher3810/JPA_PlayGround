# JPA_PlayGround

JPA 씹고 뜯고 맛보고 즐겨보자

이 리포지토리에는 JPA/Hibernate 라이브러리, 애드온 및 기능에 대한 테스트 작성과 Spring Data JPA 및 Querydsl 기능을 사용한 테스트 코드 작성에 대한 예제 및 학습이 포함되어 있습니다.\
이 리포지토리의 주요 목표는 저와 제 리포지토리를 보는 사람들에게 Java JPA 및 ORM을 학습하고 테스트하는 것은 물론 새롭고 고급 기능을 탐색하고 실험하는것에 대한 기록과 참조를 제공하는 것입니다.

This repository contains examples and lessons on writing tests for JPA/Hibernate libraries, add-ons, and features, as well as writing test code using Spring Data JPA and Querydsl features.\
The main goal of this repository is to provide me and those who view my repository with a record and reference for learning and testing Java JPA and ORMs, as well as exploring and experimenting with new and advanced features.

<br>

## code demo
***

[code demo root](https://github.com/christopher3810/JPA_PlayGround/tree/master/src/main/java/com/Jpa_playground/smy)

1. hypersistence-utils-hibernate-60:3.2.0 의존성 추가 및 utils 살펴보기
   - table pk에 활용되는 tsid
   
<br>
   
2. Converters in Hibernate 6
   - YesNoConverter
   - TrueFalseConverter
   - NumericBooleanConverter
   - @ConverterRegistration


<br>

[test code root](https://github.com/christopher3810/JPA_PlayGround/tree/master/src/test/java/com/Jpa_playground/smy)


### podman 으로 postgresql 생성

> 아래 설명은 Podman 설치가 되어 있다는 가정하에 진행됨.

yaml 설정 값은 port 번호가 5440 이기 때문에 5440 으로 맞춰서 띄워 주면 됨.

```bash
podman run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5440:5432 postgres
```

Podman Container 띄운뒤 JPAPG DB를 생성.

```bash
podman exec -it my-postgres psql -U postgres -c "create database JPAPG;"
```

#### 쉘 스크립트 실행

아니면 위 명령어가 담긴 `postgresInit.sh` 스크립트를 실행.
