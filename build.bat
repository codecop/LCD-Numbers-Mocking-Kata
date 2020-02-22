@echo Build the package for participants.

cd Java
rmdir /S /Q lib
rem see http://stackoverflow.com/questions/7908090/downloading-all-maven-dependencies-to-a-directory-not-in-repository
call mvnw dependency:copy-dependencies -DoutputDirectory=lib -Dmdep.useRepositoryLayout=true
call mvnw dependency:copy-dependencies -DoutputDirectory=lib -Dmdep.useRepositoryLayout=true -Dclassifier=sources
call mvnw eclipse:clean
call mvnw eclipse:eclipse
cd ..
call ant rewrite

cd JavaScript
call npm install
cd ..

call ant zip
