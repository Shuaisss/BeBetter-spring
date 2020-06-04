package cn.edu.scujcc.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * �ṩ�γ�ģ������
 * @author 86133
 *
 */
public class CourseService {
	private List<Course> course = new ArrayList<>();
	
	public CourseService() {
		for(int i = 1;i<=10;i++) {
			Course c = new Course();
			c.setId("��"+i);
			c.setName("��"+i+"�ڿγ�");
			c.setPrice("�۸�Ϊ"+i*2);
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
