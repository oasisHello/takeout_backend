package oasis.takeout.merchant.mapper;

import java.util.List;
import oasis.takeout.merchant.domain.Dish;
import oasis.takeout.merchant.domain.DishFlavor;

/**
 * merchantMapper接口
 * 
 * @author oasis
 * @date 2024-12-17
 */
public interface DishMapper 
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
     * 删除merchant
     * 
     * @param id merchant主键
     * @return 结果
     */
    public int deleteDishById(Long id);

    /**
     * 批量删除merchant
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDishByIds(Long[] ids);

    /**
     * 批量删除flavor
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDishFlavorByDishIds(Long[] ids);
    
    /**
     * 批量新增flavor
     * 
     * @param dishFlavorList flavor列表
     * @return 结果
     */
    public int batchDishFlavor(List<DishFlavor> dishFlavorList);
    

    /**
     * 通过merchant主键删除flavor信息
     * 
     * @param id merchantID
     * @return 结果
     */
    public int deleteDishFlavorByDishId(Long id);
}
