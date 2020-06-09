package cn.edu.scujcc.Course;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course,String>{
	public List<Course> findByTitle(String t);//按照课程名字查询
}
