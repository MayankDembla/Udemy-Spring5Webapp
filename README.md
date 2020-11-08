# Udemy-Spring5Webapp
Learning Spring
 
# Section 2 : Building a Spring Boot Application 

- Spring Initializr 
- JPA Entities author and book 
- relationships 
- Data Repositories 
- Assignment - publisher and address 
- many to one with author and publisher 
- H2- console 
- Spring MVC - Model View Controller<br> 
     design pattern for GUI and Web Application.<br>
     
     client <-> controller <--> Model(POJO, No Business Logic) & View   
     
     Thymeleaf - take the model and return the html to the client 

     ![alt text](src/main/resources/images/springmvc.png)
     
- Controller  
   Annotate Controller calss with @Controller 
   This will register the class as a Spring Bean and as a Controller in Spring MVC 
   To Map methods to http request paths use @RequestMapping
   
- Create a controller with a requestMapping and use repo for view


- ThymeLeaf 
   Java Template Engine - 2011 - natural template engine(we can view in browser)
    
    To show the list of author and Books, in the template we have implemented some thymeleaf templates.
    
- Pet Clinic   

   Domain Model 
   ![alt text](src/main/resources/images/PetClinic_Domain_Model.png)  
   
   Data Access
    ![alt text](src/main/resources/images/Pet_Clinic_Data_Access.png)
    
   Database
   ![alt text](src/main/resources/images/Pet_Clinic_Database.png)
   
   Bean Profiles 
    ![alt text](src/main/resources/images/Pet_Clinic_BeanProfiles.png)
    
   Caching
   ![alt text](src/main/resources/images/Pet_Clinic_Cache.png) 
   
   Transaction Management 
   ![alt text](src/main/resources/images/PetClinic_Transaction_Management.png)
   
    
   Exception Management 
   ![alt text](src/main/resources/images/PetClinic_Exception_Management.png)
  
   AOP 
   ![alt text](src/main/resources/images/PetClinic_AOP_1.png)
   
   ![alt text](src/main/resources/images/PetClinic_AOP_2.png)
   
   View Resolver 
   ![alt text](src/main/resources/images/PetClinic_ViewResolver.png)
   
   Database Spring MVC 
   ![alt text](src/main/resources/images/PetClinic_DbSpringmvc.png)
   
   Templating
   ![alt text](src/main/resources/images/PetClinic_Templating.png)
   
   Validation 
   ![alt text](src/main/resources/images/PetClinic_Validation.png)
   
   WebJars to add jQuery , ...
   ![alt text](src/main/resources/images/PetClinic_WebJars.png)
   
   Using webjars
   ![alt text](src/main/resources/images/PetClinic_Using_WebJars.png)
      
   Less
   ![alt text](src/main/resources/images/PetClinic_Using_Less.png)
   
   Java Based Configuration
   ![alt text](src/main/resources/images/Pet_Clinic_JavaBasedConfig.png)
   
   Unit Test
   ![alt text](src/main/resources/images/Pet_Clinic_unitTests.png)
   
   
  -  PetClinic Run app - 
   https://github.com/spring-projects/spring-petclinic