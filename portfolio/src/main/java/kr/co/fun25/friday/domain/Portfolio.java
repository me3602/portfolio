package kr.co.fun25.friday.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Portfolio {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="SEQ_NO")
	private long seqNo;	
	@Column(name="NAME")
	private String name;	
	@Column(name="START_DATE")
	private Timestamp  startDate;
	@Column(name="END_DATE")
	private Timestamp  endDate;
	@Column(name="LANGUEGE")
	private String languege;
	@Column(name="CATEGORY")
	private String category;
	@Column(name="SUMMARY", columnDefinition="TEXT")
	private String summary;
	@Column(name="THUMBNAIL")
	private String thumbnail;
	
}
