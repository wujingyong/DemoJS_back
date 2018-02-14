package com.wjy.web.test;


import com.wjy.model.Emp;
import com.wjy.test.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wjy
 * @create 2018/2/14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {
	@Autowired
	private TestService testService;

	@Test
	public void test(){
		List<Emp> emps = testService.getEmpAll();
		emps.stream().limit(20).forEach(System.out::println);
	}
}
