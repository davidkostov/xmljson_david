package com.clouway.main;

import com.clouway.translators.JsonTranslator;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Main {
    public static void printPeopleStats(List<Person> people) {
        Integer numberOfPeople = people.size();
        Integer agesSum = 0;
        for (Person person : people) {
            agesSum += person.getAge();
        }
        System.out.println("Users Count: " + numberOfPeople);
        System.out.println("Average Age: " + agesSum / numberOfPeople);
    }

    public static void main(String args[]) {
        UsageConfiguration config = new UsageConfiguration(args);
        if (config.isJson()) {
            JsonTranslator translator = new JsonTranslator();
            List<Person> people;
            try {
                people = translator.toObjectFromFile(new File(args[2]), new TypeReference<List<Person>>() {
                });
                if (config.printsAverage()) {
                    printPeopleStats(people);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else System.out.println("Incorrect arguments provided...");
    }
}
