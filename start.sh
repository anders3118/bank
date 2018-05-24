#!/bin/sh

cd barclaysProject/dispatcher/
./start.sh

cd ../../barclaysProject/orchestrator/
./start.sh

cd ../../barclaysProject/routing/
./start.sh

cd ../../barclaysProject/transform/
./start.sh

docker-compose up -d --build
