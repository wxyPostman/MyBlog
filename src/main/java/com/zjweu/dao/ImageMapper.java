package com.zjweu.dao;

import com.zjweu.entity.Image;
import com.zjweu.entity.ImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageMapper {
    long countByExample(ImageExample example);

    int deleteByExample(ImageExample example);

    int insert(Image record);

    int insertSelective(Image record);

    List<Image> selectByExampleWithBLOBs(ImageExample example);

    List<Image> selectByExample(ImageExample example);

    int updateByExampleSelective(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByExampleWithBLOBs(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByExample(@Param("record") Image record, @Param("example") ImageExample example);
}