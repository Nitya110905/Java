package model;

public class product {
	private int pid;
	private int sid;
	private int pprice;
	private String pname;
	private String pcompany;
	private String pdesc;
	private int pquant;
	private String pimage;
	
	public product() {
		super();
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcompany() {
		return pcompany;
	}

	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Integer getPquant() {
		return pquant;
	}

	public void setPquant(int pquant) {
		this.pquant = pquant;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	
	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", pcompany=" + pcompany + ", pdesc=" + pdesc + ", pquant="
				+ pquant + ", pimage=" + pimage + "]";
	}
	
}
