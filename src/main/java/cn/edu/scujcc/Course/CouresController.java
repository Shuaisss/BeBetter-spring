package cn.edu.scujcc.Course;

import java.util.List;

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
	@Autowired
	private CourseService service;
	
	@GetMapping
	public List<Course> getAllCourse() {
		return service.getAllCourse();
	}
	
	@GetMapping("/{id}")
	public Course getCourse(@PathVariable String id) {
		return service.getCourse(id);
	}
	
	/**
	 * 删除一个指定的课程
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable String id){
		return ResponseEntity.ok().body("删除课程成功");
	}
	/**
	 * 新建一个频道
	 * @param c 新建频道的数据
	 * @return 保存后的数据
	 */
	@PostMapping
	public Course creatCourse(@RequestBody Course c) {
		return null;
	}
	
	public Course updateCourse(@RequestBody Course c) {
		return null;
	}

}
