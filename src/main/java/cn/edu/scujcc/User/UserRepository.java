package cn.edu.scujcc.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 用户储存库
 * @author Administrator
 *
 */
public interface UserRepository extends MongoRepository <User, String>{
	

}
