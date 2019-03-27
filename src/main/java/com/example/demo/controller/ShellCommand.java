package com.example.demo.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellCommand {

    @ShellMethod("Say hi")
    public String sayHi(String name) {
        return String.format("Hi %s", name);
    }

}
