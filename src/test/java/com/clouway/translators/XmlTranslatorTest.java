package com.clouway.translators;

import com.clouway.main.Person;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class XmlTranslatorTest {

    private XmlTranslator translator = new XmlTranslator();


    @Test
    public void objectToXmlThanReverseAndUseObject() {
        translator.alias("Person", Person.class);
        try {
            translator.toXmlFile(new Person(29, "Bob", "Red"),
                    "src/test/TranslatedObject.xml", "Person");
            File file = new File("src/test/TranslatedObject.xml");
            Person person = translator.toObjectFromFile(file);

            assertThat(person.getAge(), equalTo(29));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void objectToXmlStringThanReverseAndUseObject() {
        translator.alias("Person", Person.class);

        String xmlString = translator.toXmlString(new Person(29, "Bob", "Red"), "Person");
        Person person = translator.toObjectFromString(xmlString);

        assertThat(person.getFirstName(), equalTo("Bob"));
    }

    @Test
    public void xmlStringToObject() {
        translator.alias("Person", Person.class);

        String xmlString = "<Person>\n" +
                "  <age>29</age>\n" +
                "  <firstName>Bob</firstName>\n" +
                "  <lastName>Red</lastName>\n" +
                "</Person>";

        Person person = translator.toObjectFromString(xmlString);

        assertThat(person.getLastName(), equalTo("Red"));
    }

}
