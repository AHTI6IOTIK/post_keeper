FROM tomcat:9.0.73-jdk17-corretto

COPY . /var/www

WORKDIR /var/www

RUN chmod +x ./gradlew
RUN ./gradlew bootWar

RUN cp build/libs/post_keeper.war "$CATALINA_HOME"/webapps/ROOT.war

CMD ["catalina.sh", "run"]
