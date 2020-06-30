package com.udemy.unittesting.unittesting;

import com.udemy.unittesting.unittesting.business.SomeBusinessImpl;
import com.udemy.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}

class SomeDataServiceStubEmpty implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations={"classpath:test-configuration.properties"})
class UnitTestingApplicationTests {


	@Test
	public void calculateSumUsingDataServiceBasic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataServiceEmpty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStubEmpty());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}



}
