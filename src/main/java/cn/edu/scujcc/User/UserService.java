package cn.edu.scujcc.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //注册成为Spring成员 
public class UserService {
	@Autowired //java自动注入
	private UserRepository repo;//定义实义变量，java中如果只定义 默认为空指针
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);//确认导入为org.slf4j 日志 logger
	
	//用户注册功能 公有 希望注册后返回信息
	/**
	 * 用户注册，即把用户信息保存下来
	 * @param user 注册用户信息
	 * @return 保存后的用户信息（包含数据库id）
	 */
	public User register(User user) { //如果user不在一个包需要导入
		User result = null;
		result = repo.save(user);
		return result;
	}
}
