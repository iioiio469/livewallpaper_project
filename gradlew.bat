@echo off
:: Gradle startup script for Windows

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

set DEFAULT_JVM_OPTS=

set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

"%JAVA_HOME%\bin\java.exe" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
