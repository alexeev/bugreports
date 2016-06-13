## TestngParamIssue surefire log

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running lu.crx.proto.arq.TestngParamIssue
###### in failOneTime / 1
###### in failOneTime / 2
###### in failOneTime / 3
###### in failOneTime / 1
###### in failOneTime / 2
###### in failOneTime / 3
###### in failOneTime / 1
###### in failOneTime / 2
###### in failOneTime / 3
Tests run: 3, Failures: 3, Errors: 0, Skipped: 0, Time elapsed: 6.948 sec <<< FAILURE! - in lu.crx.proto.arq.TestngParamIssue
failOneTime(lu.crx.proto.arq.TestngParamIssue)  Time elapsed: 0.219 sec  <<< FAILURE!
java.lang.AssertionError: 

Expected: not <1>
     but: was <1>
	at lu.crx.proto.arq.TestngParamIssue.failOneTime(TestngParamIssue.java:37)

failOneTime(lu.crx.proto.arq.TestngParamIssue)  Time elapsed: 0.04 sec  <<< FAILURE!
java.lang.AssertionError: 

Expected: not <1>
     but: was <1>
	at lu.crx.proto.arq.TestngParamIssue.failOneTime(TestngParamIssue.java:37)

failOneTime(lu.crx.proto.arq.TestngParamIssue)  Time elapsed: 0.028 sec  <<< FAILURE!
java.lang.AssertionError: 

Expected: not <1>
     but: was <1>
	at lu.crx.proto.arq.TestngParamIssue.failOneTime(TestngParamIssue.java:37)


Results :

Failed tests: 
lu.crx.proto.arq.TestngParamIssue.failOneTime(lu.crx.proto.arq.TestngParamIssue)
  Run 1: TestngParamIssue>Arquillian.run:164->failOneTime:37 
Expected: not <1>
     but: was <1>
  Run 2: TestngParamIssue>Arquillian.run:164->failOneTime:37 
Expected: not <1>
     but: was <1>
  Run 3: TestngParamIssue>Arquillian.run:164->failOneTime:37 
Expected: not <1>
     but: was <1>


Tests run: 1, Failures: 1, Errors: 0, Skipped: 0

------------------------------------------------------------------------
BUILD FAILURE
------------------------------------------------------------------------
```

## TestngParamIssue2 surefire log

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running lu.crx.proto.arq.TestngParamIssue2
###### in failTwoTimes / 1
###### in failTwoTimes / 2
###### in failTwoTimes / 3
###### in failTwoTimes / 1
###### in failTwoTimes / 2
###### in failTwoTimes / 3
###### in failTwoTimes / 1
###### in failTwoTimes / 2
###### in failTwoTimes / 3
Tests run: 3, Failures: 3, Errors: 0, Skipped: 0, Time elapsed: 7.094 sec <<< FAILURE! - in lu.crx.proto.arq.TestngParamIssue2
failTwoTimes(lu.crx.proto.arq.TestngParamIssue2)  Time elapsed: 0.235 sec  <<< FAILURE!
java.lang.AssertionError: 

Expected: is <1>
     but: was <3>
	at lu.crx.proto.arq.TestngParamIssue2.failTwoTimes(TestngParamIssue2.java:37)

failTwoTimes(lu.crx.proto.arq.TestngParamIssue2)  Time elapsed: 0.038 sec  <<< FAILURE!
java.lang.AssertionError: 

Expected: is <1>
     but: was <2>
	at lu.crx.proto.arq.TestngParamIssue2.failTwoTimes(TestngParamIssue2.java:37)

failTwoTimes(lu.crx.proto.arq.TestngParamIssue2)  Time elapsed: 0.03 sec  <<< FAILURE!
java.lang.AssertionError: 

Expected: is <1>
     but: was <3>
	at lu.crx.proto.arq.TestngParamIssue2.failTwoTimes(TestngParamIssue2.java:37)


Results :

Failed tests: 
lu.crx.proto.arq.TestngParamIssue2.failTwoTimes(lu.crx.proto.arq.TestngParamIssue2)
  Run 1: TestngParamIssue2>Arquillian.run:164->failTwoTimes:37 
Expected: is <1>
     but: was <3>
  Run 2: TestngParamIssue2>Arquillian.run:164->failTwoTimes:37 
Expected: is <1>
     but: was <2>
  Run 3: TestngParamIssue2>Arquillian.run:164->failTwoTimes:37 
Expected: is <1>
     but: was <3>


Tests run: 1, Failures: 1, Errors: 0, Skipped: 0

------------------------------------------------------------------------
BUILD FAILURE
------------------------------------------------------------------------
```
