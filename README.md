# Udemy-Spring5Webapp - Section 3
Dependency Injection with Spring

# SOLID Principles of OOP

   https://devopedia.org/solid-design-principles
   
# Using Dependency Injection 
   1. Using Property Based (least preferred)
   2. Using Setter Based (Area of Much Debate)
   3. Using Constructor based (Most Preferred)   
   
-  Use of  @Qualifier to define which you need to take 
   As there are multiple classes that cam implement the interface so this is 
   to context know which bean object need to pick. 
   
- Primary Beans
   @Primary 
   when no qualifier is defined , it will automatically take the primary bean
   
# Spring Profiles 
   Control your application in different Runtime Environment. <br>
   @Profile - using to set the profile of the class/service <br>
    spring.profiles.active - need to set in properties. 
 
 - Default Profile 
 
# Spring Bean Lifecycle

