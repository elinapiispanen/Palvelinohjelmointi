package hh20swd.harjoitustyo;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh20swd.harjoitustyo.webcontroller.SarjaController;

@RunWith(SpringRunner.class)
@SpringBootTest
class HarjoitustyoApplicationTests {

	@Autowired
	private SarjaController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
