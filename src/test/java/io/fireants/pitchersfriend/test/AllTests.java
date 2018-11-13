package io.fireants.pitchersfriend.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import io.fireants.pitchersfriend.test.insight.AllIntegrationTests;

@RunWith(Suite.class)
@SuiteClasses({
	AllIntegrationTests.class
})	
public class AllTests {}

