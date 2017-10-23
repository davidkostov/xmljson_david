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
            translator.toXmlFile(new Person(29, "Bob"), "TranslatedObject.xml", "Person");
            File file = new File("TranslatedObject.xml");
            Person person = translator.toObjectFromFile(file);

            assertThat(person.getAge(), equalTo(29));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void objectToXmlStringThanReverseAndUseObject() {
        translator.alias("Person", Person.class);

        String xmlString = translator.toXmlString(new Person(29, "Bob"), "Person");
        Person person = translator.toObjectFromString(xmlString);

        assertThat(person.getName(), equalTo("Bob"));
    }

    @Test
    public void xmlStringToObject() {
        translator.alias("Person", Person.class);

        String xmlString = "<Person>\n" +
                "  <age>29</age>\n" +
                "  <name>Bob</name>\n" +
                "</Person>";

        Person person = translator.toObjectFromString(xmlString);

        assertThat(person.getAge(), equalTo(29));
    }

}
