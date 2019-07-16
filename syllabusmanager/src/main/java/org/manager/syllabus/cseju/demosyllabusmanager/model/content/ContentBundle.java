package org.manager.syllabus.cseju.demosyllabusmanager.model.content;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "contentBundle")
public class ContentBundle {

    private Integer selected;

    private TextArea textArea;

    private Table table;

    public ContentBundle(Integer selected) {
        this.selected = selected;
    }
}
