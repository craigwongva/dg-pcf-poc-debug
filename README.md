cd ~/pillow/my-first-app #see this 5/22/17 -7:30 for URL describing my-first-app
vi grails-app/controllers/PromptController.groovy
mvn clean install
mvn grails:run-app -DgeoserverPassword=mypassword
curl localhost:8080/my-first-app/prompt/index -DgeoserverPassword=\&abc=def for password &abcdef, then look in controller's output for println output
curl localhost:8080/my-first-app/prompt/env #then look in controller's output for println output
curl localhost:8080/my-first-app/prompt/myIP #look in the curl response (not controller's output) for the IP 

https://craig-geomanager-a.apps.coastline.dg-cf-test.net/
https://craig-geomanager-a.apps.coastline.dg-cf-test.net/prompt/env

cd ~/install-cf
./cf push craig-geomanager-3 -p /home/ec2-user/pillow/my-first-app/target/my-first-app-1.0-SNAPSHOT.war 

java -jar h2/bin/h2-1.4.193.jar -webAllowOthers &
