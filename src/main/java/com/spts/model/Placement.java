package com.spts.model;

import java.sql.Date;

import lombok.*;

@Setter
@Getter
public class Placement {

	private int pid;
	private int sid;
	private int cid;
	private Date apply_date;
	private String status;
	private String studentName;
	private String companyName;
}
