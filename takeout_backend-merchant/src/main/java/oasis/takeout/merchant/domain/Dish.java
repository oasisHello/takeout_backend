package oasis.takeout.merchant.domain;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.takeout.common.annotation.Excel;
import oasis.takeout.common.core.domain.BaseEntity;

/**
 * merchant对象 tb_dish
 * 
 * @author oasis
 * @date 2024-12-17
 */
public class Dish extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Primary Key */
    private Long id;

    /** DishName */
    @Excel(name = "DishName")
    private String name;

    /** Price */
    @Excel(name = "Price")
    private BigDecimal price;

    /** Image */
    @Excel(name = "Image")
    private String image;

    /** Description */
    private String description;

    /** Status */
    @Excel(name = "Status")
    private Long status;

    /** flavor信息 */
    private List<DishFlavor> dishFlavorList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    public List<DishFlavor> getDishFlavorList()
    {
        return dishFlavorList;
    }

    public void setDishFlavorList(List<DishFlavor> dishFlavorList)
    {
        this.dishFlavorList = dishFlavorList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("price", getPrice())
            .append("image", getImage())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("dishFlavorList", getDishFlavorList())
            .toString();
    }
}
