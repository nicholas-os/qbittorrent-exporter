FROM ubuntu:25.10

COPY dist/qbittorrent-exporter-native /opt/qbittorrent-exporter

RUN chmod 555 /opt/qbittorrent-exporter

EXPOSE 17871/tcp

ENTRYPOINT ["/opt/qbittorrent-exporter"]


