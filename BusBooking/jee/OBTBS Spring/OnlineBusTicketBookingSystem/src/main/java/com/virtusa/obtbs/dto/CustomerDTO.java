package com.virtusa.obtbs.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cust_tb")
public class CustomerDTO {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
		private String custname;
		private String custphonenumber;
	    private String custpassword;
	    

	    public CustomerDTO() {
	    	
	    }
	    

		


		
		public CustomerDTO(String custname, String custphonenumber, String custpassword) {
			super();
			this.custname = custname;
			this.custphonenumber = custphonenumber;
			this.custpassword = custpassword;
		}






		public int getId() {
			return id;
		}






		public void setId(int id) {
			this.id = id;
		}






		public String getCustname() {
			return custname;
		}






		public void setCustname(String custname) {
			this.custname = custname;
		}






		public String getCustphonenumber() {
			return custphonenumber;
		}






		public void setCustphonenumber(String custphonenumber) {
			this.custphonenumber = custphonenumber;
		}






		public String getCustpassword() {
			return custpassword;
		}






		public void setCustpassword(String custpassword) {
			this.custpassword = custpassword;
		}






		@Override
		public String toString() {
			return "CustomerDTO [id=" + id + ", custname=" + custname + ", custphonenumber=" + custphonenumber
					+ ", custpassword=" + custpassword + "]";
		}






		
	
	
}
