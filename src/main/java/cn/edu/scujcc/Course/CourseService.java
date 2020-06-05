package cn.edu.scujcc.Course;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * �ṩ�γ�ģ������
 * @author 86133
 *
 */
@Service
public class CourseService {
	private List<Course> course;
	
	public CourseService() {
		for(int i = 0;i<10;i++) {
			Course c = new Course();
			c.setId(""+(i + 1));
			c.setName("��"+(i+1)+"�ڿγ�");
			c.setPrice(""+(i+1)*(i+1));
			c.setUrl("http://baidu.com");
		}
	}
	
	/**
	 * �½�һ��Ƶ��
	 * @param id
	 * @return
	 */
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
	
	/**
	 * ����һ��Ƶ��
	 * @param c
	 * @return
	 */
	public Course updateCourse (Course c) {
		Course toChange = getCourse(c.getId());
		if(toChange != null) {
			toChange.setName(c.getName());
			toChange.setPrice(c.getPrice());
			toChange.setUrl(c.getUrl());
		}
		return toChange;
	}
	
	public boolean deleteCourse(String id) {
		boolean result = true;
		for(Course c : this.course) {
			if(id == c.getId()) {
				this.course.remove(c);
				result = true;
				break;
			}
		}
		return result;
	}
	
	public Course creatCourse(Course c) {
		c.setId(this.course.get(this.course.size()-1).getId()+1);
		this.course.add(c);
		return c;
	}

	public List<Course> getAllCourse() {
		return this.course;
	}
}
