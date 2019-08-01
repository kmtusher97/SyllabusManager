package org.manager.syllabus.cseju.demosyllabusmanager.services.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBServices {

    private final int CUT_INDEX = 55;

    public <Obj> String objectToXmlString(Obj object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance((Class<Obj>)object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(object, stringWriter);

            return (stringWriter.toString()).substring(CUT_INDEX);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <Obj> Object xmlStringToObject(String xmlObject, Obj object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance((Class<Obj>)object.getClass());
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader stringReader = new StringReader(xmlObject);
            return (Obj) unmarshaller.unmarshal(stringReader);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
