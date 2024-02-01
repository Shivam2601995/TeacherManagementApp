FROM openjdk:11-jdk-slim
WORKDIR /app
COPY src /app/
RUN javac -d . Teacher.java TeacherOperations.java TeacherManagementApp.java
CMD ["java", "services.TeacherManagementApp"]