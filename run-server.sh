#!/bin/bash
cd "$(dirname "$0")"
java -cp "rmi-server/target/rmi-server-1.0-SNAPSHOT.jar:rmi-common/target/rmi-common-1.0-SNAPSHOT.jar" org.example.ServerMain
