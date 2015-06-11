# cleanarchitecture
CleanAchitecture + Spring + Quartz

This objectives of this project are:

1- Ilustrate Uncle Bob's clean Architecture
2- Practice a bit of Spring
3- Learn about the Quartz framework for scheduling tasks and how to integrate it with Spring.




1- THE CLEAN ARCHITECTURE(https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html)

 In the clean architecture, the core are the entities.
 In my case I placed the entities in a package within the core package.

 The entities will be used in the Use Cases. In my case, my entities used in the Use Case WhatsTheTime.java, indirectly
 via data providers. Notice that those dataproviders used in the Use case are interfaces. This interfaces, as you see are also part of my core package(They are the gateway into the core)
 The Use Case which is also part of the very inner core, can use this data providers and entities as desired.

 The first layer out side of the core, is the adapting layer. In other words, the implementations of the data providers(Bob calls this part Controllers).


 If you go further outside of the core of the application, you will see Spring configurations, the integration with the quartz framework and even a package called entrypoints which
 represents an entry into the system. Anything could go there, Rest, Servlet... but since for this example I wanted to have Scheduled tasks, there is just a QuartzBean in there.

 All communications go from the outside towards the core and never the other way around. And this is what makes this architecture so losely coupled and flexible for extension and easy to mantain.


                 Frameworks---> Controllers --->  UseCase--->  Entities

