# Steps to setup and run the project. General overview.

## Download and Install Gradle
	You will need gradle to use the project. Download gradle from: https://gradle.org/install/

## Modules
	Modules: domain - domain models, usecases, basic business-logic of the app.
	         service - service, business cases  wrapped around the "domain" module.
		 web - outer most, web layer, deals with http requests and talking with client.
		 storage - storage, takes care of persistence of the application.
		 cli - alternative front-end to web Client/JS, using command line interface

## Runing project with REST endpoints
	```
	gradle :web:bootRun
	``` 
