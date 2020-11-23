# Spring MVC BaelDung 
Learning Spring 

## Request Annotations ##

1. @RequestMapping 
   marks request handler methods inside @Controller classes   
   @Controller + @Responsebody - @RestController 
   
2. @RequestBody 
     - which maps the body of the HTTP request to an object

3. @PathVariable 
   method argument is bound to a URI template variable
   localhost:8081/hi/path/12
   
4. @RequestParam - accessing HTTP request parameters:
    localhost:8081/hi/postrpg/13?id=90
    
5. @RequestHeader - for key value header 
    Header key : value 
    
6. @CookieValue - TODO

## Response Annotations ##

1. @ResponseBody

2. @ExceptionHandler - Handles the Exception in Controller as a Custom one.

3. @ResponseStatus - use along with Exception handler.