package oasis.takeout.system.service;

import java.util.List;
import oasis.takeout.system.domain.Courses;

/**
 * courseService接口
 * 
 * @author ruoyi
 * @date 2024-12-04
 */
public interface ICoursesService 
{
    /**
     * 查询course
     * 
     * @param courseId course主键
     * @return course
     */
    public Courses selectCoursesByCourseId(Long courseId);

    /**
     * 查询course列表
     * 
     * @param courses course
     * @return course集合
     */
    public List<Courses> selectCoursesList(Courses courses);

    /**
     * 新增course
     * 
     * @param courses course
     * @return 结果
     */
    public int insertCourses(Courses courses);

    /**
     * 修改course
     * 
     * @param courses course
     * @return 结果
     */
    public int updateCourses(Courses courses);

    /**
     * 批量删除course
     * 
     * @param courseIds 需要删除的course主键集合
     * @return 结果
     */
    public int deleteCoursesByCourseIds(Long[] courseIds);

    /**
     * 删除course信息
     * 
     * @param courseId course主键
     * @return 结果
     */
    public int deleteCoursesByCourseId(Long courseId);
}
