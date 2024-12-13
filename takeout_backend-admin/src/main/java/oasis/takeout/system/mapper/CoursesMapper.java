package oasis.takeout.system.mapper;

import java.util.List;
import oasis.takeout.system.domain.Courses;

/**
 * courseMapper接口
 * 
 * @author ruoyi
 * @date 2024-12-04
 */
public interface CoursesMapper 
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
     * 删除course
     * 
     * @param courseId course主键
     * @return 结果
     */
    public int deleteCoursesByCourseId(Long courseId);

    /**
     * 批量删除course
     * 
     * @param courseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCoursesByCourseIds(Long[] courseIds);
}
