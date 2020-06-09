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
		logger.info("正在返回课程信息");
		return this.service.getAllCourse();
	}
	
	@GetMapping("/{id}")
	public Course getCourse(@PathVariable String id) {
		logger.info("获取课程id:"+id);
		Course c = service.getCourse(id);
		if(c !=null) {
			return c;
		}else {
			logger.error("找不到指定课程");
			return null;
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable String id){
		boolean result = this.service.deleteCourse(id);
		if(result) {
			return ResponseEntity.ok().body("删除课程成功");
		}else {
			return ResponseEntity.ok().body("删除课程失败");
		}
	}
	
	@PostMapping
	public Course creatCourse(@RequestBody Course c) {
		return this.service.creatCourse(c);
	}
	
	public Course updateCourse(@RequestBody Course c) {
		return this.service.updateCourse(c);
	}

}
