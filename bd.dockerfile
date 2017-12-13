FROM mysql:5.7
MAINTAINER Andre Lucas
VOLUME /home/andrelucastic/docker_test/mysql:/var/lib/mysql
ENV MYSQL_ROOT_PASSWORD=root
EXPOSE 3306

