package br.com.violencia.sp.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.violencia.sp.Local;
import br.com.violencia.sp.enums.Delegacy;

public class LocalTest {
	
	@Test
	public void testLocal() {
		Assert.assertEquals(Delegacy.DP103, new Local(-23.551757,	-46.436759).getTheNearestDelegacy());
		Assert.assertEquals(Delegacy.DP98, new Local(-23.685592,	-46.637613).getTheNearestDelegacy());
	}

}
