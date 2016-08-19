#!/bin/sh

[ -z "$2" ] && {
    echo "Usage: $0 <max size> <command> [<args>...]"
    exit
}

i=0
MAX="$1"; shift
COMMAND="sbt --error 'set showSuccess := false'"

while true; do
    i=$((i + 1))
    COMMAND="$COMMAND \"run $@ $i\""
    [ "$i" = "$MAX" ] && break
done

eval $COMMAND
