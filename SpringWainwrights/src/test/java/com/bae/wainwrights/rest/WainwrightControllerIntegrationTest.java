package com.bae.wainwrights.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.wainwrights.data.Wainwright;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:wainwright-schema.sql",
		"classpath:wainwright-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class WainwrightControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {

		Wainwright testWainwright = new Wainwright(110, "High Spy", 653, "North Western");

		String testWainwrightAsJSON = this.mapper.writeValueAsString(testWainwright);

		System.out.println(testWainwright);
		System.out.println(testWainwrightAsJSON);

		RequestBuilder request = post("/createWainwright").contentType(MediaType.APPLICATION_JSON)
				.content(testWainwrightAsJSON);

		ResultMatcher checkStatus = status().is(201);

		Wainwright testCreatedWainwright = new Wainwright(110, "High Spy", 653, "North Western");
		testCreatedWainwright.setId(2);
		String testCreatedWainwrightAsJSON = this.mapper.writeValueAsString(testCreatedWainwright);

		ResultMatcher checkBody = content().json(testCreatedWainwrightAsJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		int id = 1;
		Wainwright newWainwright = new Wainwright(id, 110, "High Spy", 653, "North Western");
		String newWainwrightAsJSON = this.mapper.writeValueAsString(newWainwright);

		RequestBuilder req = put("/replaceWainwright/" + id).contentType(MediaType.APPLICATION_JSON)
				.content(newWainwrightAsJSON);

		ResultMatcher checkStatus = status().isAccepted();

		ResultMatcher checkBody = content().json(newWainwrightAsJSON);

		this.mockMVC.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void findById() throws Exception {
		RequestBuilder req = get("/getWainwright/1");

		ResultMatcher checkStatus = status().isOk();

		Wainwright testWainwright = new Wainwright(1, 4, "Skiddaw", 931, "Northern");

		String testWainwrightAsJSON = this.mapper.writeValueAsString(testWainwright);

		ResultMatcher checkBody = content().json(testWainwrightAsJSON);

		this.mockMVC.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testFindByName() throws Exception {
		RequestBuilder request = get("/getByName/Skiddaw");

		ResultMatcher checkStatus = status().isOk();

		List<Wainwright> testWainwrights = List.of(new Wainwright(1, 4, "Skiddaw", 931, "Northern"));

		String testWainwrightsAsJSON = this.mapper.writeValueAsString(testWainwrights);

		ResultMatcher checkBody = content().json(testWainwrightsAsJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testDelete() throws Exception {

		RequestBuilder request = delete("/deleteWainwright/1");

		ResultMatcher checkStatus = status().is(204);
		ResultMatcher checkBody = content().string("Deleted: 1");

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}
}