package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.mastermind.AxiomzenMastermindApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AxiomzenMastermindApplication.class)
@WebAppConfiguration
public class AxiomzenMastermindApplicationTests {

	@Test
	public void contextLoads() {
	}

}
