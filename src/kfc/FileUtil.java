package kfc;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
//import com.oreilly.servlet.multipart.FileRenamePolicy;


public class FileUtil {

	private static String saveDirectory;
	private static int maxPostSize = 1024 * 1024 * 50;
	private static String encoding = "UTF-8";
//	private static FileRenamePolicy namePolicy = new DefaultFileRenamePolicy();
	
	public static KFCDTO getDTO(HttpServletRequest request) throws IOException {
		KFCDTO dto = null;
		
		saveDirectory = request.getServletContext().getRealPath("upload");
		
		File dir = new File(saveDirectory);
		
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		MultipartRequest mpRequest = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
		
		dto = new KFCDTO();
		dto.setMenu(mpRequest.getParameter("menu"));
		dto.setKfc_kinds(mpRequest.getParameter("kfc_kinds"));
		dto.setPrice(Integer.parseInt(mpRequest.getParameter("price")));
		dto.setImgPath(mpRequest.getFile("uploadFile").getName());
		dto.setContent(mpRequest.getParameter("content"));
		dto.setUploadFile(mpRequest.getFile("uploadFile"));
	
		return dto;
	}
	
	
	
}
