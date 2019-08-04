package org.manager.syllabus.cseju.demosyllabusmanager.repository.basex;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.manager.syllabus.cseju.demosyllabusmanager.basex.BaseXService;
import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;
import org.manager.syllabus.cseju.demosyllabusmanager.services.jaxb.JAXBServices;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
public class CourseStructureRepository {
    private BaseXService baseXService;
    private JAXBServices jaxbServices;

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
