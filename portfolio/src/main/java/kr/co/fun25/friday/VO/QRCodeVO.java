package kr.co.fun25.friday.VO;

import lombok.Data;

public @Data class QRCodeVO {

	private String url;
	private int width;
	private int height;
	private String qrColor;
	private String backColor;

	public QRCodeVO(){}

	public QRCodeVO(String url, int width, int height) {
		super();
		this.url = url;
		this.width = width;
		this.height = height;
	}
	
	public QRCodeVO(String url, int width, int height, String qrColor, String backColor) {
		super();
		this.url = url;
		this.width = width;
		this.height = height;
		this.qrColor = qrColor;
		this.backColor = backColor;
	}

	public boolean isEmpty() {
		
		return (this.url == null && this.width == 0 && this.height == 0
				&& this.qrColor == null && backColor == null)
				? true : false;
	}
	
}
