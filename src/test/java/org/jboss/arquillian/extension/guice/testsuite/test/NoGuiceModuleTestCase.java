/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.extension.guice.testsuite.test;

import com.google.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.guice.testsuite.modules.Employee;
import org.jboss.arquillian.extension.guice.testsuite.modules.EmployeeModule;
import org.jboss.arquillian.extension.guice.testsuite.modules.repository.EmployeeRepository;
import org.jboss.arquillian.extension.guice.testsuite.modules.repository.impl.DefaultEmployeeRepository;
import org.jboss.arquillian.extension.guice.testsuite.modules.service.EmployeeService;
import org.jboss.arquillian.extension.guice.testsuite.modules.service.impl.DefaultEmployeeService;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Test the extension when no Guice module was specified.
 *
 * @author <a href="mailto:jmnarloch@gmail.com">Jakub Narloch</a>
 */
@RunWith(Arquillian.class)
public class NoGuiceModuleTestCase {

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "guice-test.jar")
                .addClasses(Employee.class,
                        EmployeeService.class, DefaultEmployeeService.class,
                        EmployeeModule.class);
    }

    @Inject
    private EmployeeService employeeService;

    @Test
    public void testEmployeeServiceNull() throws Exception {

        assertNull("The employeeService was expected to be null.", employeeService);
    }
}
