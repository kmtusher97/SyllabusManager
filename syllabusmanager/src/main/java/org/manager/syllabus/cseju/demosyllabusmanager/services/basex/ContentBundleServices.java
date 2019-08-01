package org.manager.syllabus.cseju.demosyllabusmanager.services.basex;

import org.manager.syllabus.cseju.demosyllabusmanager.basex.BaseXService;
import org.manager.syllabus.cseju.demosyllabusmanager.services.jaxb.JAXBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentBundleServices {

    private BaseXService baseXService;
    private JAXBServices jaxbServices;
    private static Integer countOfContentBundle = 0;

    @Autowired
    public ContentBundleServices(BaseXService baseXService, JAXBServices jaxbServices) {
        this.baseXService = baseXService;
        this.jaxbServices = jaxbServices;
    }

    public void addContentBundle() {

    }
}
