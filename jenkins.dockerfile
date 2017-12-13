FROM jenkins:latest
MAINTAINER Andre Lucas
ARG user=root
RUN chmod -R 777 /var/jenkins_home
VOLUME /home/andrelucastic/docker_test/jenkins:/var/jenkins_home
EXPOSE 8080
EXPOSE 50000