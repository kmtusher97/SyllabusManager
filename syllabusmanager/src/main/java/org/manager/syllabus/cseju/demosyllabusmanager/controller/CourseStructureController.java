package org.manager.syllabus.cseju.demosyllabusmanager.controller;

import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.Content;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.ContentBundle;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.Table;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.TextArea;
import org.manager.syllabus.cseju.demosyllabusmanager.services.CourseStructureServices;
import org.manager.syllabus.cseju.demosyllabusmanager.services.CourseStructureServicesImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        courseStructureServices.deleteContentBundleRow(id, filename);

        return new ModelAndView("redirect:/cs/design/row_" + id + "_deleted");
    }

    @PostMapping("/autoSave")
    public ModelAndView saveChangesByAutoSave(@RequestBody CourseStructure courseStructure) throws JAXBException {
        courseStructureServices.saveCourseStructure(courseStructure, filename);
       // System.err.println(courseStructure);
        return new ModelAndView("redirect:/cs/design/autoSave");
        //return null;
    }


    @GetMapping("/addFieldTable/{rowId}")
    public ModelAndView addNewFieldInTableContent(@PathVariable("rowId") Integer tableNo) throws JAXBException, FileNotFoundException {
        courseStructureServices.addNewFieldInTable(tableNo, filename);
        return new ModelAndView("redirect:/cs/design/+");
    }

    @GetMapping("/deleteField/{rowId}/{colId}")
    public ModelAndView deleteFieldNameFromTableContent(@PathVariable("rowId") Integer tableNo,
                                                        @PathVariable("colId") Integer fieldNo) throws JAXBException, FileNotFoundException {
        courseStructureServices.deleteFieldNameFromTable(tableNo, fieldNo, filename);

        return new ModelAndView("redirect:/cs/design/-");
    }

    /**
     * Test Functions
     */
    /**
     *
     * @return
     * @throws JAXBException
     */
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

    @PostMapping("/testReq")
    public ModelAndView testReq(@ModelAttribute("str")String s) {
        System.err.println(s);
       /* ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("str", "Response request :)");
        return modelAndView;*/
       return null;
    }

    @PostMapping("/postTest")
    public ModelAndView testPostRequest(@RequestBody Content content) {
        System.err.println("post string : " + content.getTitle());
        return null;
    }
}
