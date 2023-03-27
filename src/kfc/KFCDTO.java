package kfc;

import java.io.File;

//KFC_IDX   NOT NULL NUMBER         
//MENU      NOT NULL VARCHAR2(100)  
//PRICE     NOT NULL NUMBER         
//CONTENT   NOT NULL VARCHAR2(1000) 
//KFC_KINDS          VARCHAR2(100)  
//

public class KFCDTO {
	
	private int kfc_idx;
	private String menu;
	private int price;
	private String content;
	private String kfc_kinds;
	private String imgPath;
	private File uploadFile;
	
	
	
	public KFCDTO() {
	}
	
	public String getImgPath() {
		return imgPath;
	}

	
	//생성자 만들기 filed
	public KFCDTO(int kfc_idx, String menu, int price, String content, String kfc_kinds, String imgPath,
			File uploadFile) {
		super();
		this.kfc_idx = kfc_idx;
		this.menu = menu;
		this.price = price;
		this.content = content;
		this.kfc_kinds = kfc_kinds;
		this.imgPath = imgPath;
		this.uploadFile = uploadFile;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public File getUploadFile() {
		return uploadFile;
	}


	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}


	public int getKfc_idx() {
		return kfc_idx;
	}
	public void setKfc_idx(int kfc_idx) {
		this.kfc_idx = kfc_idx;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKfc_kinds() {
		return kfc_kinds;
	}
	public void setKfc_kinds(String kfc_kinds) {
		this.kfc_kinds = kfc_kinds;
	}


	@Override
	public String toString() {
		return "KFCDTO [kfc_idx=" + kfc_idx + ", menu=" + menu + ", price=" + price + ", content=" + content
				+ ", kfc_kinds=" + kfc_kinds + "]";
	}
	
	

}
