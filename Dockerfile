FROM jeanblanchard/java:8
MAINTAINER Kiet T. Tran
COPY target/rest-example-0.1.0.jar rest-example-0.1.0.jar
CMD java -jar rest-example-0.1.0.jar
EXPOSE 8181