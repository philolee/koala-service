package com.koala.mybatis.generated.dao;

import com.koala.mybatis.generated.model.FinanceProduct;
import com.koala.mybatis.generated.model.FinanceProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinanceProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    int countByExample(FinanceProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    int deleteByExample(FinanceProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    int insert(FinanceProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    int insertSelective(FinanceProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    List<FinanceProduct> selectByExample(FinanceProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    FinanceProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FinanceProduct record, @Param("example") FinanceProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FinanceProduct record, @Param("example") FinanceProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FinanceProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FinanceProduct record);
}