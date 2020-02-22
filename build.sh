#!/bin/sh
echo Build the package for participants.

cd Java
rm -rf lib
# see http://stackoverflow.com/questions/7908090/downloading-all-maven-dependencies-to-a-directory-not-in-repository
./mvnw dependency:copy-dependencies -DoutputDirectory=lib -Dmdep.useRepositoryLayout=true
./mvnw dependency:copy-dependencies -DoutputDirectory=lib -Dmdep.useRepositoryLayout=true -Dclassifier=sources
./mvnw eclipse:clean
./mvnw eclipse:eclipse
cd ..
ant rewrite

cd JavaScript
npm install
cd ..

ant zip
