package br.com.violencia.sp.test;


import org.junit.Test;

import br.com.violencia.sp.YMap;


/**
 * @author rafael
 *
 */
public class YMapTest {

	@Test
	public void testLoadYMap() throws Exception {
		YMap y = new YMap();
		Double[] s =y.getCoordinatesForAddress("Rua ofelia");
		
		System.out.println("Latitude:"+ s[0] +", Longitude: " + s[1]);
	}

}
