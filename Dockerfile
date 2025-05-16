FROM ubuntu:25.10

COPY dist/qbittorrent-exporter-native /opt/qbittorrent-exporter
ENTRYPOINT ["/opt/qbittorrent-exporter"]

EXPOSE 17871
