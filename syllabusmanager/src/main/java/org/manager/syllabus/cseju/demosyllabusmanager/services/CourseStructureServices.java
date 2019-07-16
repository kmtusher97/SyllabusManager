package org.manager.syllabus.cseju.demosyllabusmanager.services;

import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CourseStructureServices {

    void saveCourseStructure(CourseStructure courseStructure, String filename) throws JAXBException;

    CourseStructure getCourseStructure(String filename) throws JAXBException, FileNotFoundException;

    void addNewContentBundle(String filename) throws JAXBException, FileNotFoundException;

    void deleteContentBundleRow(Integer id, String filename) throws JAXBException, FileNotFoundException;
}
