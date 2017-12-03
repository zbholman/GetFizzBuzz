#!/bin/bash
# This script checks to make sure you have the proper
# version of java installed then starts up the
# GetFizzBuzz server

function java_check {
    if type -p java; then
        _java=java
    elif [[ -n "$JAVA_HOME" ]] && [[ -x "$JAVA_HOME/bin/java" ]];  then
        _java="$JAVA_HOME/bin/java"
    else
        echo "no java found in PATH, please add java to your PATH"
        exit
    fi

    if [[ "$_java" ]]; then
        version=$("$_java" -version 2>&1 | awk -F '"' '/version/ {print $2}')
        if [[ "$version" < "1.8" ]]; then
            echo version is less than 1.8, please install java 1.8 or higher
            exit
        fi
    fi
}

function run_fizz_buzz_server {
    # Check if jars exist, starting with target, then root of project.
    if [ -f ./target/GetFizzBuzz-0.0.1-SNAPSHOT-jar-with-dependencies.jar ]; then
        jar_location=./target/GetFizzBuzz-0.0.1-SNAPSHOT-jar-with-dependencies.jar
    elif [ -f ./GetFizzBuzz-0.0.1-SNAPSHOT-jar-with-dependencies.jar ]; then
        jar_location=./GetFizzBuzz-0.0.1-SNAPSHOT-jar-with-dependencies.jar
    else
	echo executable jar could not be found, please build using IDE and maven
        exit
    fi

    echo Starting GetFizzBuzz server on port 8080
    java -jar $jar_location &
    sleep 3

    if lsof -Pi :8080 -sTCP:LISTEN -t >/dev/null ; then
        echo "GetFizzBuzz server is now running..."
    else
        echo "not running, try importing and running from IDE"
        exit
    fi

    read -rsp $'Press any key to quit and shut down server\n' -n1 key
    echo shutting down server
    curl localhost:8080/stop 2>/dev/null
    sleep 3

    if lsof -Pi :8080 -sTCP:LISTEN -t $1>/dev/null ; then
        echo "GetFizzBuzz server is still running"
    else
        echo "GetFizzBuzz server is no longer running"
        exit
    fi
}

# Function calls

java_check
run_fizz_buzz_server
