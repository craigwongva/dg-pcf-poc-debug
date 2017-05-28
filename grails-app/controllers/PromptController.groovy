import it.geosolutions.geoserver.rest.GeoServerRESTReader
import it.geosolutions.geoserver.rest.GeoServerRESTPublisher

import groovy.json.*
import java.sql.*

class PromptController {

    Connection conn
    def jsonSlurper
    String geoserverPassword

    def getproperty() {
	String s = System.getenv('MAVEN_CMD_LINE_ARGS')
	def t = s.split('-D')
	t.each { u ->
	    def v = u.split('=')
	    if (v[0] == 'alpha') println "alpha is ${v[1]}"
	    if (v[0] == 'beta')  println "beta is ${v[1]}"
	    if (v[0] == 'geoserverPassword')  geoserverPassword = v[1]
	}
        render "Look at println output for getenv() info"
    }

    def myIP() {
        def myprocess = [ 'bash', '-c', "curl http://169.254.169.254/latest/meta-data/public-ipv4" ].execute()
        myprocess.waitFor()
        String myprocessAsText = myprocess.text

        render myprocessAsText
    }

 def index() { 

  //this is a temporary server, managed via secgrp,
  // using well-publicized user/password
  //String RESTURL  = "http://35.166.184.150/geoserver" 
  String RESTURL  = "http://172.31.9.205:80/geoserver" 
  //String RESTURL  = "http://localhost:8080/geoserver";
  String RESTUSER = "admin";
  String RESTPW   = "" //geoserverPassword
  GeoServerRESTReader reader = new GeoServerRESTReader(RESTURL, RESTUSER, RESTPW);
  GeoServerRESTPublisher publisher = new GeoServerRESTPublisher(RESTURL, RESTUSER, RESTPW);
  boolean created = publisher.createWorkspace("FridWorkspace")
  println created

  println "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"
  render "rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr"

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
