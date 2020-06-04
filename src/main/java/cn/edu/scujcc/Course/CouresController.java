package cn.edu.scujcc.Course;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/course")
public class CouresController {
	
	@GetMapping
	public List<Course> getAllCourse() {
		return null;
	}
	
	@GetMapping("/{id}")
	public Course getCourse(String id) {
		return null;
	}

}
