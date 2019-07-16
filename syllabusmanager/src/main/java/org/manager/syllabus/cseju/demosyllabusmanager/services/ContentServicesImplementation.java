package org.manager.syllabus.cseju.demosyllabusmanager.services;

import org.manager.syllabus.cseju.demosyllabusmanager.model.content.Table;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.TextArea;

import java.util.Arrays;

public class ContentServicesImplementation implements ContentServices {
    @Override
    public TextArea getInitialTextArea() {
        return new TextArea("Untitled Text Area", "");
    }

    @Override
    public Table getInitialTable() {
        return new Table("Untitled Table", Arrays.asList("Field0"));
    }
}
