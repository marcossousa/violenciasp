package br.com.violencia.sp;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class YMap {

	private static final String BASE_URI = "http://local.yahooapis.com/MapsService/V1/geocode?appid=YD-9G7bey8_JXxQP6rxl.fBFGgCdNjoDMACQA--";
	
	public YMap() {
	}
	
	@SuppressWarnings({ "unchecked" })
	public Double[] getCoordinatesForAddress(String address) throws Exception {	
		String request = BASE_URI + "&city=sao+paulo&street="+URLEncoder.encode(address, "UTF-8");
		URL url = new URL(request);
        
        SAXReader reader = new SAXReader();
        Document xml = reader.read(url.openStream());
        List<Element> resultSet = xml.selectNodes("//ResultSet");
        Double[] coordenates = new Double[2];
		if (!resultSet.isEmpty()) {
        	Iterator<Element> result = resultSet.get(0).elementIterator();
        	 if (result.hasNext()) {
             	Element addressNode = result.next();
             	coordenates[0] = readAddressItem(addressNode.elementIterator(), "Latitude");
             	coordenates[1] = readAddressItem(addressNode.elementIterator(), "Longitude");
             }
        }

        return coordenates;
	}
	
	public double readAddressItem(Iterator<Element> addressIterator, String itemName) {
		while (addressIterator.hasNext()) {
     		Element addressItem = addressIterator.next();
     		if (itemName.equals(addressItem.getName())) {
     			return Double.parseDouble((String)addressItem.getData());
     		}
		}
		
		return 0.0;
	}
	
}
