package org.manager.syllabus.cseju.demosyllabusmanager.model;

import lombok.*;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.ContentBundle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "courseStructure")
public class CourseStructure {

    private String name;

    private List<ContentBundle> contentBundleList;


    @XmlElementWrapper(name = "contentBundles")
    @XmlElement(name = "contentBundle")
    public List<ContentBundle> getContentBundleList() {
        return contentBundleList;
    }
}
