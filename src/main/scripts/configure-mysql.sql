## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE ayan_dev;
CREATE DATABASE ayan_prod;

#Create database service accounts
CREATE USER 'ayan_dev_user'@'localhost' IDENTIFIED BY 'ayan';
CREATE USER 'ayan_prod_user'@'localhost' IDENTIFIED BY 'ayan';

CREATE USER 'ayan_dev_user'@'%' IDENTIFIED BY 'ayan';
CREATE USER 'ayan_prod_user'@'%' IDENTIFIED BY 'ayan';

#Database grants
GRANT SELECT ON ayan_dev.* to 'ayan_dev_user'@'localhost';
GRANT INSERT ON ayan_dev.* to 'ayan_dev_user'@'localhost';
GRANT DELETE ON ayan_dev.* to 'ayan_dev_user'@'localhost';
GRANT UPDATE ON ayan_dev.* to 'ayan_dev_user'@'localhost';
GRANT SELECT ON ayan_prod.* to 'ayan_prod_user'@'localhost';
GRANT INSERT ON ayan_prod.* to 'ayan_prod_user'@'localhost';
GRANT DELETE ON ayan_prod.* to 'ayan_prod_user'@'localhost';
GRANT UPDATE ON ayan_prod.* to 'ayan_prod_user'@'localhost';

GRANT SELECT ON ayan_dev.* to 'ayan_dev_user'@'%';
GRANT INSERT ON ayan_dev.* to 'ayan_dev_user'@'%';
GRANT DELETE ON ayan_dev.* to 'ayan_dev_user'@'%';
GRANT UPDATE ON ayan_dev.* to 'ayan_dev_user'@'%';
GRANT SELECT ON ayan_prod.* to 'ayan_prod_user'@'%';
GRANT INSERT ON ayan_prod.* to 'ayan_prod_user'@'%';
GRANT DELETE ON ayan_prod.* to 'ayan_prod_user'@'%';
GRANT UPDATE ON ayan_prod.* to 'ayan_prod_user'@'%';