@echo off
cd ../
call docker container stop leather-accessories-server
call docker image rm leather-accessories
call docker build -t leather-accessories ./

PAUSE