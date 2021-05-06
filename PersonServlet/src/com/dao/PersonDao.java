package com.dao;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import com.model.Person;

	public class PersonDao {
		Connection getConnect() {
			Connection con = null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3307/person", "root", "root");
				System.out.println("connected");
			} catch (Exception e) {
				System.out.println(e);
			}
			return con;
		}

		public boolean addPerson(Person person) {
			boolean b = false;
			try {
				Connection con = getConnect();
				PreparedStatement pst = con
						.prepareStatement("insert into persons(ename,contactno,email,gender,address)values(?,?,?,?,?)");
				pst.setString(1, person.getEname());
				pst.setString(2, person.getContactno());
				pst.setString(3, person.getEmail());
				pst.setString(4, person.getGender());
				pst.setString(5, person.getAddress());
				int res = pst.executeUpdate();
				if (res > 0) {
					b = true;
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			return b;
		}

		public List<Person> listPersons() {
		//public List<Person> listPersons() {
			List<Person> list = new ArrayList<Person>();
			try {
				Connection con = getConnect();
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from persons");
				while(res.next()) {
					Person p = new Person(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
					list.add(p);
					
				}
				res.close();
		  }catch (Exception e) {
				System.out.println(e);
			}
		return list;
	    }
		
		public boolean validate(String uname, String pword) {
			boolean b = false;
			try {
				Connection con = getConnect();
				PreparedStatement pst = con.prepareStatement("select * from persons where ename = ? and contactno=?");
				pst.setString(1, uname);
					pst.setString(2, pword);
		
					
					ResultSet res = pst.executeQuery();
					if(res.next()) {
						b = true;
					}
				
			}catch(Exception e) {
				System.out.println(e);
			}
			return b;
		}
		public boolean delPerson(int num) {
			boolean b = false;
			try {
				Connection con = getConnect();
				PreparedStatement pst = con.prepareStatement("delete from persons where pid = ?");
				pst.setInt(1, num);
				int res = pst.executeUpdate();
				if(res > 0) {
					b = true;
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			return b;
		}
		
		 public boolean updatePerson(Person person) {
		        boolean b = false;
		        try {             Connection con = getConnect();
		            PreparedStatement pst = con.prepareStatement(
		                    "update persons set ename = ?,contactno = ?,email=?,gender=?,address=? where pid=?");
		            pst.setString(1, person.getEname());
		            pst.setString(2, person.getContactno());
		            pst.setString(3, person.getEmail());
		            pst.setString(4, person.getGender());
		            pst.setString(5, person.getAddress());
		            pst.setInt(6, person.getPid());
		            int res = pst.executeUpdate();
		            if (res > 0) {
		                b = true;
		            }         } catch (Exception e) {
		            System.out.println(e);
		        }
		        return b;
		    }
		
	}