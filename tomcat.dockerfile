FROM tomcat:8.0.47-jre8
MAINTAINER Andre Lucas
ADD tomcat-users.xml /usr/local/tomcat/conf
VOLUME home/andrelucastic/docker_test/tomcat/conf:/usr/local/tomcat/conf
VOLUME home/andrelucastic/docker_test/tomcat/webapps:/usr/local/tomcat/webapps
VOLUME home/andrelucastic/docker_test/tomcat/log:/usr/local/tomcat/log
EXPOSE 8080
