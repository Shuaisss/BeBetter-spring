package cn.edu.scujcc.Course;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


@Service
public class CourseService {
	@Autowired
	private CourseRepository repo;
	
	private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
	
	private List<Course> course;
	
	@Cacheable("courses")
	public List<Course> getAllCourses(){
		logger.debug("从数据库获取课程信息");
		return repo.findAll();
	}
	
	//获取一个课程的数据
	@Cacheable("courses")
	public Course getChannel(String courseId) {
		logger.debug("准备从数据库读取频道信息"+courseId);
		Optional<Course> result = repo.findById(courseId);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
	}
	
	//删除一个课程的数据
	public boolean deleteChannel(String courseId) {
		boolean result = true;
		repo.deleteById(courseId);
		return result;
	}
	
	//保存一个不含id的课程数据
	@PostMapping
	public Course creatChannel(Course c) {
		return repo.save(c);
	}
	
	@PostMapping
	public Course updateChannel(Course c) {
		Course saved = getChannel(c.getId());
		if(saved != null) {
			//方法一:自己一个一个的复制数据
			if(c.getTitle() != null) {
				saved.setTitle(c.getTitle());
			}
			if(c.getPrice() != null) {
				saved.setPrice(c.getPrice());
			}
			if(c.getUrl() != null) {
				saved.setUrl(c.getUrl());
			}
						
		}
			return repo.save(saved);
		}
	
	/**
	 * 新建一个频道
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
	 * 更新一个频道
	 * @param c
	 * @return
	 */
	public Course updateCourse (Course c) {
		Course toChange = getCourse(c.getId());
		if(toChange != null) {
			toChange.setTitle(c.getTitle());
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
		return repo.save(c);
	}


	//根据课程名称查找课程
	public List<Course> searchTitle(String title) {
		// TODO Auto-generated method stub
		return repo.findByTitle(title);
	}
}
