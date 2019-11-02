# Applications:  

Server : Spring boot webflux application. It does the arithematic operations and all the methods are rest endpoints(ServerController.java). Logging is handled using Spring AOP (LoggingAspect.java).  

Client: Spring boot webflux application which calls the server endpoint using WebClient. All the methods are rest endpoints(ClientController.java). Logging is handled using Spring AOP (LoggingAspect.java).  
