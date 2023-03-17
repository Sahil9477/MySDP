package net.codejava;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visitor")
public class Visitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String visitor_id;
	

	
//	@Column(name="permission_status")
//	private boolean status=false;
//	
//	public boolean isStatus() {
//		return status;
//	}
//
//	public void setStatus() {
//		this.status = false;
//	}
    private String str_day;
    private String str_month;
    private String str_date;
    private String str_time;
    private String str_ist;
    private String str_year;
    
	@Column(name="visiting_time")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Visitor() {
		String []str = new String[10];
		str=new Date().toString().split(" ");
//		System.out.println( Arrays.toString(str));
		    str_day =str[0];
		     str_month=str[1];
		     str_date=str[2];
		     str_time=str[3];
		     str_ist=str[4];
		    str_year=str[5];
		
	
	}


	public String getStr_day() {
		return str_day;
	}

	public void setStr_day(String str_day) {
		this.str_day = str_day;
	}

	public String getStr_month() {
		return str_month;
	}

	public void setStr_month(String str_month) {
		this.str_month = str_month;
	}

	public String getStr_date() {
		return str_date;
	}

	public void setStr_date(String str_date) {
		this.str_date = str_date;
	}

	public String getStr_time() {
		return str_time;
	}

	public void setStr_time(String str_time) {
		this.str_time = str_time;
	}

	public String getStr_ist() {
		return str_ist;
	}

	public void setStr_ist(String str_ist) {
		this.str_ist = str_ist;
	}

	public String getStr_year() {
		return str_year;
	}

	public void setStr_year(String str_year) {
		this.str_year = str_year;
	}


	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String house_no;
	
	@Column(nullable = false)
	private String reason_visit;
	
	@Column(nullable = false)
	private String to_visit;
	
	@Column(nullable=false)
	private String visitor_phone;

	public String getId() {
		return visitor_id;
	}

	public void setId(String id) {
		this.visitor_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getReason_visit() {
		return reason_visit;
	}

	public void setReason_visit(String reason_visit) {
		this.reason_visit = reason_visit;
	}

	public String getTo_visit() {
		return to_visit;
	}

	public void setTo_visit(String to_visit) {
		this.to_visit = to_visit;
	}

	public String getVisitor_phone() {
		return visitor_phone;
	}

	public void setVisitor_phone(String visitor_phone) {
		this.visitor_phone = visitor_phone;
	}


}
