package org.autotests;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({
        "org.autotests.api.tests",
        "org.autotests.ui.tests.automationintesting",
        "org.autotests.ui.tests.demoblaze"
})
public class AllTestsSuite {
}
