package kr.co.fun25.friday.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
public @Data class PortfolioImage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IMG_SEQ_NO")
	private long imgSeqNo;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="SEQ_NO")
	private Portfolio portfolio;
	
	@Column(name="PATH")
	private String path;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PortfolioImage [imgSeqNo=").append(imgSeqNo).append(", path=").append(path).append("]");
		return builder.toString();
	} 
	
	
	
	
}
