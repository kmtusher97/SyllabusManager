package org.manager.syllabus.cseju.demosyllabusmanager.services;

import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.ContentBundle;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.Table;
import org.manager.syllabus.cseju.demosyllabusmanager.repository.CourseStructureRepository;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public class CourseStructureServicesImplementation implements CourseStructureServices {

    private CourseStructureRepository courseStructureRepository = new CourseStructureRepository();

    private ContentServices contentServices = new ContentServicesImplementation();

    @Override
    public void saveCourseStructure(CourseStructure courseStructure, String filename) throws JAXBException {
        courseStructureRepository.saveCourseStructure(courseStructure, filename);
    }

    @Override
    public CourseStructure getCourseStructure(String filename) throws JAXBException, FileNotFoundException {
        return courseStructureRepository.getCourseStructure(filename);
    }

    @Override
    public void addNewContentBundle(String filename) throws JAXBException, FileNotFoundException {
        CourseStructure courseStructure = courseStructureRepository.getCourseStructure(filename);

        List<ContentBundle> contentBundleList = courseStructure.getContentBundleList();

        ContentBundle contentBundle = new ContentBundle(0);
        contentBundle.setTextArea(contentServices.getInitialTextArea());
        contentBundle.setTable(contentServices.getInitialTable());

        contentBundleList.add(contentBundle);

        courseStructure.setContentBundleList(contentBundleList);

        courseStructureRepository.saveCourseStructure(courseStructure, filename);
    }

    @Override
    public void deleteContentBundleRow(Integer id, String filename) throws JAXBException, FileNotFoundException {
        CourseStructure courseStructure = courseStructureRepository.getCourseStructure(filename);

        List<ContentBundle> contentBundleList = courseStructure.getContentBundleList();

        contentBundleList.remove((int) id);

        courseStructure.setContentBundleList(contentBundleList);

        courseStructureRepository.saveCourseStructure(courseStructure, filename);
    }

    @Override
    public void addNewFieldInTable(Integer tableNo, String filename) throws JAXBException, FileNotFoundException {
        CourseStructure courseStructure = courseStructureRepository.getCourseStructure(filename);

        List<ContentBundle> contentBundleList = courseStructure.getContentBundleList();

        ContentBundle contentBundle = contentBundleList.get(tableNo);

        Table table = contentBundle.getTable();

        table.addNewField();
        contentBundle.setTable(table);
        contentBundleList.set(tableNo, contentBundle);
        courseStructure.setContentBundleList(contentBundleList);

        courseStructureRepository.saveCourseStructure(courseStructure, filename);
    }

    @Override
    public void deleteFieldNameFromTable(Integer tableNo, Integer fieldNo, String filename) throws JAXBException, FileNotFoundException {
        CourseStructure courseStructure = courseStructureRepository.getCourseStructure(filename);

        List<ContentBundle> contentBundleList = courseStructure.getContentBundleList();

        ContentBundle contentBundle = contentBundleList.get(tableNo);

        Table table = contentBundle.getTable();

        table.deleteFieldName((int) fieldNo);

        contentBundle.setTable(table);
        contentBundleList.set(tableNo, contentBundle);
        courseStructure.setContentBundleList(contentBundleList);

        courseStructureRepository.saveCourseStructure(courseStructure, filename);
    }


}
