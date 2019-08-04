package org.manager.syllabus.cseju.demosyllabusmanager.repository.basex;

import org.manager.syllabus.cseju.demosyllabusmanager.basex.BaseXService;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.ContentBundle;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.Table;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.TextArea;
import org.manager.syllabus.cseju.demosyllabusmanager.services.jaxb.JAXBServices;
import org.springframework.beans.factory.annotation.Autowired;

public class ContentBundleRepository {

    private BaseXService baseXService;
    private JAXBServices jaxbServices;
    private static Integer countOfContentBundle = 0;

    @Autowired
    public ContentBundleRepository(BaseXService baseXService, JAXBServices jaxbServices) {
        this.baseXService = baseXService;
        this.jaxbServices = jaxbServices;
    }

    public void addContentBundle(String databaseName) {
        ContentBundle contentBundle = new ContentBundle();
        contentBundle.setContentBundleId(countOfContentBundle++);
        contentBundle.setSelected(0);
        contentBundle.setTable((new Table()).getInitialTable(0));
        contentBundle.setTextArea((new TextArea()).getInitialTextArea(0));

        String xQuery = "insert node " +
                jaxbServices.objectToXmlString(contentBundle, false) +
                " into //contentBundles";
        System.out.println(xQuery);
        baseXService.executeWriteQuery(xQuery);
    }
}
