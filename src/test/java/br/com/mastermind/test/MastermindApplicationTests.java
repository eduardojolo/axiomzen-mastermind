package br.com.mastermind.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.mastermind.MastermindApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MastermindApplication.class)
@WebAppConfiguration
public class MastermindApplicationTests {

	
	
	@Test
	public void testGuessTwoWhiteKeyPegs() {
		
	}
	
	@Test
	public void testGuessOneBlackKeyPeg() {
		
	}
	
	@Test
	public void testGuessMiss() {
		
	}
	
	@Test
	public void testWin() {
		
	}

}
