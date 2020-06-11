package cn.edu.scujcc.Course;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/course")
public class CouresController {
	public static final Logger logger= LoggerFactory.getLogger(CouresController.class);
	
	@Autowired
	private CourseService service;
	
	@GetMapping
	public List<Course> getAllCourse() {
		logger.info("正在读取所有课程信息");
		List<Course> results = service.getAllCourses();
		return results;
	}
	
	@GetMapping("/{id}")
	public Course getCourse(@PathVariable String id) {
		logger.info("正在获取课程："+id);
		Course c = service.getChannel(id);
		if (c != null) {
			return c;
		} else {
			logger.error("找不到指定的频道。");
			return null;
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
