## Selenium Grid

#### Download Selenium Server jar: [Selenium 4.16](https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.16.0/selenium-server-4.16.0.jar)

#### Open a new terminal:
#### Start the Hub: 

```
sudo java -jar selenium-server-4.15.0.jar hub

```


##### Start the Firefox Node: 
###### Open a new terminal:
```
java -jar selenium-server-4.15.0.jar node --hub http://localhost:4444 --port 5555
```

##### Start the Chrome Node: 
###### Open a new terminal:
```
java -jar selenium-server-4.15.0.jar node --hub http://localhost:4444 --port 5556
```

#### Run Your Project:
```
sudo docker build -t selenium-grid-maven-project .
sudo docker run -it selenium-grid-maven-project
```
