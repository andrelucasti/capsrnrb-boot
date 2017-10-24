FROM mysql
MAINTAINER André Lucas
WORKDIR ~/
VOLUME ~/mysql:/var/lib/mysql
ENV MYSQL_ROOT_PASSWORD=root
EXPOSE 3306

