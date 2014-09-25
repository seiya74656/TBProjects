# try to delete
CONNECT TO $1 USER _system;
SLEEP 5;
STOP DATABASE;
SLEEP 5;
DELETE DATABASE $1;
SLEEP 5;
# try to create but looks like on SSD the scriot is to fast.
# and get some error can't create but it creates
CREATE DATABASE $1;
SLEEP 15;
CONNECT TO $1 USER _system;
SLEEP 5;
CREATE USER $2;
SET PASSWORD $3 USER $2;
CREATE SCHEMA $2 AUTHORIZATION $2;
DISCONNECT ALL;
