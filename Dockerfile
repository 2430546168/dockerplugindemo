## Docker image for springboot application
## VERSION 0.0.1
## Author: bolingcavalry
#
#### 基础镜像，使用alpine操作系统，openjkd使用8u201
#FROM openjdk:8u201-jdk-alpine3.9
#
##作者
#MAINTAINER BolingCavalry <zq2599@gmail.com>
#
##系统编码
#ENV LANG=C.UTF-8 LC_ALL=C.UTF-8
#
##声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
#VOLUME /tmp
#
##应用构建成功后的jar文件被复制到镜像内，名字也改成了app.jar
#ADD target/dockerplugindemo-0.0.1-SNAPSHOT.jar app.jar
#
##启动容器时的进程
#ENTRYPOINT ["java","-jar","/app.jar"]
#
##暴露8080端口
#EXPOSE 8080

FROM java:8
#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /tmp

#应用构建成功后的jar文件被复制到镜像内，名字也改成了app.jar
ADD target/dockerplugindemo-0.0.1-SNAPSHOT.jar app.jar

#启动容器时的进程
ENTRYPOINT ["java","-jar","/app.jar"]

##暴露8080端口
EXPOSE 8081

#FROM openjdk:8-jdk-alpine
##项目所依赖的镜像
#ADD target/*.jar app.jar
##将maven构建好的jar添加到镜像中
#EXPOSE 8080
##暴露的端口号
#ENTRYPOINT ["java","-jar","/app.jar"]
##镜像所执行的命令

