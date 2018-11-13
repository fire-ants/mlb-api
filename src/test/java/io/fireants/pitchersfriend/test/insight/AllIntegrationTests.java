package io.fireants.pitchersfriend.test.insight;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	InsightControllerIntegrationTest.class, 
	InsightRepositoryIntegrationTest.class, 
	InsightServiceIntegrationTest.class 
})	
public class AllIntegrationTests {}
