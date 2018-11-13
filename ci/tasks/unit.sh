#!/bin/bash

set -e -x

cd mlb-api-repo/
./mvnw -Dtest=AllTests test