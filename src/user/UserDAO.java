package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//private int idx;
//private String userid;
//private String userpw;
//private String name;
//private String phone;
//private Date joindate;
//private String email;
//private String address;

public class UserDAO {
	
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
		
		return instance;
	}


	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	private DataSource ds;
	private Context init;
	
	public UserDAO() {
		
			try {
				
				init = new InitialContext();
				ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
				
			}catch (NamingException e) {
				System.out.println("생성자 예외 " + e);
			}
		
	}
	
	
	public ArrayList<UserDTO> showList(){
		
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		String sql = "select * from user_ order by idx";
		
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				UserDTO dto = new UserDTO();
				
				dto.setIdx(rs.getInt("idx"));
				dto.setUserid(rs.getString("userid"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				dto.setJoindate(rs.getDate("joindate"));
				
				list.add(dto);
				
						
			}
			
			
		}catch (SQLException e) {
			
		}finally {
			
			try {
			
			if(rs !=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			}
			catch ( Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		return list;
		
	
		
	}
	
	public int join(UserDTO dto) {
		
		int row = 0;
		String sql = "insert into user_ (userid, pw, name, phone, email, address) values (?,?,?,?,?,?)";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getAddress());
			
			row = pstmt.executeUpdate(); 
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {}
		}
		
		return row;
		
		
	}

	
	public int delete(int idx) {
		int row = 0;
		System.out.println("탈퇴");
		
		String sql ="delete user_ where idx= "+ idx;
		
		try {
			
			conn= ds.getConnection();
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
	
	
	public UserDTO login(UserDTO user) {
		
		UserDTO dto = null;
		
		String sql = "select * from user_ where userid = ? and pw = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getPw());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				dto = new UserDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setUserid(rs.getString("userid"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setJoindate(rs.getDate("joindate"));
				dto.setAddress(rs.getString("address"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
				
			}catch (Exception e) {
			}
			
		}
		
		
		return dto;
		
	}
	
	//마이 페이지 / 내정보
	
	public UserDTO selectOne(String userid) {
		
		UserDTO dto = new UserDTO();
		
		String sql = "select * from user_ where userid ='" + userid + "'";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setIdx(rs.getInt("idx"));
				dto.setUserid(rs.getString("userid"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				dto.setJoindate(rs.getDate("joindate"));
				
			}
			
		}catch (SQLException e) {
		
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
			}
		}
		
		return dto;
	
	}

	// 수정
	
	public int modify(UserDTO dto, int idx){
		
		int row =0;
		
		String sql = "update user_ set pw =?, name=?, phone=?, email=?, address=? where idx='" + idx + "'";
		System.out.println("수정");
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getAddress());
			
			row = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				
				if(rs != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {}
			
		}
		
		return row;
	}

}
