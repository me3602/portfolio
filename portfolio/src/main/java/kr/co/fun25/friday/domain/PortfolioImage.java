package kr.co.fun25.friday.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

@Entity
public @Data class PortfolioImage {

	@EmbeddedId
	private PortfolioImageId id;
	
	@MapsId("imageSeqNo")
	@ManyToOne
	@JoinColumn(name="SEQ_NO")
	private Portfolio portfolio;
	
	@Column(name="PATH")
	private String path; 
	
}
