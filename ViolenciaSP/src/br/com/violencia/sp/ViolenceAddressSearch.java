package br.com.violencia.sp;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import br.com.violencia.sp.enums.Delegacy;

@SuppressWarnings("serial")
public class ViolenceAddressSearch extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(ViolenceAddressSearch.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/xml");
		
		try {
			Local local = getAddressLocation(req.getParameter("address"));
			
			Document document = DocumentHelper.createDocument();
			Element resultElement = document.addElement("result");
			writeAddressLocation(resultElement, local);
			CriminalInfo dados = writeDelegacyAndCrimesIndices(resultElement, local);
			writePercentageDetails(resultElement, dados);
			
			
			XMLWriter writer = new XMLWriter(resp.getWriter());
			writer.write(document);
			
		} catch (Exception e) {
			logger.warning("Erro na servlet: " + e.getMessage());
		}
		
	}

	private void writePercentageDetails(Element resultElement,
			CriminalInfo dados) throws Exception {
		CriminalInfo dadosTotais = new CrimesDetailService().getCrimesDetailsByDelegacyName("MUNICÍPIO DE SÃO PAULO");
		dados.setGlogalInfo(dadosTotais);
		Element percentages = resultElement.addElement("percentages");
		percentages.addElement("p_thieves").setText(dados.getPercentageThieves());
		percentages.addElement("p_robbery").setText(dados.getPercentageRobbery());
		percentages.addElement("p_kiddnapping").setText(dados.getKidnapping());
		percentages.addElement("p_extortion").setText(dados.getPercentageExtortion());
		percentages.addElement("p_swindler").setText(dados.getPercentageSwindler());
		percentages.addElement("p_others").setText(dados.getPercentageOthers());
		percentages.addElement("p_total").setText(dados.getPercentageTotal());
	}

	private CriminalInfo writeDelegacyAndCrimesIndices(Element resultElement,
			Local local) throws Exception {
		Delegacy nearestDelegacy = local.getTheNearestDelegacy();
		Element delegacy = resultElement.addElement("delegacy");

		Element name = delegacy.addElement("delegacy_name");
		name.setText(nearestDelegacy.getNome());
		
		Element latitude = delegacy.addElement("delegacy_latitude");
		latitude.setText(String.valueOf(nearestDelegacy.getLatitude()));
		Element longitude = delegacy.addElement("delegacy_longitude");
		longitude.setText(String.valueOf(nearestDelegacy.getLongitude()));
		
		return writeDelegacyCrimesDetails(nearestDelegacy, delegacy);
	}

	private CriminalInfo writeDelegacyCrimesDetails(Delegacy nearestDelegacy,
			Element delegacy) throws Exception {
		Element crimes = delegacy.addElement("crimes");
		
		CriminalInfo info = new CrimesDetailService().getCrimesDetailsByDelegacyName(nearestDelegacy.getNome()) ;
		crimes.addElement("thieves").setText(info.getThieves());
		crimes.addElement("robbery").setText(info.getRobbery());
		crimes.addElement("kidnapping").setText(info.getKidnapping());
		crimes.addElement("extortion").setText(info.getExtortion());
		crimes.addElement("swindler").setText(info.getSwindler());
		crimes.addElement("others").setText(info.getOthers());
		crimes.addElement("total").setText(info.getTotal());
		return info;
	}

	private void writeAddressLocation(Element resultElement, Local local) {
		Element address = resultElement.addElement("Address");
		Element latitude = address.addElement("address_latitude");
		latitude.setText(String.valueOf(local.getLatitude()));
		Element longitude = address.addElement("address_longitude");
		longitude.setText(String.valueOf(local.getLongitude()));
	}
	
	private Local getAddressLocation(String street) throws Exception {
		YMap ymap = new YMap();
		Double[] s = ymap.getCoordinatesForAddress(street);
		
		return new Local(s[0], s[1]);
	}
}
