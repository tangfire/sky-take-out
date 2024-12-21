package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id批量删除口味
     * @param dishIds
     */
    void deleteBatchByIds(List<Long> dishIds);
}
