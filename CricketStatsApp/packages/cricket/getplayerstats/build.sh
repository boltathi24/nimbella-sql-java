#!/bin/bash

set -e 

# set to 'maven' to use maven
# set to 'gradle' to use gradle
BUILD="maven"

if [ $BUILD == "maven" ]; then
    mvn install
    echo target/player-1.0-jar-with-dependencies.jar > .include
fi
