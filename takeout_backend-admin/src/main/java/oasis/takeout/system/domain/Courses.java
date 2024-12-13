package oasis.takeout.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.takeout.common.annotation.Excel;
import oasis.takeout.common.core.domain.BaseEntity;

/**
 * course对象 courses
 * 
 * @author ruoyi
 * @date 2024-12-04
 */
public class Courses extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long courseId;

    /** name */
    @Excel(name = "name")
    private String courseName;

    /** code */
    @Excel(name = "code")
    private String courseCode;

    /** description */
    @Excel(name = "description")
    private String description;

    /** instructor */
    @Excel(name = "instructor")
    private String instructor;

    /** startdate */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "startdate", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** enddate */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "enddate", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** credits */
    @Excel(name = "credits")
    private Long credits;

    /** department */
    @Excel(name = "department")
    private String department;

    /** created_at */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "created_at", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setCourseCode(String courseCode) 
    {
        this.courseCode = courseCode;
    }

    public String getCourseCode() 
    {
        return courseCode;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setInstructor(String instructor) 
    {
        this.instructor = instructor;
    }

    public String getInstructor() 
    {
        return instructor;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setCredits(Long credits) 
    {
        this.credits = credits;
    }

    public Long getCredits() 
    {
        return credits;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("courseName", getCourseName())
            .append("courseCode", getCourseCode())
            .append("description", getDescription())
            .append("instructor", getInstructor())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("credits", getCredits())
            .append("department", getDepartment())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
