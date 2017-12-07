FROM httpd:latest
MAINTAINER Andre Lucas
COPY . /var/www
WORKDIR /var/www
EXPOSE 8080