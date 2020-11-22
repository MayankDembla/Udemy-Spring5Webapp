package com.ayan.spring.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(value = "/hi", method = RequestMethod.GET)
public class BaseController {

    // ## Get Post ## //

    // Testing a Get method ...
    @GetMapping(value = {"/test", ""})
    public String testget() {
        return "Hello World";
    }

    // ## RequestBody ##

    // Testing a Post method and RequestBody ....
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String testpost(@RequestBody String text) {
        System.out.println("You entered : " + text);
        return text;
    }

    // ## Path Variable ## //

    // Testing Path variable in post request ...
    @RequestMapping(value = "/path/{id}", method = RequestMethod.POST)
    public String usepathvarpost(@PathVariable("id") long id, @RequestBody String body) {
        System.out.println("You entered Id is " + id);

        return String.valueOf(id) + " - " + body;
    }

    // Testing Path variable in Get Request ...
    @RequestMapping(value = "/patg/{id}", method = RequestMethod.GET)
    public String usepathvariableget(@PathVariable("id") long id) {
        System.out.println("You entered Id is " + id);

        return String.valueOf(id);
    }

    // ## Request Param ##

    // Testing the Request Params with Post request
    @RequestMapping(value = "/postrp/{id}", method = RequestMethod.POST)
    public String testRequestMapping(@RequestParam("id") long qid, @PathVariable long id, @RequestBody String body) {

        return "Request Param : " + String.valueOf(qid) +
                " Path Variable : " + String.valueOf(id) +
                " Request Body  : " + body;
    }

    // Testing Request Param with Get Request
    @RequestMapping(value = "/postrpg/{id}", method = RequestMethod.GET)
    public String testRequestParamget(@RequestParam(defaultValue = "90") long qid, @PathVariable("id") long id) {
        return "Sum is : " + String.valueOf(qid + id);
    }

    // ## Request Header ## //

    // Get using the Header - key-value pair
    @GetMapping("/reqheader")
    public String testRequestHeaderGet(@RequestHeader("key") String value, @RequestParam Integer key) {
        return String.valueOf(value) + " - " + key;
    }

    // POST using the Header - key-value pair
    @PostMapping("/reqheaderpost/{pid}")
    public String testRequestHeaderPost(@RequestHeader("key") String value, @RequestBody String body,
                                        @PathVariable Integer pid, @RequestParam String param) {

        return " Header key : " + value + " Body : " + body
                + " Path Var : " + pid + " Request Param + " + param;

    }
}
