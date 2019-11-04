# Applications:  

Server : Spring boot webflux application. It does the arithematic operations. All the methods are rest endpoints(ServerController.java). Logging is handled using Spring AOP (LoggingAspect.java). Integration test(ServerApplicationControllerTests.java) & unit test (ServerServiceImplTest.java).  

Client: Spring boot webflux application which calls the server endpoint using WebClient. The call is forwarded to server using Zuul proxy. All the methods are rest endpoints(ClientController.java). Logging is handled using Spring AOP (LoggingAspect.java). Integration test (ClientApplicationControllerTests.java).  

TBD: Swagger integration. Service registration & discovery using Eureka. Load balancing with Ribbon. ELK   
