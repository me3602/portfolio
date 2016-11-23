package kr.co.fun25.friday.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
public @Data class PortfolioImageId implements Serializable {	
	private long portfolioSeqNo;
	private long imageSeqNo;
}
