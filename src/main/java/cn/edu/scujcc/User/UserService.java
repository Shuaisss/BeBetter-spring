package cn.edu.scujcc.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //注册成为Spring成员 
public class UserService {
	@Autowired //java自动注入
	private UserRepository repo;//定义实义变量，java中如果只定义 默认为空指针
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);  //确认导入为org.slf4j 日志 logger
	
	//用户注册功能 公有 希望注册后返回信息
	/**
	 * 用户注册，即把用户信息保存下来
	 * @param user 注册用户信息
	 * @return 保存后的用户信息（包含数据库id）
	 */
	public User register(User user) throws UserExistException{//定义注册时可能会报错
		User result = null;
		//决断用户名是否已经在数据库中存在
		User saved = repo.findFirstByUsername(user.getUsername());
		if(saved == null) {
			result = repo.save(user); 
		}else {
			//用户已存在
			logger.error("用户"+user.getUsername()+"已存在。");
			throw new UserExistException();//发生错误后抛出错误
		}
		return result;
	}
}
