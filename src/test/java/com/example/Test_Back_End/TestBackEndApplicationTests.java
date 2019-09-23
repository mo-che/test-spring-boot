package com.example.Test_Back_End;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBackEndApplicationTests {

	@Test
	public void decompressCase1() {
        String result = TestBackEndApplication.decompress("2[abc]3[ab]c");
		assertEquals(result, "abcabcabababc");
	}

	@Test
	public void decompressCase2() {
		String result = TestBackEndApplication.decompress("10[a]c2[ab]");
		assertEquals(result, "aaaaaaaaaacabab");
	}

	@Test
	public void decompressCase3() {
		String result = TestBackEndApplication.decompress("2[3[a]b]");
        assertEquals(result, "aaabaaab");
	}
}
