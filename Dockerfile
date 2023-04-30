# Build the project
FROM maven:latest as builder
COPY pom.xml    /usr/local/build/pom.xml
COPY src        /usr/local/build/src
WORKDIR         /usr/local/build
RUN mvn clean compile war:war

# Install Tomcat 7 & openjdk 8
FROM tomcat:7.0.57-jre8

WORKDIR /usr/local/tomcat/webapps

# Remove default application
RUN rm -r ./docs && rm -r ./examples && rm -r ./host-manager && rm -r ./manager && rm -r ./ROOT

# Copy application war file to tomcat directory
COPY --from=builder /usr/local/build/target/*.war ./ROOT.war

# Unzip war file to have place to put 'file' directory
RUN unzip ROOT.war -d ROOT

RUN mkdir ROOT/file && chmod -c 764 ROOT/file

VOLUME [ "/usr/local/tomcat/webapps/ROOT/file" ]

EXPOSE 8080

CMD ["catalina.sh", "run"]