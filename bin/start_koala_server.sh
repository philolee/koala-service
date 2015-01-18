#!/usr/bin/env bash

usage="Usage: start_koala_server <config dir>"
if [ $# -lt 1 ]; then
   echo $usage
  exit 1
fi

bin=`dirname "$0"`
bin=`cd "$bin"; pwd`

OS=`uname`

lib=$bin/../koala

# HEAP_OPTS="-Xmx4096m -Xms2048m -XX:NewSize=1024m" # -d64 for 64-bit awesomeness
HEAP_OPTS="-Xmx512m -Xms256m -XX:NewSize=128m"
# HEAP_OPTS="-Xmx1024m -Xms512m -XX:NewSize=128m"
# HEAP_OPTS="-Xmx512m -Xms256m -XX:NewSize=64m"
# GC_OPTS="-verbosegc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC -XX:+UseParNewGC"
#JAVA_DEBUG="-Xdebug -Xrunjdwp:transport=dt_socket,address=9526,server=y,suspend=y"
#GC_OPTS="-XX:+UseConcMarkSweepGC -XX:+UseParNewGC"
JAVA_OPTS="-server -d64"

MAIN_CLASS="com.koala.service.KoalaHttpServer"

CLASSPATH=$lib/*:$lib/lib/*:$1/*

exec java $JAVA_OPTS $HEAP_OPTS $GC_OPTS $JAVA_DEBUG -classpath $CLASSPATH $MAIN_CLASS $1
