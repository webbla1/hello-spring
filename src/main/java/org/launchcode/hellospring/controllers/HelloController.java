package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at path/hello
//    @GetMapping("hello")
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //Handles request at path/hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles request of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
//        return "Hello, " + name + " in " + language + "!";
//    }

    //Handles request of the form /hello/LaunchCode
     @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
     }

     // /hello/form
     @GetMapping("form")
     public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<label for='languages'></label>" +

                "<select name='language' id='lang'>" +
                    "<option value='english'>English</option>" +
                    "<option value='spanish'>Spanish</option>" +
                    "<option value='french'>French</option>" +
                    "<option value='swahili'>Swahili</option>" +
                    "<option value='italian'>Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
     }

     @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
     @ResponseBody
     public static String createMessage(@RequestParam String name, @RequestParam String language) {
        String greeting = "";
        if (name == null) {
            name = "World";
        }
        if (language.equals("english")) {
            greeting += "Hello";
         } else if (language.equals("spanish")) {
             greeting += "Hola";
         } else if (language.equals("french")) {
             greeting += "Bonjour";
         } else if (language.equals("swahili")) {
             greeting += "Habari";
         } else {
            greeting += "Ciao";
        }
        return greeting + ", " + name + "!";
     }
}
