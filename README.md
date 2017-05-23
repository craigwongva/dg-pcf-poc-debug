cd ~/pillow/my-first-app #see this 5/22/17 -7:30 for URL describing my-first-app
vi grails-app/controllers/PromptController.groovy
mvn clean install
mvn grails:run-app

cd ~/install-cf
./cf push craig-geomanager-3 -p /home/ec2-user/pillow/my-first-app/target/my-first-app-1.0-SNAPSHOT.war 
