#!/bin/bash
cd "$(dirname "$0")"
java -cp "rmi-client/target/classes:rmi-common/target/classes" org.example.App
