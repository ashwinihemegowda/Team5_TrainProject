package com.torryharris.DAO;

import com.torryharris.model.UserLogin;
import com.torryharris.model.UserRegDTO;
import com.torryharris.rowMapper.RowMapper;
import com.torryharris.rowMapper.RowMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	JdbcTemplate jdbc;


	@Override
	public int registerUser(UserRegDTO u) {

		String sql = "insert into tbl_user(user_name,user_email,user_password,gender,country) "
				+ "values(?,?,?,?,?)";
		
		try {
			return jdbc.update(sql, u.getuserName(),u.getuserEmail(),
					u.getPassword(),u.getGender()+"",u.getCountry());
		}
		catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}

}
