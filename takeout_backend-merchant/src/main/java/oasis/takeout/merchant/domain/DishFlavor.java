package oasis.takeout.merchant.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.takeout.common.annotation.Excel;
import oasis.takeout.common.core.domain.BaseEntity;

/**
 * flavor对象 tb_dish_flavor
 * 
 * @author oasis
 * @date 2024-12-17
 */
public class DishFlavor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dishId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String value;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDishId(Long dishId) 
    {
        this.dishId = dishId;
    }

    public Long getDishId() 
    {
        return dishId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dishId", getDishId())
            .append("name", getName())
            .append("value", getValue())
            .toString();
    }
}
