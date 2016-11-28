package kr.co.fun25.friday.VO;

import org.springframework.context.annotation.Bean;

import lombok.Data;

public @Data class EmailVO {

	private String name;
	private String addr;
	private String title;
	private String contents;
}
