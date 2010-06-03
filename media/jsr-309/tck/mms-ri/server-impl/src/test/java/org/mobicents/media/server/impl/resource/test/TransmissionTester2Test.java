/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mobicents.media.server.impl.resource.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mobicents.media.server.impl.clock.TimerImpl;
import org.mobicents.media.server.spi.Timer;

/**
 *
 * @author kulikov
 */
public class TransmissionTester2Test {

    private Timer timer;
    private TransmissionTester2 tester;    
    
    public TransmissionTester2Test() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        timer = new TimerImpl();
        timer.start();
        tester = new TransmissionTester2(timer);
    }

    @After
    public void tearDown() {
        timer.stop();
    }

    /**
     * Test of getGenerator method, of class TransmissionTester.
     */
    @Test
    public void testPassed() {
        tester.connect(tester.getDetector());
        tester.start();
        assertTrue("Test not passed", tester.isPassed());
    }

    @Test
    public void testFailure() {
        tester.start();
        assertFalse("Test passed", tester.isPassed());
    }


}