package cn.edu.scujcc.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 用户储存库
 * @author Administrator
 *
 */
public interface UserRepository extends MongoRepository <User, String>{
	public User findFirstByUsername(String username);//找到第一个用户名
	
	public User findOneByUsernameAndPassword(String u,String p);//找到一个相匹配的用户名与密码 
}
