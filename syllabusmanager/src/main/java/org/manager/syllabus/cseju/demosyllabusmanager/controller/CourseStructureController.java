package org.manager.syllabus.cseju.demosyllabusmanager.controller;

import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.ContentBundle;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.Table;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.TextArea;
import org.manager.syllabus.cseju.demosyllabusmanager.services.ContentServices;
import org.manager.syllabus.cseju.demosyllabusmanager.services.ContentServicesImplementation;
import org.manager.syllabus.cseju.demosyllabusmanager.services.CourseStructureServices;
import org.manager.syllabus.cseju.demosyllabusmanager.services.CourseStructureServicesImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path = "/cs")
public class CourseStructureController {

    private String filename = "test";

    private CourseStructureServices courseStructureServices = new CourseStructureServicesImplementation();

    @GetMapping("/design/**")
    public ModelAndView showCourseStructureDesignPage() throws JAXBException, FileNotFoundException {
        ModelAndView courseStructureDesignModelAndView = new ModelAndView("CourseStructureDesignPage");

        CourseStructure courseStructure = courseStructureServices.getCourseStructure(filename);

        courseStructureDesignModelAndView.addObject("courseStructure", courseStructure);

        return courseStructureDesignModelAndView;
    }

    @GetMapping("/addRow")
    public ModelAndView addNewContentRow() throws JAXBException, FileNotFoundException {
        courseStructureServices.addNewContentBundle(filename);
        return new ModelAndView("redirect:/cs/design/new_row_added");
    }

    @GetMapping("/deleteRow/{id}")
    public ModelAndView deleteContentRow(@PathVariable("id") Integer id) throws JAXBException, FileNotFoundException {
        System.err.println(id);
        courseStructureServices.deleteContentBundleRow(id, filename);
        return new ModelAndView("redirect:/cs/design/row_" + id + "_deleted");
    }

    @GetMapping("/init")
    public ModelAndView init() throws JAXBException {
        CourseStructure courseStructure = new CourseStructure();
        List<ContentBundle> contentBundleList = new ArrayList<>();
        ContentBundle contentBundle = new ContentBundle();
        contentBundle.setSelected(0);
        contentBundle.setTextArea(new TextArea("Untitled Text Area", "Empty Text Body"));
        contentBundle.setTable(new Table("Untitled Text Table", Arrays.asList("Field1", "Field2")));

        contentBundleList.add(contentBundle);
        courseStructure.setContentBundleList(contentBundleList);
        courseStructure.setName("Theory");
        courseStructureServices.saveCourseStructure(courseStructure, filename);

        return null;
    }

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("str", "Initial String");
        return modelAndView;
    }

    @GetMapping("/testReq")
    public ModelAndView testReq() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("str", "Response request :)");
        return modelAndView;
    }
}
