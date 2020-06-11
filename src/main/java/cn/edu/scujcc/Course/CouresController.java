package cn.edu.scujcc.Course;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.scujcc.User.UserService;
import cn.edu.scujcc.model.Channel;


@RestController
@RequestMapping("/course")
public class CouresController {
	public static final Logger logger= LoggerFactory.getLogger(CouresController.class);
	
	@Autowired
	private CourseService service;

	@Autowired
	private UserService userService;

	
	@GetMapping
	public List<Course> getAllCourse(@RequestHeader("token") String token) {
		logger.info("正在读取所有课程信息,token(UID)="+token);
		String user = userService.currentUser(token);
		logger.info("当前用户是:"+user);
		List<Course> results = service.getAllCourse();
		logger.debug("一共有"+results.size()+"个课程");
		return results;
	}
	
	@GetMapping("/{id}")
	public Course getCourse(@PathVariable String id) {
		logger.info("获取课程id:"+id);
		Cache cache = cacheManager.getCache("users");
		Object token = cache.get("token");
		if(token != null) {
			logger.debug("当前已登录的用户是:"+token);
			Course c = service.getCourse(id);
			if(c != null) {
				return c;
			}else {
				logger.error("找不到指定频道");
				return null;
			}
		}
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable String id){
		System.out.println("即将删除频道,id="+id);
		boolean result = this.service.deleteCourse(id);
		if(result) {
			return ResponseEntity.ok().body("删除课程成功");
		}else {
			return ResponseEntity.ok().body("删除课程失败");
		}
	}
	
	@PostMapping
	public Course creatCourse(@RequestBody Course c) {
		System.out.println("即将新建课程"+c);
		Course saved = service.creatCourse(c);
		return saved;
	}
	
	public Course updateCourse(@RequestBody Course c) {
		System.out.println("即将更新课程"+c);
		Course updated = service.updateCourse(c);
		return updated;	
	}

	/**
	 * 根据课程名称查找课程
	 * @param title
	 * @return
	 */
	@GetMapping("/t/{title}")
	public List<Course> searchTitle(@PathVariable String title){
		return service.searchTitle(title);
	}
}
