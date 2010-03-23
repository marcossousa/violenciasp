package br.com.violencia.sp.test;

import junit.framework.Assert;

import org.junit.Test;

import br.com.violencia.sp.Distance;

public class DistanceTest {

	@Test
	public void testBetweenPoints() {
		double actual = Distance.betweenPoints(19.974278,-43.966556, -18.564209,-46.526735);
		double expected = Math.sqrt(122);
		System.out.println(actual);
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void testSmallest() {
		double actual = Distance.smallest(2, -4, 3, 7);
		double expected = -4;
		Assert.assertEquals(expected, actual, 0.01);
	}

	@Test
	public void testSmallestFloat() {
		double actual = Distance.smallest(7.34556, 11.449489);
		double expected = 7.34556;
		Assert.assertEquals(expected, actual, 0.01);
	}
	
}
