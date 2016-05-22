#!/bin/bash

function dropDB() {
    USER=$1
    DATABASE=$2
    echo "Dropping database ${DATABASE} if exists ..."
    mysql -uroot -h localhost -e "DROP DATABASE if exists ${DATABASE}"
}

dropDB root wee_qas