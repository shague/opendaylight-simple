/*
 * Copyright (c) 2017 Red Hat, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.netvirt.simple.test;

import org.junit.Ignore;
import org.junit.Rule;
import org.opendaylight.infrautils.inject.guice.testutils.GuiceRule2;
import org.opendaylight.infrautils.simple.testutils.AbstractSimpleDistributionTest;
import org.opendaylight.netvirt.simple.NetvirtWiring;

/**
 * Netvirt full distribution component test.
 *
 * @author Michael Vorburger.ch
 */
@Ignore // TODO un-ignore netvirt, once genius works...
public class NetvirtSimpleDistributionTest extends AbstractSimpleDistributionTest {

    public @Rule GuiceRule2 guice = new GuiceRule2(NetvirtWiring.class);

}
