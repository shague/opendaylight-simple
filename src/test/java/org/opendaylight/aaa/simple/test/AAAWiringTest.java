/*
 * Copyright (c) 2017 Red Hat, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.aaa.simple.test;

import org.junit.Ignore;
import org.junit.Rule;
import org.opendaylight.aaa.simple.AAAWiring;
import org.opendaylight.controller.simple.ControllerWiring;
import org.opendaylight.infrautils.inject.guice.testutils.AnnotationsModule;
import org.opendaylight.infrautils.inject.guice.testutils.GuiceRule;
import org.opendaylight.infrautils.simple.testutils.AbstractSimpleDistributionTest;

@Ignore // TODO fix NullPointerException at org.opendaylight.aaa.cert.impl.DefaultMdsalSslData.createKeyStores :155
public class AAAWiringTest extends AbstractSimpleDistributionTest {

    public @Rule GuiceRule guice = new GuiceRule(new AAAWiring(), new ControllerWiring(),
            // TODO new WebWiring(true), new OsgiServicesWiring(),
            new AnnotationsModule());

}
