package com.jumia;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.jumia.controllers.PhoneValidationController;

@RunWith(SpringRunner.class)
@WebMvcTest(PhoneValidationController.class)
class JumiaPhoneValidationApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testPhoneValidationPage() throws Exception {
		mockMvc.perform(get("/phone"))
		.andExpect(status().isOk())
		.andExpect(view().name("PhoneValidationTemp"))
		.andExpect(model().attribute("phoneNumbers", hasSize(41))); 
	}

}
