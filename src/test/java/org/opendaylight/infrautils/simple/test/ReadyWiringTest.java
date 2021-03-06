/*
 * Copyright (c) 2017 Red Hat, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.infrautils.simple.test;

import static com.google.common.truth.Truth.assertThat;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.junit.Rule;
import org.junit.Test;
import org.opendaylight.infrautils.inject.guice.testutils.AnnotationsModule;
import org.opendaylight.infrautils.inject.guice.testutils.GuiceRule2;
import org.opendaylight.infrautils.ready.SystemReadyMonitor;
import org.opendaylight.infrautils.simple.ReadyWiring;

/**
 * Unit test for {@link ReadyWiring}.
 *
 * @author Michael Vorburger.ch
 */
public class ReadyWiringTest {

    public static class TestBean {
        private final SystemReadyMonitor systemReadyMonitor;
        boolean invokedReadyCallbackRegisteredInConstructor = false;
        boolean invokedReadyCallbackRegisteredInPostConstruct = false;

        @Inject public TestBean(SystemReadyMonitor systemReadyMonitor) {
            this.systemReadyMonitor = systemReadyMonitor;
            systemReadyMonitor.registerListener(() -> {
                invokedReadyCallbackRegisteredInConstructor = true;
            });
        }

        @PostConstruct public void init() {
            systemReadyMonitor.registerListener(() -> {
                invokedReadyCallbackRegisteredInPostConstruct = true;
            });
        }
    }

    public @Rule GuiceRule2 guice = new GuiceRule2(ReadyWiring.class, AnnotationsModule.class);

    @Inject TestBean testBean;

    @Test public void testReadyListener() {
        assertThat(testBean.invokedReadyCallbackRegisteredInConstructor).isTrue();
        assertThat(testBean.invokedReadyCallbackRegisteredInPostConstruct).isTrue();
    }

}
