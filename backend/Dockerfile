# Gebruik een basisafbeelding met de juiste Java-versie (bijv. OpenJDK)
FROM openjdk:19

# Stel de werkdirectory in binnen de container
WORKDIR /app

# Kopieer de jar van je Spring Boot-toepassing naar de container
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

# Expose de poort waarop je Spring Boot-toepassing draait (standaard 8080)
EXPOSE 8090

# Geef het commando op om je Spring Boot-toepassing uit te voeren
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
