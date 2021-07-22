rem set JBOSS_HOME=C:\tools\wildfly-17.0.1.Final
set JBOSS_HOME=C:\tools\EAP-7.3.0

del %JBOSS_HOME%\standalone\deployments\*.* /S /Q
rmdir %JBOSS_HOME%\standalone\log /S /Q
rmdir %JBOSS_HOME%\standalone\tmp /S /Q


copy ..\ear\target\i2invest_ear.ear %JBOSS_HOME%\standalone\deployments /Y

start %JBOSS_HOME%\bin\standalone
