#!/bin/bash
docker run -p 127.0.0.1:13306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=securedpassword -d --restart=always mysql:8.0.25
