package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.EmailServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EmailTestSuite.class,
        LogBuilderTest.class
})

/**
 *
 */
public class ServicesTestSuite {
}
