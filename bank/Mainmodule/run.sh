#!/bin/sh

CLASSPATH=

for f in target/*.jar; do
	CLASSPATH=${CLASSPATH}:$f;
done

for f in target/lib/*.jar; do
	CLASSPATH=${CLASSPATH}:$f;
done

MAINCLASS=com.company3.Mainclass

exec java -cp "$CLASSPATH" $MAINCLASS
