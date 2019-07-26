chmod +x start.sh
chmod +x curl.sh
chmod +x stop.sh
mvn package -Dmaven.test.skip=true
cp ./target/exam1-0.0.1-SNAPSHOT.jar ./docker/java/