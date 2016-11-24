package kr.co.fun25.friday.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	@Column(name="SKILLS")
	private String skills;
	@Column(name="CATEGORY")
	private String category;
	@Column(name="SUMMARY", columnDefinition="TEXT")
	private String summary;
	@Column(name="THUMBNAIL")
	private String thumbnail;
	@Column(name="HIT")
	private long hit;
	@Column(name="LINK")
	private String link;
	
	@OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
	private List<PortfolioImage> images;
	
}
