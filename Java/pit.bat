rem see http://pitest.org/quickstart/maven/
call mvnw test-compile org.pitest:pitest-maven:mutationCoverage %*
