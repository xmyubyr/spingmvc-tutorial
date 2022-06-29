package com.example.getfileResource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix ="server.person")
@Component
public class PersonConfiguration {
    private String name;
    private String sex;
    private int age;

    private Map<String,String> group;

    public Map<String, String> getGroup() {
        return group;
    }

    public void setGroup(Map<String, String> group) {
        this.group = group;
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        System.out.println(sex);
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        System.out.println(age);
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getGroupManager(){
        return this.getGroup().get("manager");
    }
}
