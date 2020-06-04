package cn.edu.scujcc.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供课程模拟数据
 * @author 86133
 *
 */
public class CourseService {
	private List<Course> course = new ArrayList<>();
	
	public CourseService() {
		for(int i = 1;i<=10;i++) {
			Course c = new Course();
			c.setId("第"+i);
			c.setName("第"+i+"节课程");
			c.setPrice("价格为"+i*2);
			c.setUrl("http://baidu.com");
			course.add(c);
		}
	}
	
	public List<Course> getAllCourse(){
		return this.course;
	}
	
	public Course getCourse(String id) {
		Course result = null;
		for(Course c : this.course) {
			if(id == c.getId()) {
				result = c;
				break;
			}
		}
		return result;
	}
}
