package org.manager.syllabus.cseju.demosyllabusmanager.repository;

import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

public class CourseStructureRepository {



    public void saveCourseStructure(CourseStructure courseStructure, String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CourseStructure.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(courseStructure, new File("storage/structure/" + fileName + ".xml"));
        marshaller.marshal(courseStructure, System.out);
    }

    public CourseStructure getCourseStructure(String filename) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CourseStructure.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        File file = new File("storage/structure/" + filename + ".xml");
        if(!file.exists()) {
            throw new FileNotFoundException("File Not Found");
        }

        CourseStructure courseStructure = (CourseStructure) unmarshaller.unmarshal(file);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        return courseStructure;
    }
}
