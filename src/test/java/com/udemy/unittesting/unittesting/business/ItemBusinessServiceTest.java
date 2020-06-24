package com.udemy.unittesting.unittesting.business;

import com.udemy.unittesting.unittesting.business.ItemBusinessService;
import com.udemy.unittesting.unittesting.business.SomeBusinessImpl;
import com.udemy.unittesting.unittesting.data.ItemRepository;
import com.udemy.unittesting.unittesting.data.SomeDataService;
import com.udemy.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService business;

	//SomeDataService dataServiceMock = mock(SomeDataService.class);
	@Mock
	private ItemRepository repository;

	@Test
	public void calculateSumUsingDataServiceBasic() {

		//dataServiceMock retrieveAllData
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(1,"Ball",10,100)));
		List<Item> items = business.retrieveAllItems();
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
	}

}
