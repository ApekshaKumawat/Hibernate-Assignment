package HibernateAssignment.CRUD.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmpName {
	
	private String fName;
	private String mName;
	private String lName;
	public EmpName(String fName, String mName, String lName) {
		super();
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
	}
	public EmpName() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmpName [fName=" + fName + ", mName=" + mName + ", lName=" + lName + "]";
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}

}
