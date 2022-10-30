FROM jdk-8u161:v1

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN mkdir -p /data/logs/

ADD slack-off-at-work.jar /slack-off-at-work.jar

ENV JAVA_OPTS=""
ENV JAVA_ARGS=""
ENTRYPOINT java ${JAVA_OPTS} ${JAVA_ARGS} -Dlog4j2.formatMsgNoLookups=true -Djava.security.egd=file:/dev/./urandom -jar /slack-off-at-work.jar