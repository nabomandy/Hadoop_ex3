package wifi;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.io.Text;

public class Wifi {
	private String manageNum;
	private String gu;
	private String wifiName;
	private String address;
	private String specificAddress;
	private String location;
	private String type;
	private String agency;
	private String object;
	private String wifiType;
	private int year;
	private String indoorOutdoor;
	private String wifiVersion;
	private double xAxis;
	private double yAxis;
	private Date setDate;
	
	// text: "YC120019","양천구","오솔길근린공원","신월7동 977","","","3. 공원(하천)","","","","2019","실외","","126.836205","37.520855","2021-05-11 10:57:19.0"
	public Wifi(Text text) {
		try {
			String[] columns = text.toString().replace("\"", "").split(",");
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			manageNum = columns[0];
			gu = columns[1];
			wifiName = columns[2];
			address = columns[3];
			specificAddress = columns[4];
			location = columns[5];
			type = columns[6];
			agency = columns[7];
			object = columns[8];
			wifiType = columns[9];
			year = (columns[10].equals("")) ? 0 : Integer.parseInt(columns[10]);
			indoorOutdoor = columns[11];
			wifiVersion = columns[12];
			xAxis = Double.parseDouble(columns[13]);
			yAxis = Double.parseDouble(columns[14]);
			setDate = transFormat.parse(columns[15]);
		} catch (Exception e) { e.printStackTrace(); }
	}

	public String getManageNum() {
		return manageNum;
	}

	public void setManageNum(String manageNum) {
		this.manageNum = manageNum;
	}

	public String getGu() {
		return gu;
	}

	public void setGu(String gu) {
		this.gu = gu;
	}

	public String getWifiName() {
		return wifiName;
	}

	public void setWifiName(String wifiName) {
		this.wifiName = wifiName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpecificAddress() {
		return specificAddress;
	}

	public void setSpecificAddress(String specificAddress) {
		this.specificAddress = specificAddress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getWifiType() {
		return wifiType;
	}

	public void setWifiType(String wifiType) {
		this.wifiType = wifiType;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIndoorOutdoor() {
		return indoorOutdoor;
	}

	public void setIndoorOutdoor(String indoorOutdoor) {
		this.indoorOutdoor = indoorOutdoor;
	}

	public String getWifiVersion() {
		return wifiVersion;
	}

	public void setWifiVersion(String wifiVersion) {
		this.wifiVersion = wifiVersion;
	}

	public double getxAxis() {
		return xAxis;
	}

	public void setxAxis(double xAxis) {
		this.xAxis = xAxis;
	}

	public double getyAxis() {
		return yAxis;
	}

	public void setyAxis(double yAxis) {
		this.yAxis = yAxis;
	}

	public Date getSetDate() {
		return setDate;
	}

	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}
}
