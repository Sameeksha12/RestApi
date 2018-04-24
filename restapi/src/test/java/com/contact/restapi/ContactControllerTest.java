package com.contact.restapi;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.contact.restapi.controller.ContactController;
import com.contact.restapi.service.ContactService;

public class ContactControllerTest {
	@Mock
	private ContactService contactService;
	
	@InjectMocks
	private ContactController contactController;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(contactController).build();
	}

	@Test
	public void testContactController() throws Exception {
		mockMvc.perform(get("/api/contacts")).andExpect(status().isOk());
	}

}
