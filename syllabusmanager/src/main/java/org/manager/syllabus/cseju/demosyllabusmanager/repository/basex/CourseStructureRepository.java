package org.manager.syllabus.cseju.demosyllabusmanager.repository.basex;

import org.manager.syllabus.cseju.demosyllabusmanager.basex.BaseXService;
import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;
import org.manager.syllabus.cseju.demosyllabusmanager.services.jaxb.JAXBServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;

public class CourseStructureRepository {
    private BaseXService baseXService;
    private JAXBServices jaxbServices;

    @Autowired
    public CourseStructureRepository() {
        this.baseXService = new BaseXService();
        this.jaxbServices = new JAXBServices();
    }

    /**
     * Creates the database to store the form info
     *
     * @param databaseName
     */
    public void createDatabase(String databaseName) {
        CourseStructure courseStructure = new CourseStructure();
        courseStructure.setName("");
        courseStructure.setContentBundleList(new ArrayList<>());

        baseXService.createDatabase(databaseName,
                jaxbServices.objectToXmlString(courseStructure, true));
    }

    /**
     * Creates the database with user initial input
     *
     * @param databaseName
     * @param courseStructure
     */
    public void createDatabase(String databaseName, CourseStructure courseStructure) {
        baseXService.createDatabase(databaseName,
                jaxbServices.objectToXmlString(courseStructure, true));
    }

    /**
     * Delete database
     *
     * @param databaseName
     */
    public void deleteDatabase(String databaseName) {
        baseXService.stopAndDeleteService(databaseName);
    }
}
