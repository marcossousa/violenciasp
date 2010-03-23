package br.com.violencia.sp;

public class CriminalInfo {
	
	private String delegacy;
	private String thieves;
	private String robbery;
	private String kidnapping;
	private String extortion;
	private String swindler;
	private String others;
	private String total;
	private CriminalInfo globalInfo;
	
	public CriminalInfo() {}
	
	public String getDelegacy() {
		return delegacy;
	}
	public void setDelegacy(String nome) {
		this.delegacy = nome;
	}
	public String getThieves() {
		return thieves;
	}
	
	public String getPercentageThieves() {
		try {
			int t = Integer.parseInt(thieves.replace(".", ""));
			float p = ((t*100) / Integer.parseInt(globalInfo.getThieves().replace(".", "")));
			return "" + p + "%";
		} catch (Throwable e) {
			return "0%";
		}
	}
	
	public void setThieves(String thieves) {
		this.thieves = thieves;
	}
	public String getRobbery() {
		return robbery;
	}
	
	public String getPercentageRobbery() {
		try {
			int t = Integer.parseInt(robbery.replace(".", ""));
			float p = ((t*100) / Integer.parseInt(globalInfo.getRobbery().replace(".", "")));
			return "" + p + "%";
		} catch (Throwable e) {
			return "0%";
		}
	}
	
	public void setRobbery(String roubo) {
		this.robbery = roubo;
	}
	public String getKidnapping() {
		return kidnapping;
	}
	
	public String getPercentageKidnapping() {
		try {
			int t = Integer.parseInt(kidnapping.replace(".", ""));
			float p = ((t*100) / Integer.parseInt(globalInfo.getKidnapping().replace(".", "")));
			return "" + p + "%";
		} catch (Throwable e) {
			return "0%";
		}
	}
	
	public void setKidnapping(String kidnapping) {
		this.kidnapping = kidnapping;
	}
	public String getExtortion() {
		return extortion;
	}
	
	public String getPercentageExtortion() {
		try {
			int t = Integer.parseInt(extortion.replace(".", ""));
			float p = ((t*100) / Integer.parseInt(globalInfo.getExtortion().replace(".", "")));
			return "" + p + "%";
		} catch (Throwable e) {
			return "0%";
		}
	}
	
	public void setExtortion(String extortion) {
		this.extortion = extortion;
	}
	public String getSwindler() {
		return swindler;
	}
	
	public String getPercentageSwindler() {
		try {
			int t = Integer.parseInt(swindler.replace(".", ""));
			float p = ((t*100) / Integer.parseInt(globalInfo.getSwindler().replace(".", "")));
			return "" + p + "%";
		} catch (Throwable e) {
			return "0%";
		}
	}
	
	public void setSwindler(String swindler) {
		this.swindler = swindler;
	}
	public String getOthers() {
		return others;
	}
	
	public String getPercentageOthers() {
		try {
			int t = Integer.parseInt(others.replace(".", ""));
			float p = ((t*100) / Integer.parseInt(globalInfo.getOthers().replace(".", "")));
			return "" + p + "%";
		} catch (Throwable e) {
			return "0%";
		}
	}
	
	public void setOutros(String others) {
		this.others = others;
	}
	public String getTotal() {
		return total;
	}
	
	public String getPercentageTotal() {
		try {
			int t = Integer.parseInt(total.replace(".", ""));
			float p = ((t*100) / Integer.parseInt(globalInfo.getTotal().replace(".", "")));
			return "" + p + "%";
		} catch (Throwable e) {
			return "0%";
		}
	}
	
	public void setTotal(String total) {
		this.total = total;
	}

	public void setGlogalInfo(CriminalInfo criminalInfo) {
		this.globalInfo = criminalInfo;
	}
	
	
}
