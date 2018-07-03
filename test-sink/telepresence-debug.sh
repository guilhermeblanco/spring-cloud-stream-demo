#!/usr/bin/env bash

telepresence --new-deployment test-sink \
    --docker-run --rm -e MAVEN_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005" \
    -v $HOME/.m2/repository:/m2 -v $HOME/.kube:/root/.kube -v $HOME/.minikube:$HOME/.minikube \
    -v$(pwd):/build -v /tmp/known/var/run/secrets:/var/run/secrets \
    -p 8080:8080 -p 80:80 -p 5005:5005 \
    maven:3-jdk-8-alpine mvn -Dmaven.repo.local=/m2 -f /build spring-boot:run