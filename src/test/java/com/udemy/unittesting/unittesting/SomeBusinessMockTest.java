package com.udemy.unittesting.unittesting;

import com.udemy.unittesting.unittesting.business.SomeBusinessImpl;
import com.udemy.unittesting.unittesting.data.SomeDataService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business = new SomeBusinessImpl();

	//SomeDataService dataServiceMock = mock(SomeDataService.class);
	@Mock
	SomeDataService dataServiceMock;

	@BeforeEach
	public void before(){
		business.setSomeDataService(dataServiceMock);
	}

	@Test
	public void calculateSumUsingDataServiceBasic() {

		//dataServiceMock retrieveAllData
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataServiceEmpty() {

		//dataServiceMock retrieveAllData
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

}
