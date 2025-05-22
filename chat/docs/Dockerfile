# 使用官方OpenJDK 8基础镜像（Alpine或Debian精简版）
FROM openjdk:8-jdk-alpine
# 或者使用Debian基础镜像（如需更完整的工具链）：
# FROM openjdk:8-jre-slim

# 设置工作目录（避免使用root目录）
WORKDIR /app

# 1. 复制JAR文件到容器
# 假设JAR文件在构建上下文的target/目录下
COPY chat-app.jar app.jar

# 2. 可选：复制外部配置文件（如果需要覆盖默认配置）
# COPY config/application.properties /config/

# 3. 设置JVM参数（根据需求调整）
ENV JAVA_OPTS="-Xms256m -Xmx512m -Dspring.profiles.active=dev"
# 对于微服务，可添加DNS缓存设置：
# ENV JAVA_OPTS="$JAVA_OPTS -Dsun.net.inetaddr.ttl=60"

# 4. 暴露端口（与application.yml中配置一致）
EXPOSE 8591

# 5. 启动命令（使用exec形式避免信号拦截问题）
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

# 6. 可选健康检查（Spring Boot Actuator需配置）
#HEALTHCHECK --interval=30s --timeout=3s \
#  CMD wget -q -T 3 -O /dev/null http://localhost:8080/actuator/health || exit 1