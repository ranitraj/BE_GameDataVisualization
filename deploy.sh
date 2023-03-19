#!/bin/bash
ssh -i src/main/resources/videogame-sales-pemKey.pem ubuntu@54.160.120.103 'sudo service tomcat9 stop; cd /opt/tomcat/tomcat9/webapps/'
scp -i src/main/resources/videogame-sales-pemKey.pem target/gamesales-0.0.1-SNAPSHOT.war ubuntu@54.160.120.103:/home/ubuntu/
ssh -i src/main/resources/videogame-sales-pemKey.pem ubuntu@54.160.120.103 'sudo mv gamesales-0.0.1-SNAPSHOT.war /opt/tomcat/tomcat9/webapps/; sudo service tomcat9 start; sleep 10; sudo service tomcat9 stop; cd /opt/tomcat/tomcat9/webapps/; sudo mv gamesales-0.0.1-SNAPSHOT.war ROOT.war; sudo mv gamesales-0.0.1-SNAPSHOT ROOT; sudo service tomcat9 start'