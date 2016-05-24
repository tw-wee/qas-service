#!/bin/bash

echo "Ready to build docker image ..."
cd .. && ./gradlew buildDocker
if [ $? -ne 0 ]; then
    echo "Build docker image failed!"
    exit -1
fi;
echo "======Build docker image successfully! ======\n\n"

echo "Ready to docker compose up ..."
cd - && docker-compose up
if [ $? -ne 0 ]; then
    echo "Docker compose up failed!"
    exit -1
fi;
