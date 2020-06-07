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
	public Response register(@RequestBody User u) {//@RequestBody将用户从body中传出来
		Response result =  new Response();
		logger.debug("用户注册:"+u);//在user中要先写同string否则打印无意义
		try {
			User saved =service.register(u);
			result.setStatus(Response.STATUS_OK);
			result.setData(saved);//将保存好的用户当成数据返回
		} catch (UserExistException e) {//catch 一旦出错 就执行
			logger.error("用户已存在，不能注册。");
			Response r = new Response();
			r.setStatus(Response.STATUS_ERROR);
			r.setMessage("用户已存在，不能注册。");//用户可以看到错误信息
		} 
		//如果失败告诉用户
		return result;
	}
	
	public Response login(String username,String password) {
		Response result =  new Response();
		User saved =  service.login(username,password);//User有值 说明用户名密码正确  为空 说明错误 下面进行判断
		if(saved != null) {//登录成功
			//根据用户名把用户找回来 
			result.setStatus(Response.STATUS_OK);
			result.setData(saved);
		}else {//登录失败
			logger.error("登录失败");
			result.setStatus(Response.STATUS_ERROR);
			result.setMessage("密码错误");
		}
		return result;
	}

}
