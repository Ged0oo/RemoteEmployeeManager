#!/bin/bash
cd "$(dirname "$0")"
java -cp "rmi-client/target/rmi-client-1.0-SNAPSHOT.jar:rmi-common/target/rmi-common-1.0-SNAPSHOT.jar" org.example.App
