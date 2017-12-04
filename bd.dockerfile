FROM mysql:5.7
MAINTAINER Andre Lucas
WORKDIR /home/andrelucastic/docker_test
VOLUME /home/andrelucastic/docker_test/mysql:/var/lib/mysql
ENV MYSQL_ROOT_PASSWORD=root
EXPOSE 3306

