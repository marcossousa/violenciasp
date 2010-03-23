package br.com.violencia.sp.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.violencia.sp.CrimesDetailService;

public class DadosCriminalidadeTest {
	
	@Test
	public void testaPesquisaComDelegaciaValida() throws Exception {
		Assert.assertEquals("4¼ DP", new CrimesDetailService().getCrimesDetailsByDelegacyName("4¼ DP").getDelegacy());
	}

}
