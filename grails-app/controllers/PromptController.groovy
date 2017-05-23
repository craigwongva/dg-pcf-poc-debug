import it.geosolutions.geoserver.rest.GeoServerRESTReader
import it.geosolutions.geoserver.rest.GeoServerRESTPublisher
//import groovy.json.*

class PromptController {

 def index() { 
/*
  String RESTURL  = "http://35.166.184.150/geoserver"
  //String RESTURL  = "http://localhost:8080/geoserver";
  String RESTUSER = "admin";
  String RESTPW   = "geoserver";
  GeoServerRESTReader reader = new GeoServerRESTReader(RESTURL, RESTUSER, RESTPW);
  GeoServerRESTPublisher publisher = new GeoServerRESTPublisher(RESTURL, RESTUSER, RESTPW);
  boolean created = publisher.createWorkspace("victoryWorkspace")
  println created
*/
  println "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqpost-standupqqqqqqqqqqqqqq"

/*
	def env = System.getenv()
	def vcs = env.grep{it.key=='VCAP_SERVICES'} 
        println "vcs is $vcs"

	//VCAP_SERVICES looks like this:
	//[{"user-provided":[{ "credentials": { "password": "judy", "username": "craig" }, "syslog_drain_url": "", "volume_mounts": [ ], "label": "user-provided", "name": "myups", "tags": [ ] }]}]
	//This is a string:
	//{"user-provided":[{ "credentials": { "password": "judy", "username": "craig" }, "syslog_drain_url": "", "volume_mounts": [ ], "label": "user-provided", "name": "myups", "tags": [ ] }]}
	def jsonSlurper = new JsonSlurper()
	def object = jsonSlurper.parseText(vcs.value[0])
	def credentials = object."user-provided"[0].credentials 
	//credentials looks like this:
	//{password=judy, username=craig}
	[credjson: credentials, 
         credslashstring: credentials.username + '/' + credentials.password ]
  println "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqvictory2qqqqqqqqqqqqqq"
	render "$credentials...${credentials.username}/${credentials.password}"
*/
 }

}
/*

*/
