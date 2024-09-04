package com.template.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hh")
    public String test() {
        System.out.println("Spring Reload");
        return "Hello WOOD??";
    }

    @GetMapping("/hello-template")
    public String teste() {
        System.out.println("Spring Reload");
        return "hello-template";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    } 

    @GetMapping("hello-spring")
    @ResponseBody
    public String getMethodName(@RequestParam("name") String name) {
        return "바보 " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public WOOD helloApi(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("phone") int phone) {
        WOOD ping = new WOOD();
        ping.setName(name);
        ping.setAge(age);
        ping.setPhone(phone);
        return ping;
    }

    public class WOOD {
        private String name;
        private int age;
        private int phone;
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }

        public int getPhone() {
            return phone;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }
    }
}
