#!/bin/bash

set -e -x


pushd mlb-api-repo/
  ./mvnw clean package
popd

cp mlb-api-repo/target/mlb-api-0.0.1.jar   build-output/.