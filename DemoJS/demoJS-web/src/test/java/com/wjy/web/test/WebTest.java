package com.wjy.web.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author wjy
 * @create 2018/2/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebTest {
	@Autowired
	WebApplicationContext context;
	MockMvc mockMvc;

	@Before
	public void initMockMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void test() throws Exception {
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/test/getAll").param("pageNo", "1").param("pageSize","10")).andReturn();
		assert andReturn.getResponse()!= null;
	}
}
