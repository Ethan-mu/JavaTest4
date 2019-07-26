# 启动说明

### 1.执行build.sh
### 2.执行start.sh
### 3.执行curl.sh
### 4.执行stop.sh
### 5:Exam2的pagehelp在exam1中实现了，都在curl中以shell方式进行访问，curl里面也有对应的说明
### docker-compse启动的mysql有可能在web连接不上，不晓得什么原因，jdbc:mysql://mysql:3306/  ip我写的是mysql服务名

要是出现连接不到的情况，就只能连接本地的数据库，在application.properties中修改数据库用户名和密码
