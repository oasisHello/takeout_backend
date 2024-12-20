package oasis.takeout.merchant.service.impl;

import java.util.List;
import oasis.takeout.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import oasis.takeout.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import oasis.takeout.merchant.domain.DishFlavor;
import oasis.takeout.merchant.mapper.DishMapper;
import oasis.takeout.merchant.domain.Dish;
import oasis.takeout.merchant.service.IDishService;

/**
 * merchantService业务层处理
 * 
 * @author oasis
 * @date 2024-12-17
 */
@Service
public class DishServiceImpl implements IDishService 
{
    @Autowired
    private DishMapper dishMapper;

    /**
     * 查询merchant
     * 
     * @param id merchant主键
     * @return merchant
     */
    @Override
    public Dish selectDishById(Long id)
    {
        return dishMapper.selectDishById(id);
    }

    /**
     * 查询merchant列表
     * 
     * @param dish merchant
     * @return merchant
     */
    @Override
    public List<Dish> selectDishList(Dish dish)
    {
        return dishMapper.selectDishList(dish);
    }

    /**
     * 新增merchant
     * 
     * @param dish merchant
     * @return 结果
     */
    @Transactional
    @Override
    public int insertDish(Dish dish)
    {
        dish.setCreateTime(DateUtils.getNowDate());
        int rows = dishMapper.insertDish(dish);
        insertDishFlavor(dish);
        return rows;
    }

    /**
     * 修改merchant
     * 
     * @param dish merchant
     * @return 结果
     */
    @Transactional
    @Override
    public int updateDish(Dish dish)
    {
        dish.setUpdateTime(DateUtils.getNowDate());
        dishMapper.deleteDishFlavorByDishId(dish.getId());
        insertDishFlavor(dish);
        return dishMapper.updateDish(dish);
    }

    /**
     * 批量删除merchant
     * 
     * @param ids 需要删除的merchant主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDishByIds(Long[] ids)
    {
        dishMapper.deleteDishFlavorByDishIds(ids);
        return dishMapper.deleteDishByIds(ids);
    }

    /**
     * 删除merchant信息
     * 
     * @param id merchant主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDishById(Long id)
    {
        dishMapper.deleteDishFlavorByDishId(id);
        return dishMapper.deleteDishById(id);
    }

    /**
     * 新增flavor信息
     * 
     * @param dish merchant对象
     */
    public void insertDishFlavor(Dish dish)
    {
        List<DishFlavor> dishFlavorList = dish.getDishFlavorList();
        Long id = dish.getId();
        if (StringUtils.isNotNull(dishFlavorList))
        {
            List<DishFlavor> list = new ArrayList<DishFlavor>();
            for (DishFlavor dishFlavor : dishFlavorList)
            {
                dishFlavor.setDishId(id);
                list.add(dishFlavor);
            }
            if (list.size() > 0)
            {
                dishMapper.batchDishFlavor(list);
            }
        }
    }
}
