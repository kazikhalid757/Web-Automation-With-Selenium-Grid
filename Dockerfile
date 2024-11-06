# # Use an official Maven image as a parent image
# FROM maven:3.8.4-openjdk-11

# # Set the working directory
# WORKDIR /usr/src/app

# # Install necessary packages
# RUN apt-get update \
#     && apt-get install -y \
#         firefox-esr \
#         wget \
#         bzip2 \
#         xvfb \
#         libdbus-glib-1-2 \
#     && rm -rf /var/lib/apt/lists/*

# # Install GeckoDriver v0.33.0
# RUN wget -q https://github.com/mozilla/geckodriver/releases/download/v0.33.0/geckodriver-v0.33.0-linux64.tar.gz \
#     && tar -xzf geckodriver-v0.33.0-linux64.tar.gz -C /usr/local/bin/ \
#     && rm geckodriver-v0.33.0-linux64.tar.gz \
#     && chmod +x /usr/local/bin/geckodriver

# # Copy the pom.xml file and download dependencies
# COPY pom.xml .

# # Download dependencies
# RUN mvn dependency:resolve

# # Copy the rest of the application
# COPY . .

# # Copy the selenium server jar
# COPY selenium-server-4.15.0.jar /usr/src/app/selenium-server-4.15.0.jar

# # Start the Selenium Grid Hub and Node with maxSessions set to 5
# CMD ["sh", "-c", "java -jar /usr/src/app/selenium-server-4.15.0.jar hub & sleep 5 && java -jar /usr/src/app/selenium-server-4.15.0.jar node --max-sessions 5 --hub http://localhost:4444 --port 5555 & sleep 5 && mvn clean test"]
# Use an official Maven image as a parent image

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
COPY pom.xml .

# Download dependencies
RUN mvn dependency:resolve

# Copy the rest of the application
COPY . .

# Start the Selenium Grid Hub and Node with maxSessions set to 10
CMD ["sh", "-c", "java -jar /usr/src/app/selenium-server-4.15.0.jar hub & sleep 10 && java -jar /usr/src/app/selenium-server-4.15.0.jar node --max-sessions 10 --hub http://localhost:4444 --port 5555 & sleep 10 && mvn clean test"]
