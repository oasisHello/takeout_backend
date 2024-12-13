package oasis.takeout.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.takeout.system.mapper.CoursesMapper;
import oasis.takeout.system.domain.Courses;
import oasis.takeout.system.service.ICoursesService;

/**
 * courseService业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-04
 */
@Service
public class CoursesServiceImpl implements ICoursesService 
{
    @Autowired
    private CoursesMapper coursesMapper;

    /**
     * 查询course
     * 
     * @param courseId course主键
     * @return course
     */
    @Override
    public Courses selectCoursesByCourseId(Long courseId)
    {
        return coursesMapper.selectCoursesByCourseId(courseId);
    }

    /**
     * 查询course列表
     * 
     * @param courses course
     * @return course
     */
    @Override
    public List<Courses> selectCoursesList(Courses courses)
    {
        return coursesMapper.selectCoursesList(courses);
    }

    /**
     * 新增course
     * 
     * @param courses course
     * @return 结果
     */
    @Override
    public int insertCourses(Courses courses)
    {
        return coursesMapper.insertCourses(courses);
    }

    /**
     * 修改course
     * 
     * @param courses course
     * @return 结果
     */
    @Override
    public int updateCourses(Courses courses)
    {
        return coursesMapper.updateCourses(courses);
    }

    /**
     * 批量删除course
     * 
     * @param courseIds 需要删除的course主键
     * @return 结果
     */
    @Override
    public int deleteCoursesByCourseIds(Long[] courseIds)
    {
        return coursesMapper.deleteCoursesByCourseIds(courseIds);
    }

    /**
     * 删除course信息
     * 
     * @param courseId course主键
     * @return 结果
     */
    @Override
    public int deleteCoursesByCourseId(Long courseId)
    {
        return coursesMapper.deleteCoursesByCourseId(courseId);
    }
}
