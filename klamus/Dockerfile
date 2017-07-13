FROM anapsix/alpine-java:8
MAINTAINER Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>

ENTRYPOINT ["java", "-jar", "/usr/share/klamus/klamus.jar"]
CMD ["--spring.config.location=/usr/share/klamus/config/application.properties"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib           /usr/share/myservice/lib
# Add the service itself
ADD target/klamus.jar /usr/share/klamus/klamus.jar
