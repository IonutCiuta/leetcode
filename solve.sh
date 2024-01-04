#!/bin/bash

if [ $# -ne 1 ]; then
  echo "You need to tell me what problem you want to solve: ./solve.sh <problem_number>"
  exit 1
else
  ID="xxxx"
  if [ $1 -lt 1 ]; then
    echo "We can't go lower than 1"
    exit 1
  elif [ $1 -lt 10 ]; then
    ID="000$1"
  elif [ $1 -lt 100 ]; then
    ID="00$1"
  elif [ $1 -lt 1000 ]; then
    ID="0$1"
  else
    # Wishfull thinking :)
    ID="$1"
  fi
  
  PROBLEM="P$ID"
  ls $PROBLEM 2> /dev/null

  if [ $? -eq 0 ]; then
    echo "Yeah, you already solved problem $1"
    cat $PROBLEM/manifest.json
    exit 1;
  fi

  echo "Great, setting up problem $1 in folder $PROBLEM"
  cp -r P0000 $PROBLEM
  git add $PROBLEM/
  ARGS="s/<id>/$1/g"
  sed -i "" $ARGS ./$PROBLEM/manifest.json
  cat ./$PROBLEM/manifest.json
fi