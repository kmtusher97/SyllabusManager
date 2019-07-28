package org.manager.syllabus.cseju.demosyllabusmanager.model;

import lombok.*;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.ContentBundle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Setter
@ToString
@AllArgsConstructor
@XmlRootElement(name = "courseStructure")
public class CourseStructure {

    private String name;

    private List<ContentBundle> contentBundleList;


    public CourseStructure() {
        this.name = "";
        this.contentBundleList = new ArrayList<>();
    }

    @XmlElement(name = "courseTypeName")
    public String getName() {
        return name;
    }

    @XmlElementWrapper(name = "contentBundles")
    @XmlElement(name = "contentBundle")
    public List<ContentBundle> getContentBundleList() {
        return contentBundleList;
    }

    public String toXML() {
        String contentBundleListXML = "";
        for (ContentBundle contentBundle : this.contentBundleList) {
            contentBundleListXML += contentBundle.toXML();
        }

        return "<courseStructure>" +
                    "<name>" + this.name + "</name>" +
                    "<contentBundles>" +
                        contentBundleListXML +
                    "</contentBundles>" +
                "</courseStructure>";
    }
}
