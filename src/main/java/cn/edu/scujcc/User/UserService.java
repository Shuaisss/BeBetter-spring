package cn.edu.scujcc.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


@Service  //注册成为Spring成员 
public class UserService {
	@Autowired //java自动注入
	private UserRepository repo;//定义实义变量，java中如果只定义 默认为空指针
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);  //确认导入为org.slf4j 日志 logger
	@Autowired
	private CacheManager cacheManager;
	
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
			logger.error("用户" + user.getUsername()+"已存在。");
			throw new UserExistException();//发生错误后抛出错误
		}
		return result;
	}
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(String u,String p) {//传用户名密码
		User result = null;
		result = repo.findOneByUsernameAndPassword(u, p);//根据用户名密码查找
		return result;
	}

	public String checkIn(String username) {
		String uid = "";
		Long ts = System.currentTimeMillis();
		username = username + ts;
		uid = DigestUtils.md5DigestAsHex(username.getBytes());
		logger.debug(username + "经过md5加密后："+uid);
		Cache cache = cacheManager.getCache(User.CACHE_NAME);
		cache.put(uid,username);
		
		return uid;
	}
	
	/**
	 * 通过唯一编号uid查询用户名
	 * @param token 
	 * @return 用户名，如果没有返回null；
	 */
	public String currentUser(String token) {
		Cache cache = cacheManager.getCache(User.CACHE_NAME);
		return cache.get(token,String.class);
	}
}

