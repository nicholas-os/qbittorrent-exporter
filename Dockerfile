FROM ubuntu:25.10

COPY build/install/qbittorrent-exporter /opt/qbittorrent-exporter
ENTRYPOINT ["/opt/qbittorrent-exporter/bin/qbittorrent-exporter"]

EXPOSE 17871
