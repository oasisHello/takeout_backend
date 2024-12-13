package oasis.takeout.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oasis.takeout.common.annotation.Log;
import oasis.takeout.common.core.controller.BaseController;
import oasis.takeout.common.core.domain.AjaxResult;
import oasis.takeout.common.enums.BusinessType;
import oasis.takeout.system.domain.Courses;
import oasis.takeout.system.service.ICoursesService;
import oasis.takeout.common.utils.poi.ExcelUtil;
import oasis.takeout.common.core.page.TableDataInfo;

/**
 * courseController
 * 
 * @author ruoyi
 * @date 2024-12-04
 */
@RestController
@RequestMapping("/course/course")
public class CoursesController extends BaseController
{
    @Autowired
    private ICoursesService coursesService;

    /**
     * 查询course列表
     */
    @PreAuthorize("@ss.hasPermi('course:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(Courses courses)
    {
    	// Pagination
        startPage();
        List<Courses> list = coursesService.selectCoursesList(courses);
        return getDataTable(list);
    }

    /**
     * 导出course列表
     */
    @PreAuthorize("@ss.hasPermi('course:course:export')")
    @Log(title = "course", businessType = BusinessType.EXPORT) // user operation log
    @PostMapping("/export")
    public void export(HttpServletResponse response, Courses courses)
    {
        List<Courses> list = coursesService.selectCoursesList(courses);
        ExcelUtil<Courses> util = new ExcelUtil<Courses>(Courses.class);
        util.exportExcel(response, list, "course数据");
    }

    /**
     * 获取course详细信息
     */
    @PreAuthorize("@ss.hasPermi('course:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId)
    {
        return success(coursesService.selectCoursesByCourseId(courseId));
    }

    /**
     * 新增course
     */
    @PreAuthorize("@ss.hasPermi('course:course:add')")
    @Log(title = "course", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Courses courses)
    {
        return toAjax(coursesService.insertCourses(courses));
    }

    /**
     * 修改course
     */
    @PreAuthorize("@ss.hasPermi('course:course:edit')")
    @Log(title = "course", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Courses courses)
    {
        return toAjax(coursesService.updateCourses(courses));
    }

    /**
     * 删除course
     */
    @PreAuthorize("@ss.hasPermi('course:course:remove')")
    @Log(title = "course", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds)
    {
        return toAjax(coursesService.deleteCoursesByCourseIds(courseIds));
    }
}
