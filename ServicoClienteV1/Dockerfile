FROM openjdk:11
ADD target/ServicoClienteV1-1.0.0.jar ServicoClienteV1-1.0.0.jar
RUN mkdir -p /usr/src/es-banco
WORKDIR /usr/src/es-banco
EXPOSE 8081
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Duser.timezone=EC", "-jar", "ServicoClienteV1-1.0.0.jar"]
ENTRYPOINT [ "java","-jar","/ServicoClienteV1-1.0.0.jar" ]