package org.manager.syllabus.cseju.demosyllabusmanager.services;

import org.manager.syllabus.cseju.demosyllabusmanager.model.content.Table;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.TextArea;

public interface ContentServices {


    TextArea getInitialTextArea();

    Table getInitialTable();
}
