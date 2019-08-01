package org.manager.syllabus.cseju.demosyllabusmanager.services.basex;

import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;
import org.manager.syllabus.cseju.demosyllabusmanager.repository.basex.CourseStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseStructureServices {

    private CourseStructureRepository courseStructureRepository;

    @Autowired
    public CourseStructureServices() {
        this.courseStructureRepository = new CourseStructureRepository();
    }

    /**
     * Create xml database form storing form information
     *
     * @param databaseName
     */
    public void createXmlDatabase(String databaseName) {
        courseStructureRepository.createDatabase(databaseName);
    }

    /**
     * Create xml database form storing form information
     * CourseStructure is defined by user initially
     *
     * @param databaseName
     * @param courseStructure
     */
    public void createXmlDatabase(String databaseName, CourseStructure courseStructure) {
        courseStructureRepository.createDatabase(databaseName, courseStructure);
    }




    /**
     * Deletes an xml database
     *
     * @param databaseName
     */
    public void deleteDatabase(String databaseName) {
        courseStructureRepository.deleteDatabase(databaseName);
    }
}
