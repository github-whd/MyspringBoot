package com.whd.mapper;

import com.whd.model.Image;

public interface ImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image
     *
     * @mbg.generated Sun Nov 04 12:22:11 CST 2018
     */
    int insert(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image
     *
     * @mbg.generated Sun Nov 04 12:22:11 CST 2018
     */
    int insertSelective(Image record);
    Image select(String id);
}