//package cn.edu.scujcc.Course;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/course")
//public class CouresController {
//	
//	@Autowired
//	private CourseService service;
//	
//	@GetMapping
//	public List<Course> getAllCourse() {
//		return this.service.getAllCourse();
//	}
//	
//	@GetMapping("/{id}")
//	public Course getCourse(@PathVariable String id) {
//		return this.service.getCourse(id);
//	}
//	
//	/**
//	 * ɾ��һ��ָ���
//	 * @param id
//	 * @return
//	 */
//	@GetMapping("/{id}")
//	public ResponseEntity<String> deleteCourse(@PathVariable String id){
//		boolean result = this.service.deleteCourse(id);
//		if(result) {
//			return ResponseEntity.ok().body("ɾ���γ̳ɹ�");
//		}else {
//			return ResponseEntity.ok().body("ɾ���γ�ʧ��");
//		}
//	}
//	/**
//	 * �½�һ��Ƶ��
//	 * @param c �½�Ƶ��������
//	 * @return ����������
//	 */
//	@PostMapping
//	public Course creatCourse(@RequestBody Course c) {
//		return this.service.creatCourse(c);
//	}
//	
//	public Course updateCourse(@RequestBody Course c) {
//		return this.service.updateCourse(c);
//	}
//
//}
