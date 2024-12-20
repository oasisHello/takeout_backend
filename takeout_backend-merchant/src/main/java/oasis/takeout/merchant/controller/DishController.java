package oasis.takeout.merchant.controller;

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
import oasis.takeout.merchant.domain.Dish;
import oasis.takeout.merchant.service.IDishService;
import oasis.takeout.common.utils.poi.ExcelUtil;
import oasis.takeout.common.core.page.TableDataInfo;

/**
 * merchantController
 * 
 * @author oasis
 * @date 2024-12-17
 */
@RestController
@RequestMapping("/merchant/dish")
public class DishController extends BaseController
{
    @Autowired
    private IDishService dishService;

    /**
     * 查询merchant列表
     */
    @PreAuthorize("@ss.hasPermi('merchant:dish:list')")
    @GetMapping("/list")
    public TableDataInfo list(Dish dish)
    {
        startPage();
        List<Dish> list = dishService.selectDishList(dish);
        return getDataTable(list);
    }

    /**
     * 导出merchant列表
     */
    @PreAuthorize("@ss.hasPermi('merchant:dish:export')")
    @Log(title = "merchant", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Dish dish)
    {
        List<Dish> list = dishService.selectDishList(dish);
        ExcelUtil<Dish> util = new ExcelUtil<Dish>(Dish.class);
        util.exportExcel(response, list, "merchant数据");
    }

    /**
     * 获取merchant详细信息
     */
    @PreAuthorize("@ss.hasPermi('merchant:dish:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dishService.selectDishById(id));
    }

    /**
     * 新增merchant
     */
    @PreAuthorize("@ss.hasPermi('merchant:dish:add')")
    @Log(title = "merchant", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Dish dish)
    {
        return toAjax(dishService.insertDish(dish));
    }

    /**
     * 修改merchant
     */
    @PreAuthorize("@ss.hasPermi('merchant:dish:edit')")
    @Log(title = "merchant", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Dish dish)
    {
        return toAjax(dishService.updateDish(dish));
    }

    /**
     * 删除merchant
     */
    @PreAuthorize("@ss.hasPermi('merchant:dish:remove')")
    @Log(title = "merchant", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dishService.deleteDishByIds(ids));
    }
}
