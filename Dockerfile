FROM 24.0.1_9-jre-ubi9-minimal

COPY dist/*.jar /opt/qbittorrent-exporter.jar

EXPOSE 17871/tcp

ENTRYPOINT ["java", "-jar", "/opt/qbittorrent-exporter.jar"]
