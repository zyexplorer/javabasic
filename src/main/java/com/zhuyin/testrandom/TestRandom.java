package com.zhuyin.testrandom;

import org.junit.Test;

import java.util.Random;

public class TestRandom {

	@Test
	public void testRandom() {
		Random random = new Random(100);
		int x = random.nextInt();
		System.out.println(x);
		System.out.println(getRandomColor(253, 200));
	}

	public String getRandomColor(int i, int j) {
		Random random = new Random();
		if (i > 255) {
			i = 255;
		}
		if (j > 255) {
			j = 255;
		}
		int abs = Math.abs(i - j);
		int r = i + random.nextInt(abs);
		int g = i + random.nextInt(abs);
		int b = i + random.nextInt(abs);
		return r + "-" + g + "-" + b;
	}

}
