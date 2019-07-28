package org.manager.syllabus.cseju.demosyllabusmanager.repository;

import org.junit.Before;
import org.junit.Test;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.ContentBundle;

import java.io.IOException;

import static org.junit.Assert.*;

public class ContentBundleRepositoryTest {

    private ContentBundleRepository contentBundleRepository;

    @Before
    public void init() {
        contentBundleRepository = new ContentBundleRepositoryImplementation();

    }

    @Test
    public void insertNewContentBundleTest() throws IOException {
        contentBundleRepository.insertNewContentBundle("xmlDoc", new ContentBundle(), "contentBundle");
    }
}