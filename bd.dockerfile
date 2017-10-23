FROM mysql:5.7
MAINTAINER André Lucas
WORKDIR ~/
RUN mkdir mysql
VOLUME ~/mysql:/var/lib/mysql
ENV MYSQL_ROOT_PASSWORD=root
EXPOSE 3306

