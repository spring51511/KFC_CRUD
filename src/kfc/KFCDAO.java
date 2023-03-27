package kfc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.org.glassfish.gmbal.ParameterNames;

public class KFCDAO {

	private static KFCDAO instance = new KFCDAO();

	public static KFCDAO getInstance() {
		return instance;
	}
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private DataSource ds;
	private Context init;
	
	private KFCDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
						
		}catch (NamingException e) {
			System.out.println("생성자 예외" + e);
		}
	}
	
	
	//목록 출력
	
	public ArrayList<KFCDTO> selectList(){
		ArrayList<KFCDTO> list = new ArrayList<KFCDTO>();
		String sql = "select * from KFC order by kfc_idx";
		System.out.println("0");
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				KFCDTO dto = new KFCDTO(); 
				dto.setKfc_idx(rs.getInt("kfc_idx"));
				dto.setMenu(rs.getString("menu"));
				dto.setPrice(rs.getInt("price"));
				dto.setContent(rs.getString("content"));
				dto.setKfc_kinds(rs.getString("kfc_kinds"));
				dto.setImgPath(rs.getString("imgPath"));
				
				list.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!= null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {}
		}
		return list;
		
	}
	
	//종류선택
	
	public ArrayList<KFCDTO> selectKinds(String kfc_kinds){
		
		ArrayList<KFCDTO> list = new ArrayList<KFCDTO>();
		String sql = "select * from kfc where kfc_kinds='" + kfc_kinds + "'" ;
		System.out.println("1");
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				KFCDTO dto = new KFCDTO();
				dto.setKfc_idx(rs.getInt("kfc_idx"));
				dto.setMenu(rs.getString("menu"));
				dto.setKfc_kinds(rs.getString("kfc_kinds"));
				dto.setPrice(rs.getInt("price"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setContent(rs.getString("content"));
			
				list.add(dto);
			}
			
		}catch (SQLException e) {
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {}
			
		}
		return list;
		
	}
	
	//상품 하나 선택 / 디테일
	
	public KFCDTO selectOne(int kfc_idx) {
		
		
		String sql = "select * from kfc where kfc_idx="+ kfc_idx ;
		KFCDTO dto = null;
		
		System.out.println("디테일");
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				dto = new KFCDTO();
				
				dto.setKfc_idx(rs.getInt("kfc_idx"));
				dto.setMenu(rs.getString("menu"));
				dto.setKfc_kinds(rs.getString("kfc_kinds"));
				dto.setPrice(rs.getInt("price"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setContent(rs.getString("content"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {}
		}
		return dto;
		
	}
	
	//상품 추가
	public int insert(KFCDTO dto) {
		int row =0;
		String sql = "insert into KFC (menu,price,content,kfc_kinds,imgPath) values(?,?,?,?,?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMenu());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getKfc_kinds());
			pstmt.setString(5, dto.getImgPath());
			
			row = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
					
				}catch(SQLException e) {}
		}
		
		return row;
	}
	
	//상품 삭제
	public int delete(int kfc_idx) {
		
		int row = 0;
		String sql = "delete from kfc where kfc_idx=" + kfc_idx; 
		
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			row = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {}
		}
		
		return row; 
	}
	
	
	public int modify(KFCDTO dto, int kfc_idx) {
		int row = 0;
		String sql = "update kfc set menu=?,kfc_kinds=?,price=?, imgPath=?, content=?  where kfc_idx=" + kfc_idx;
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMenu());
			pstmt.setString(2, dto.getKfc_kinds());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getImgPath());
			pstmt.setString(5, dto.getContent());
			
			row = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {}
		}
		return row;
		
	}

	
}
