#!/usr/bin/env bash

# see http://pitest.org/quickstart/maven/
./mvnw test-compile org.pitest:pitest-maven:mutationCoverage
