package DEA_Labo4;

public class Bikote implements Comparable<Bikote> {
	
	String bikotekide;
	Double pageRank;
	
	public Bikote(String oraingoStr, Double unekoDou) {
		this.bikotekide=oraingoStr;
		this.pageRank=unekoDou;
	}
	
	public Double getPage(){
		return this.pageRank;
	}

	@Override
	public int compareTo(Bikote arg0) {
		if((arg0.getPage() - this.pageRank)>0){return 1;}
		else if((arg0.getPage() - this.pageRank)<0){return -1;}
		else if((arg0.getPage() - this.pageRank)>0){return 0;}
		return 1;
	}       

}

