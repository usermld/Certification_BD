package com.example.Animals;

import java.util.ArrayList;

public class Animal {
    private String name;
    private ArrayList commands = new ArrayList<String>();
    private String dateOfBirth;

    public Animal(String name, String date){
        setName(name);
        setDateOfBirth(date);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getCommands() {
        return commands.toString();
    }

    private void setCommands(String commands) {
        this.commands.add(commands);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    private void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Animal {" +
                "name = '" + name + '\'' +
                ", commands = " + commands.toString() +
                ", dateOfBirth = '" + dateOfBirth + '\'' +
                '}';
    }
}
