package org.apache.velocity.test;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.test.misc.TestLogChute;

/**
 * Multiple paths in the file resource loader.
 *
 * @author <a href="mailto:jvanzyl@apache.org">Jason van Zyl</a>
 * @version $Id: MultipleFileResourcePathTestCase.java 832247 2009-11-03 01:29:30Z wglass $
 */
public class MultipleFileResourcePathTestCase extends BaseTestCase
{

    /**
     * Path for templates. This property will override the
     * value in the default velocity properties file.
     */
    private final static String FILE_RESOURCE_LOADER_PATH1 = TEST_COMPARE_DIR + "/multi/path1";

    /**
     * Path for templates. This property will override the
     * value in the default velocity properties file.
     */
    private final static String FILE_RESOURCE_LOADER_PATH2 = TEST_COMPARE_DIR + "/multi/path2";

    /**
     * Results relative to the build directory.
     */
    private static final String RESULTS_DIR = TEST_RESULT_DIR + "/multi";

    /**
     * Results relative to the build directory.
     */
    private static final String COMPARE_DIR = TEST_COMPARE_DIR + "/multi/compare";

    VelocityEngine engine;
    
    /**
     * Default constructor.
     */
    public MultipleFileResourcePathTestCase(String name)
    {
        super(name);
    }

    public static Test suite ()
    {
        return new TestSuite(MultipleFileResourcePathTestCase.class);
    }

    public void setUp()
            throws Exception
    {
        assureResultsDirectoryExists(RESULTS_DIR);

        engine = new VelocityEngine();
        
        engine.addProperty(
                RuntimeConstants.FILE_RESOURCE_LOADER_PATH, FILE_RESOURCE_LOADER_PATH1);

        engine.addProperty(
                RuntimeConstants.FILE_RESOURCE_LOADER_PATH, FILE_RESOURCE_LOADER_PATH2);

        engine.setProperty(
                RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, TestLogChute.class.getName());

        engine.init();
    }

    /**
     * Runs the test.
     */
    public void  testMultipleFileResources ()
            throws Exception
    {
        Template template1 = engine.getTemplate(
            getFileName(null, "path1", TMPL_FILE_EXT));

        Template template2 = engine.getTemplate(
            getFileName(null, "path2", TMPL_FILE_EXT));

        FileOutputStream fos1 =
            new FileOutputStream (
                getFileName(RESULTS_DIR, "path1", RESULT_FILE_EXT));

        FileOutputStream fos2 =
            new FileOutputStream (
                getFileName(RESULTS_DIR, "path2", RESULT_FILE_EXT));

        Writer writer1 = new BufferedWriter(new OutputStreamWriter(fos1));
        Writer writer2 = new BufferedWriter(new OutputStreamWriter(fos2));

        /*
         *  put the Vector into the context, and merge both
         */

        VelocityContext context = new VelocityContext();

        template1.merge(context, writer1);
        writer1.flush();
        writer1.close();

        template2.merge(context, writer2);
        writer2.flush();
        writer2.close();

        if (!isMatch(RESULTS_DIR, COMPARE_DIR, "path1",
                RESULT_FILE_EXT, CMP_FILE_EXT) ||
            !isMatch(RESULTS_DIR, COMPARE_DIR, "path2",
                RESULT_FILE_EXT, CMP_FILE_EXT))
        {
            fail("Output incorrect.");
        }
    }
}
