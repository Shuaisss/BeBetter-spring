package cn.edu.scujcc.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //注册为spring成员 包含主动转换json等功能
@RequestMapping("/user")//总的网址前缀 
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired 
	private UserService service;
	
	@PostMapping("/register") //与user拼接
	public User register(@RequestBody User u) {//@RequestBody将用户从body中传出来
		User result = null;
		logger.debug("用户注册:"+u);//在user中要先写同string否则打印无意义
		try {
			result = service.register(u);
		} catch (UserExistException e) {//catch 一旦出错 就执行
			logger.error("用户已存在，不能注册。",e);
		}//调用service的注册 
		//如果失败告诉用户
		return result;
	}

}
