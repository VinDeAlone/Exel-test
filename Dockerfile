FROM openjdk:17-alpine
WORKDIR /opt
ENV port=2009
EXPOSE 2009
COPY /exel2.xlsx /opt/exel2.xlsx
COPY /target/exel-test.jar /opt/exel-test.jar
ENTRYPOINT [ "java", "-jar", "/opt/exel-test.jar" ]