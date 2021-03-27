
set CATALINA_HOME=C:\tools\apache-tomcat-8.5.61
del %CATALINA_HOME%\webapps\i2invest.war /S /Q
del %CATALINA_HOME%\logs\*.* /S /Q
rmdir %CATALINA_HOME%\webapps\i2invest /S /Q
rmdir %CATALINA_HOME%\work\Catalina /S /Q
copy ..\restful\target\i2invest.war %CATALINA_HOME%\webapps /Y
%CATALINA_HOME%\bin\startup