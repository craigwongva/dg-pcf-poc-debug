import it.geosolutions.geoserver.rest.GeoServerRESTReader
import it.geosolutions.geoserver.rest.GeoServerRESTPublisher

import groovy.json.*
import java.sql.*

class PromptController {

    Connection conn
    def jsonSlurper
    String geoserverPassword

    PromptController() {
/*
        Class.forName("org.h2.Driver");
        conn = DriverManager.
            getConnection("jdbc:h2:tcp://localhost/~/valuechick", "sa", "");
*/
	Class.forName("org.postgresql.Driver");
        conn = DriverManager.
            getConnection("jdbc:postgresql://xxxxxcl-postgis-db.cqxwozfxb9q7.us-east-1.rds.amazonaws.com:5432/coastline", "foo", "bar");
    }

    String getproperty(desiredProp) { //e.g. geoserverPassword
	String returnValue
	String s = System.getenv('MAVEN_CMD_LINE_ARGS')
	def t = s.split('-D')
	t.each { u ->
	    def v = u.split('=')
	    //Any ampersand in the password must be escaped like this \& 
	    if (v[0] == desiredProp)  {
		//kludge to handle embedded equal sign in password:
		if ((v.size()) == 2) { //e.g. -DgeoserverPassword=abc=def
		    returnValue = v[1]
		}
		if ((v.size()) == 3) { //e.g. -DgeoserverPassword=abc=def
		    returnValue = v[1]+'='+v[2]
		}
	    }
	}
        returnValue
    }

    def myIP() {
        def myprocess = [ 'bash', '-c', "curl http://169.254.169.254/latest/meta-data/public-ipv4" ].execute()
        myprocess.waitFor()
        String myprocessAsText = myprocess.text

        render myprocessAsText
    }

 def env() {
  def env = System.getenv()
  String s = ''
  env.each {
   s += "$it\n"
  }
  println s
  println ""
  println getproperty('geoserverPassword')
  render "I am env(). See controller output for env variables."
 }

 def index() { 
/*
  //this is a temporary server, managed via secgrp,
  // using well-publicized user/password
  //String RESTURL  = "http://35.166.184.150/geoserver" 
  String RESTURL  = "http://172.31.9.205:80/geoserver" 
  //String RESTURL  = "http://localhost:8080/geoserver";
  String RESTUSER = "admin";
  String RESTPW   = getproperty('geoserverPassword')
  GeoServerRESTReader reader = new GeoServerRESTReader(RESTURL, RESTUSER, RESTPW);
  GeoServerRESTPublisher publisher = new GeoServerRESTPublisher(RESTURL, RESTUSER, RESTPW);
  boolean created = publisher.createWorkspace("FridWorkspace")
  println created
*/
  println "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"
  render "srrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr"

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
