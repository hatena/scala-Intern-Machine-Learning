#!/bin/sh

[ -z "$1" ] && {
    echo "Usage: $0 <training data set> <test data set> [<max size>]"
    exit
}

TRAINING_DATA_SIZE=${3:-100}
SIZE=0
COMMAND="sbt --error 'set showSuccess := false'"

while true; do
    SIZE=$((SIZE + 1))
    COMMAND="$COMMAND \"run iris $1 $2 $SIZE\""
    [ "$SIZE" = "$TRAINING_DATA_SIZE" ] && break
done

eval $COMMAND
