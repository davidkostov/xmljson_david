package com.clouway.translators;

import com.clouway.main.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class JsonTranslatorTest {

    private JsonTranslator translator = new JsonTranslator();

    @Test
    public void objectToJsonThanReverseAndUseObject() {
        try {
            translator.toJsonFile(new Person(29, "Bob"), "TranslatedObject.json");
            File file = new File("TranslatedObject.json");
            Person person = translator.toObjectFromFile(file, Person.class);

            assertThat(person.getAge(), equalTo(29));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void objectToJsonStringThanReverseAndUseObject() {
        try {
            String jsonString = translator.toJsonString(new Person(29, "Bob"));
            Person person = translator.toObjectFromString(jsonString, Person.class);

            assertThat(person.getName(), equalTo("Bob"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void jsonStringToObjectsList() {
        try {
            String jsonString = "[{\"age\":29,\"name\":\"Bob\"}," +
                    "{\"age\":29,\"name\":\"Bob\"}," +
                    "{\"age\":29,\"name\":\"Bob\"}," +
                    "{\"age\":29,\"name\":\"Bob\"}," +
                    "{\"age\":29,\"name\":\"Bob\"}," +
                    "{\"age\":29,\"name\":\"Bob\"}," +
                    "{\"age\":29,\"name\":\"Bob\"}]\n";

            List<Person> people = translator.toObjectFromString(jsonString, new TypeReference<List<Person>>() {
            });

            assertThat(people.get(1).getAge(), equalTo(29));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
