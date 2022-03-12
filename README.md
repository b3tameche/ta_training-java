# ta_training-java

Periodically, test cases may fail because of ads on the whole page (when searching for pricing calculator) or reCAPTCHA authentication on the mail, but not so often

Since there's only 1 test, suiteXmlFile is already specified in the Maven configuration

Run from command line:  
mvn -Dbrowser=chrome -Denvironment=mainEnv clean test
