/*
 * *****************************************************************************
 *      Cloud Foundry
 *      Copyright (c) [2009-2017] Pivotal Software, Inc. All Rights Reserved.
 *
 *      This product is licensed to you under the Apache License, Version 2.0 (the "License").
 *      You may not use this product except in compliance with the License.
 *
 *      This product includes a number of subcomponents with
 *      separate copyright notices and license terms. Your use of these
 *      subcomponents is subject to the terms and conditions of the
 *      subcomponent's license, as noted in the LICENSE file.
 * *****************************************************************************
 */

package org.cloudfoundry.identity.uaa.authentication;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.FACE;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.FINGERPRINT;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.GEOLOCATION;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.IRIS;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.KNOWLEDGE;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.MULTI_CHANNEL;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.MULTI_FACTOR;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.ONE_TIME_PASSCODE;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.PASSWORD;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.PIN;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.PROOF_OF_POSESSION;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.RETINA;
import static org.cloudfoundry.identity.uaa.authentication.AuthenticationType.RISK;
import static org.junit.Assert.*;


public class AuthenticationTypeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void fromAMR() throws Exception {
        assertSame(FACE, AuthenticationType.fromAMR("face"));
        assertSame(FINGERPRINT, AuthenticationType.fromAMR("ftp"));
        assertSame(GEOLOCATION, AuthenticationType.fromAMR("geo"));
        assertSame(PROOF_OF_POSESSION, AuthenticationType.fromAMR("hwk"));
        assertSame(IRIS, AuthenticationType.fromAMR("iris"));
        assertSame(KNOWLEDGE, AuthenticationType.fromAMR("kba"));
        assertSame(MULTI_CHANNEL, AuthenticationType.fromAMR("mca"));
        assertSame(MULTI_FACTOR, AuthenticationType.fromAMR("mfa"));
        assertSame(ONE_TIME_PASSCODE, AuthenticationType.fromAMR("otp"));
        assertSame(PIN, AuthenticationType.fromAMR("pin"));
        assertSame(PASSWORD, AuthenticationType.fromAMR("pwd"));
        assertSame(RISK, AuthenticationType.fromAMR("rba"));
        assertSame(RETINA, AuthenticationType.fromAMR("retina"));
        assertNull(AuthenticationType.fromAMR(""));
        assertNull(AuthenticationType.fromAMR(null));
    }

    @Test
    public void invalidAMR() {
        String amr = "invalid";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(amr);
        AuthenticationType.fromAMR(amr);
    }

}