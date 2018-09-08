/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
* @author Alexander Y. Kleymenov
*/

package org.apache.harmony.security.tests.provider.cert;

import java.io.ByteArrayInputStream;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * DRLCertFactoryTest
 */
public class DRLCertFactoryTest extends TestCase {

    // The testing data was generated by using of classes
    // from org.apache.harmony.security.asn1 package.

    // 2 consecutively encoded X.509 certificates
    private static byte[] certEncoding = new byte[] {
        (byte) 0x30,(byte) 0x82,(byte) 0x02,(byte) 0xfa,(byte) 0x30,
        (byte) 0x82,(byte) 0x02,(byte) 0xb6,(byte) 0xa0,(byte) 0x03,
        (byte) 0x02,(byte) 0x01,(byte) 0x02,(byte) 0x02,(byte) 0x02,
        (byte) 0x02,(byte) 0x2b,(byte) 0x30,(byte) 0x0c,(byte) 0x06,
        (byte) 0x07,(byte) 0x2a,(byte) 0x86,(byte) 0x48,(byte) 0xce,
        (byte) 0x38,(byte) 0x04,(byte) 0x03,(byte) 0x01,(byte) 0x01,
        (byte) 0x00,(byte) 0x30,(byte) 0x1d,(byte) 0x31,(byte) 0x1b,
        (byte) 0x30,(byte) 0x19,(byte) 0x06,(byte) 0x03,(byte) 0x55,
        (byte) 0x04,(byte) 0x0a,(byte) 0x13,(byte) 0x12,(byte) 0x43,
        (byte) 0x65,(byte) 0x72,(byte) 0x74,(byte) 0x69,(byte) 0x66,
        (byte) 0x69,(byte) 0x63,(byte) 0x61,(byte) 0x74,(byte) 0x65,
        (byte) 0x20,(byte) 0x49,(byte) 0x73,(byte) 0x73,(byte) 0x75,
        (byte) 0x65,(byte) 0x72,(byte) 0x30,(byte) 0x22,(byte) 0x18,
        (byte) 0x0f,(byte) 0x31,(byte) 0x39,(byte) 0x37,(byte) 0x30,
        (byte) 0x30,(byte) 0x31,(byte) 0x31,(byte) 0x32,(byte) 0x31,
        (byte) 0x33,(byte) 0x34,(byte) 0x36,(byte) 0x34,(byte) 0x30,
        (byte) 0x5a,(byte) 0x18,(byte) 0x0f,(byte) 0x31,(byte) 0x39,
        (byte) 0x37,(byte) 0x30,(byte) 0x30,(byte) 0x31,(byte) 0x32,
        (byte) 0x34,(byte) 0x30,(byte) 0x33,(byte) 0x33,(byte) 0x33,
        (byte) 0x32,(byte) 0x30,(byte) 0x5a,(byte) 0x30,(byte) 0x1f,
        (byte) 0x31,(byte) 0x1d,(byte) 0x30,(byte) 0x1b,(byte) 0x06,
        (byte) 0x03,(byte) 0x55,(byte) 0x04,(byte) 0x0a,(byte) 0x13,
        (byte) 0x14,(byte) 0x53,(byte) 0x75,(byte) 0x62,(byte) 0x6a,
        (byte) 0x65,(byte) 0x63,(byte) 0x74,(byte) 0x20,(byte) 0x4f,
        (byte) 0x72,(byte) 0x67,(byte) 0x61,(byte) 0x6e,(byte) 0x69,
        (byte) 0x7a,(byte) 0x61,(byte) 0x74,(byte) 0x69,(byte) 0x6f,
        (byte) 0x6e,(byte) 0x30,(byte) 0x19,(byte) 0x30,(byte) 0x0c,
        (byte) 0x06,(byte) 0x07,(byte) 0x2a,(byte) 0x86,(byte) 0x48,
        (byte) 0xce,(byte) 0x38,(byte) 0x04,(byte) 0x03,(byte) 0x01,
        (byte) 0x01,(byte) 0x00,(byte) 0x03,(byte) 0x09,(byte) 0x00,
        (byte) 0x01,(byte) 0x02,(byte) 0x03,(byte) 0x04,(byte) 0x05,
        (byte) 0x06,(byte) 0x07,(byte) 0x08,(byte) 0x81,(byte) 0x02,
        (byte) 0x00,(byte) 0xaa,(byte) 0x82,(byte) 0x02,(byte) 0x00,
        (byte) 0x55,(byte) 0xa3,(byte) 0x82,(byte) 0x02,(byte) 0x14,
        (byte) 0x30,(byte) 0x82,(byte) 0x02,(byte) 0x10,(byte) 0x30,
        (byte) 0x0f,(byte) 0x06,(byte) 0x03,(byte) 0x55,(byte) 0x1d,
        (byte) 0x0f,(byte) 0x01,(byte) 0x01,(byte) 0xff,(byte) 0x04,
        (byte) 0x05,(byte) 0x03,(byte) 0x03,(byte) 0x01,(byte) 0xaa,
        (byte) 0x80,(byte) 0x30,(byte) 0x12,(byte) 0x06,(byte) 0x03,
        (byte) 0x55,(byte) 0x1d,(byte) 0x13,(byte) 0x01,(byte) 0x01,
        (byte) 0xff,(byte) 0x04,(byte) 0x08,(byte) 0x30,(byte) 0x06,
        (byte) 0x01,(byte) 0x01,(byte) 0xff,(byte) 0x02,(byte) 0x01,
        (byte) 0x05,(byte) 0x30,(byte) 0x14,(byte) 0x06,(byte) 0x03,
        (byte) 0x55,(byte) 0x1d,(byte) 0x20,(byte) 0x01,(byte) 0x01,
        (byte) 0xff,(byte) 0x04,(byte) 0x0a,(byte) 0x30,(byte) 0x08,
        (byte) 0x30,(byte) 0x06,(byte) 0x06,(byte) 0x04,(byte) 0x55,
        (byte) 0x1d,(byte) 0x20,(byte) 0x00,(byte) 0x30,(byte) 0x67,
        (byte) 0x06,(byte) 0x03,(byte) 0x55,(byte) 0x1d,(byte) 0x11,
        (byte) 0x01,(byte) 0x01,(byte) 0xff,(byte) 0x04,(byte) 0x5d,
        (byte) 0x30,(byte) 0x5b,(byte) 0x81,(byte) 0x0c,(byte) 0x72,
        (byte) 0x66,(byte) 0x63,(byte) 0x40,(byte) 0x38,(byte) 0x32,
        (byte) 0x32,(byte) 0x2e,(byte) 0x4e,(byte) 0x61,(byte) 0x6d,
        (byte) 0x65,(byte) 0x82,(byte) 0x07,(byte) 0x64,(byte) 0x4e,
        (byte) 0x53,(byte) 0x4e,(byte) 0x61,(byte) 0x6d,(byte) 0x65,
        (byte) 0xa4,(byte) 0x17,(byte) 0x31,(byte) 0x15,(byte) 0x30,
        (byte) 0x13,(byte) 0x06,(byte) 0x03,(byte) 0x55,(byte) 0x04,
        (byte) 0x0a,(byte) 0x13,(byte) 0x0c,(byte) 0x4f,(byte) 0x72,
        (byte) 0x67,(byte) 0x61,(byte) 0x6e,(byte) 0x69,(byte) 0x7a,
        (byte) 0x61,(byte) 0x74,(byte) 0x69,(byte) 0x6f,(byte) 0x6e,
        (byte) 0x86,(byte) 0x1a,(byte) 0x68,(byte) 0x74,(byte) 0x74,
        (byte) 0x70,(byte) 0x3a,(byte) 0x2f,(byte) 0x2f,(byte) 0x75,
        (byte) 0x6e,(byte) 0x69,(byte) 0x66,(byte) 0x6f,(byte) 0x72,
        (byte) 0x6d,(byte) 0x2e,(byte) 0x52,(byte) 0x65,(byte) 0x73,
        (byte) 0x6f,(byte) 0x75,(byte) 0x72,(byte) 0x63,(byte) 0x65,
        (byte) 0x2e,(byte) 0x49,(byte) 0x64,(byte) 0x87,(byte) 0x04,
        (byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0x00,(byte) 0x88,
        (byte) 0x07,(byte) 0x2a,(byte) 0x03,(byte) 0xa2,(byte) 0x5c,
        (byte) 0x83,(byte) 0xb2,(byte) 0x03,(byte) 0x30,(byte) 0x0c,
        (byte) 0x06,(byte) 0x03,(byte) 0x55,(byte) 0x1d,(byte) 0x1e,
        (byte) 0x01,(byte) 0x01,(byte) 0xff,(byte) 0x04,(byte) 0x02,
        (byte) 0x30,(byte) 0x00,(byte) 0x30,(byte) 0x0c,(byte) 0x06,
        (byte) 0x03,(byte) 0x55,(byte) 0x1d,(byte) 0x24,(byte) 0x01,
        (byte) 0x01,(byte) 0xff,(byte) 0x04,(byte) 0x02,(byte) 0x30,
        (byte) 0x00,(byte) 0x30,(byte) 0x81,(byte) 0x99,(byte) 0x06,
        (byte) 0x03,(byte) 0x55,(byte) 0x1d,(byte) 0x25,(byte) 0x01,
        (byte) 0x01,(byte) 0xff,(byte) 0x04,(byte) 0x81,(byte) 0x8e,
        (byte) 0x30,(byte) 0x81,(byte) 0x8b,(byte) 0x06,(byte) 0x04,
        (byte) 0x55,(byte) 0x1d,(byte) 0x25,(byte) 0x00,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x07,(byte) 0x03,(byte) 0x01,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x07,(byte) 0x03,(byte) 0x01,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x07,(byte) 0x03,(byte) 0x02,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x07,(byte) 0x03,(byte) 0x03,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x07,(byte) 0x03,(byte) 0x04,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x07,(byte) 0x03,(byte) 0x05,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x07,(byte) 0x03,(byte) 0x06,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x07,(byte) 0x03,(byte) 0x07,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x07,(byte) 0x03,(byte) 0x08,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x07,(byte) 0x03,(byte) 0x09,(byte) 0x06,
        (byte) 0x08,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x05,
        (byte) 0x05,(byte) 0x08,(byte) 0x02,(byte) 0x02,(byte) 0x06,
        (byte) 0x0a,(byte) 0x2b,(byte) 0x06,(byte) 0x01,(byte) 0x04,
        (byte) 0x01,(byte) 0x82,(byte) 0x37,(byte) 0x0a,(byte) 0x03,
        (byte) 0x03,(byte) 0x06,(byte) 0x09,(byte) 0x60,(byte) 0x86,
        (byte) 0x48,(byte) 0x01,(byte) 0x86,(byte) 0xf8,(byte) 0x42,
        (byte) 0x04,(byte) 0x01,(byte) 0x30,(byte) 0x0d,(byte) 0x06,
        (byte) 0x03,(byte) 0x55,(byte) 0x1d,(byte) 0x36,(byte) 0x01,
        (byte) 0x01,(byte) 0xff,(byte) 0x04,(byte) 0x03,(byte) 0x02,
        (byte) 0x01,(byte) 0x01,(byte) 0x30,(byte) 0x0e,(byte) 0x06,
        (byte) 0x04,(byte) 0x2a,(byte) 0x4d,(byte) 0x86,(byte) 0x09,
        (byte) 0x01,(byte) 0x01,(byte) 0xff,(byte) 0x04,(byte) 0x03,
        (byte) 0x01,(byte) 0x01,(byte) 0x01,(byte) 0x30,(byte) 0x64,
        (byte) 0x06,(byte) 0x03,(byte) 0x55,(byte) 0x1d,(byte) 0x12,
        (byte) 0x04,(byte) 0x5d,(byte) 0x30,(byte) 0x5b,(byte) 0x81,
        (byte) 0x0c,(byte) 0x72,(byte) 0x66,(byte) 0x63,(byte) 0x40,
        (byte) 0x38,(byte) 0x32,(byte) 0x32,(byte) 0x2e,(byte) 0x4e,
        (byte) 0x61,(byte) 0x6d,(byte) 0x65,(byte) 0x82,(byte) 0x07,
        (byte) 0x64,(byte) 0x4e,(byte) 0x53,(byte) 0x4e,(byte) 0x61,
        (byte) 0x6d,(byte) 0x65,(byte) 0xa4,(byte) 0x17,(byte) 0x31,
        (byte) 0x15,(byte) 0x30,(byte) 0x13,(byte) 0x06,(byte) 0x03,
        (byte) 0x55,(byte) 0x04,(byte) 0x0a,(byte) 0x13,(byte) 0x0c,
        (byte) 0x4f,(byte) 0x72,(byte) 0x67,(byte) 0x61,(byte) 0x6e,
        (byte) 0x69,(byte) 0x7a,(byte) 0x61,(byte) 0x74,(byte) 0x69,
        (byte) 0x6f,(byte) 0x6e,(byte) 0x86,(byte) 0x1a,(byte) 0x68,
        (byte) 0x74,(byte) 0x74,(byte) 0x70,(byte) 0x3a,(byte) 0x2f,
        (byte) 0x2f,(byte) 0x75,(byte) 0x6e,(byte) 0x69,(byte) 0x66,
        (byte) 0x6f,(byte) 0x72,(byte) 0x6d,(byte) 0x2e,(byte) 0x52,
        (byte) 0x65,(byte) 0x73,(byte) 0x6f,(byte) 0x75,(byte) 0x72,
        (byte) 0x63,(byte) 0x65,(byte) 0x2e,(byte) 0x49,(byte) 0x64,
        (byte) 0x87,(byte) 0x04,(byte) 0xff,(byte) 0xff,(byte) 0xff,
        (byte) 0x00,(byte) 0x88,(byte) 0x07,(byte) 0x2a,(byte) 0x03,
        (byte) 0xa2,(byte) 0x5c,(byte) 0x83,(byte) 0xb2,(byte) 0x03,
        (byte) 0x30,(byte) 0x09,(byte) 0x06,(byte) 0x03,(byte) 0x55,
        (byte) 0x1d,(byte) 0x1f,(byte) 0x04,(byte) 0x02,(byte) 0x30,
        (byte) 0x00,(byte) 0x30,(byte) 0x0a,(byte) 0x06,(byte) 0x03,
        (byte) 0x55,(byte) 0x1d,(byte) 0x23,(byte) 0x04,(byte) 0x03,
        (byte) 0x01,(byte) 0x01,(byte) 0x01,(byte) 0x30,(byte) 0x0a,
        (byte) 0x06,(byte) 0x03,(byte) 0x55,(byte) 0x1d,(byte) 0x0e,
        (byte) 0x04,(byte) 0x03,(byte) 0x01,(byte) 0x01,(byte) 0x01,
        (byte) 0x30,(byte) 0x0a,(byte) 0x06,(byte) 0x03,(byte) 0x55,
        (byte) 0x1d,(byte) 0x21,(byte) 0x04,(byte) 0x03,(byte) 0x01,
        (byte) 0x01,(byte) 0x01,(byte) 0x30,(byte) 0x0c,(byte) 0x06,
        (byte) 0x07,(byte) 0x2a,(byte) 0x86,(byte) 0x48,(byte) 0xce,
        (byte) 0x38,(byte) 0x04,(byte) 0x03,(byte) 0x01,(byte) 0x01,
        (byte) 0x00,(byte) 0x03,(byte) 0x30,(byte) 0x00,(byte) 0x30,
        (byte) 0x2d,(byte) 0x02,(byte) 0x14,(byte) 0x00,(byte) 0xbe,
        (byte) 0x10,(byte) 0xbe,(byte) 0x86,(byte) 0xb3,(byte) 0x35,
        (byte) 0x63,(byte) 0xfb,(byte) 0x8e,(byte) 0xb8,(byte) 0xfc,
        (byte) 0xe3,(byte) 0xf1,(byte) 0x99,(byte) 0x96,(byte) 0x19,
        (byte) 0xb4,(byte) 0xf4,(byte) 0x3b,(byte) 0x02,(byte) 0x15,
        (byte) 0x00,(byte) 0x81,(byte) 0x28,(byte) 0x62,(byte) 0x82,
        (byte) 0x19,(byte) 0xba,(byte) 0xcf,(byte) 0xeb,(byte) 0x85,
        (byte) 0x6d,(byte) 0x52,(byte) 0xde,(byte) 0x09,(byte) 0x3e,
        (byte) 0x62,(byte) 0xe3,(byte) 0x5b,(byte) 0x55,(byte) 0x71,
        (byte) 0x40,
    };

    /**
     * DRLCertFactory() method testing.
     */
    public void testDRLCertFactory() {
        CertificateFactory certFactory;
        try {
            certFactory =
                CertificateFactory.getInstance("X509", "DRLCertFactory");
        } catch (CertificateException e) {
            fail("X509 certificate type is not available: "+e.getMessage());
            return;
        } catch (NoSuchProviderException e) {
            fail("Unexpected NoSuchProviderException: "+e.getMessage());
            return;
        }
        // DER encoded certificate generation testing
        ByteArrayInputStream bais = new ByteArrayInputStream(certEncoding);
        try {
            assertNotNull("Generated certificate is null",
                    certFactory.generateCertificate(bais));
        } catch (CertificateException e) {
            fail("Unexpected CertificateException: " + e.getMessage());
        }

        try {
            certFactory.generateCertificate(bais);
            fail("Expected CertificateException was not thrown.");
        } catch (CertificateException e) {
        }
    }

    public static Test suite() {
        return new TestSuite(DRLCertFactoryTest.class);
    }

}
