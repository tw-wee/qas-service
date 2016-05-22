#!/bin/bash

function createDB() {
    USER=$1
    DATABASE=$2
    echo "Creating database ${DATABASE} if not exists ..."
    mysql -uroot -h localhost -e "CREATE DATABASE IF NOT EXISTS ${DATABASE} DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci"
}

createDB root wee_qas
