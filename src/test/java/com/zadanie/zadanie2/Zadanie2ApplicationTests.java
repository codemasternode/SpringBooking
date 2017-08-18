package com.zadanie.zadanie2;

import com.zadanie.zadanie2.model.RoomCategory;
import com.zadanie.zadanie2.repository.RoomCategoryRepository;
import com.zadanie.zadanie2.service.RoomCategoryService;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Zadanie2ApplicationTests {

	@Autowired
	private RoomCategoryService roomCategoryService;

	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findAll_RoomCategories() throws Exception{

		RoomCategory category1 = new RoomCategory("2 osobowe pokoje", "2-osobowe", 23.66);
		RoomCategory category2 = new RoomCategory("3 osobowe pokoje", "3-osobowe", 25.66);
		RoomCategory category3 = new RoomCategory("4 osobowe pokoje", "4-osobowe", 30.66);


		List<RoomCategory> roomCategories = Arrays.asList(category1, category2, category3);

		given(roomCategoryService.findAll()).willReturn(roomCategories);


	}

}
