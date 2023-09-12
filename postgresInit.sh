#!/bin/bash

# PostgreSQL 컨테이너 실행
podman run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5440:5432 postgres

# 컨테이너가 완전히 실행되기까지 기다림
sleep 10s

# JPAPG 데이터베이스 생성
podman exec -it my-postgres psql -U postgres -c "create database JPAPG;"