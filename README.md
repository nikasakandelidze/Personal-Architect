Project Name:  Personal Architect

##	See scripts/mvp.sh for minimalistic mvp of the project


MVP Language Support: Java

MVP Language infrastructure: Spring boot

The problem:  Most of CRUD the applications starts up the in the same state, with several packages for different layers of an appliaction(these layers seggregated either in packages,java modules or build system modules) and apart from core business logic that needs to be implemented later, so called "infrastructure" parts are mainly same. Why waste time writing classes and interfaces of controllers, services, providers, storages and all the usecases  of different domains, when it can be automated.


Description:
	Idea consists of Frontend + Backend.
	
Like the Spring Initializer web application, there can be a more user friendly client side where between several cases might be graphical interface of layers + horizontal usecases of different services.

	
For mvp: 

We can use Console/Terminal as a front end for the applciation. By asking user simple questions we can then using shell generate folder&files hierarchy.	

What are types of questions:

 - What type of architecture you want? 

(1) Layered

(2) Hexagonal

(....)

 - List several domain objects you will have(seperated by comma)
 
 - List several usecases for each Domain objects.
  ! Maybe user 

 - List several KeyWords for special functionalities that your app should have. 
 
## Considerations
	Let's use reactive streams
    Let's use Spring Shell project
