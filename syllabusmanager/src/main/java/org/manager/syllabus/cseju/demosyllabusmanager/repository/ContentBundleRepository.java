package org.manager.syllabus.cseju.demosyllabusmanager.repository;

import org.manager.syllabus.cseju.demosyllabusmanager.model.content.ContentBundle;

import java.io.IOException;

public interface ContentBundleRepository {

    void insertNewContentBundle(String filename, ContentBundle contentBundle, String parentNode) throws IOException;
}
