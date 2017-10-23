package com.clouway.translators;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class XmlTranslator {

    private XStream xstream = null;

    public XmlTranslator() {
        xstream = new XStream();
        xstream.ignoreUnknownElements();
    }

    public void toXmlFile(Object object, String fileName, String rootName) throws IOException {
        xstream.alias(rootName, object.getClass());
        FileWriter writer = new FileWriter(fileName);
        xstream.toXML(object, writer);
        writer.close();
    }

    public String toXmlString(Object object, String rootName) {
        xstream.alias(rootName, object.getClass());
        return xstream.toXML(object);
    }

    public <T> T toObjectFromString(String xml) {
        return (T) xstream.fromXML(xml);
    }

    public <T> T toObjectFromFile(File xmlFile) throws IOException {
        return (T) xstream.fromXML(new FileReader(xmlFile));
    }

    public <T> void alias(String name, Class<T> type){
        xstream.alias(name, type);
    }

}
