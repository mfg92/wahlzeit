package org.wahlzeit.handlers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.mailing.EmailServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TellFriendTest.class
})

/**
 *
 */
public class HandlersTestSuite {
}
