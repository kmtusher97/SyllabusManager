package org.manager.syllabus.cseju.demosyllabusmanager.model.content;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "content")
public class Content {

    protected String title;
}
