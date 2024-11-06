# Use Maven with OpenJDK 11 as the base image
FROM maven:3.8.4-openjdk-11

# Set the working directory
WORKDIR /usr/src/app

# Install necessary packages
RUN apt-get update \
    && apt-get install -y \
        firefox-esr \
        wget \
        bzip2 \
        xvfb \
        libdbus-glib-1-2 \
    && rm -rf /var/lib/apt/lists/*

# Install GeckoDriver v0.33.0
RUN wget -q https://github.com/mozilla/geckodriver/releases/download/v0.33.0/geckodriver-v0.33.0-linux64.tar.gz \
    && tar -xzf geckodriver-v0.33.0-linux64.tar.gz -C /usr/local/bin/ \
    && rm geckodriver-v0.33.0-linux64.tar.gz \
    && chmod +x /usr/local/bin/geckodriver

# Copy the pom.xml file and download dependencies
COPY pom.xml ./
COPY selenium-server-4.15.0.jar ./
RUN mvn dependency:resolve

# Copy the rest of the application
COPY . .

# Expose ports for Selenium Hub and Node
EXPOSE 4444
EXPOSE 5555
# Start the Selenium Hub and Node in the background
CMD ["sh", "-c", "java -jar selenium-server-4.15.0.jar hub & java -jar selenium-server-4.15.0.jar node --hub http://localhost:4444 --port 5555 & sleep 5 && mvn clean test"]