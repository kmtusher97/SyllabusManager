package org.manager.syllabus.cseju.demosyllabusmanager.model.content;

import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "contentBundle")
public class ContentBundle implements Serializable {

    private Integer contentBundleId;

    private Integer selected;

    private TextArea textArea;

    private Table table;

    public ContentBundle(Integer selected) {
        this.selected = selected;
    }

    @XmlAttribute(name = "contentBundleId")
    public Integer getContentBundleId() {
        return contentBundleId;
    }
}
