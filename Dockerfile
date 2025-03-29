#Use openJdk 17 image from Docker Hub
FROM openjdk:17
#set working directory inside the container
WORKDIR /app
#copy compiled java application jar file to container
COPY ./target/BankingApp /app
#Expose the port on which the springboot application will run
EXPOSE 8080
#Command to run the application
CMD ["java", "-jar", "BankingApp.jar"]