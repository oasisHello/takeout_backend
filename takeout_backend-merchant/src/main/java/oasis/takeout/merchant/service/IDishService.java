package oasis.takeout.merchant.service;

import java.util.List;
import oasis.takeout.merchant.domain.Dish;

/**
 * merchantService接口
 * 
 * @author oasis
 * @date 2024-12-17
 */
public interface IDishService 
{
    /**
     * 查询merchant
     * 
     * @param id merchant主键
     * @return merchant
     */
    public Dish selectDishById(Long id);

    /**
     * 查询merchant列表
     * 
     * @param dish merchant
     * @return merchant集合
     */
    public List<Dish> selectDishList(Dish dish);

    /**
     * 新增merchant
     * 
     * @param dish merchant
     * @return 结果
     */
    public int insertDish(Dish dish);

    /**
     * 修改merchant
     * 
     * @param dish merchant
     * @return 结果
     */
    public int updateDish(Dish dish);

    /**
     * 批量删除merchant
     * 
     * @param ids 需要删除的merchant主键集合
     * @return 结果
     */
    public int deleteDishByIds(Long[] ids);

    /**
     * 删除merchant信息
     * 
     * @param id merchant主键
     * @return 结果
     */
    public int deleteDishById(Long id);
}
