package org.manager.syllabus.cseju.demosyllabusmanager.model.content;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "textArea")
public class TextArea extends Content {

    private String textBody;

    public TextArea(String title, String textBody) {
        super(title);
        this.textBody = textBody;
    }
}
