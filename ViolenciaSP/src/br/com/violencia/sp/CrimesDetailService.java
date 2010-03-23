package br.com.violencia.sp;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class CrimesDetailService {

	private static final String BASE_YQL_URL = "http://query.yahooapis.com/v1/public/yql?format=xml&q=use+%27http://violenciasp.appspot.com/crimescontrapatrimonio.xml%27+as+indice_violencia;select+*+from+indice_violencia";
	
	public CrimesDetailService() {
	}
	
	@SuppressWarnings({ "unchecked" })
	public CriminalInfo getCrimesDetailsByDelegacyName(String nome) throws Exception {
		String request = BASE_YQL_URL + "+where+nome+=+%27"+URLEncoder.encode(nome, "UTF-8") + "%27";
		URL url = new URL(request);
		CriminalInfo info = new CriminalInfo();
        
        SAXReader reader = new SAXReader();
        Document xml = reader.read(url.openStream());
        List<Element> resultSet = xml.selectNodes("//results/delegacies");
		if (!resultSet.isEmpty()) {
        	Iterator<Element> result = resultSet.get(0).elementIterator();
        	 if (result.hasNext()) {
             	Element delegacies = result.next();
             	info = readCrimininalInfo(delegacies.elementIterator());  	
             }
        }

        return info;
	}
	
	private CriminalInfo readCrimininalInfo(Iterator<Element> delegacyNodes) throws Exception{
		CriminalInfo info = new CriminalInfo();
		String[] fiedls = {"delegacy", "robbery", "thieves", "kidnapping", "extortion", "swindler", "others","total"};
		while (delegacyNodes.hasNext()) {
     		Element nodes = delegacyNodes.next();
     		for (String field: fiedls) {
         		if (field.equals(nodes.getName())) {
         			Field f = CriminalInfo.class.getDeclaredField(field);
         			f.setAccessible(true);
         			f.set(info, (String)nodes.getData());
         			break;
         		}
     		}
     	}
		return info;
	}
	
}
