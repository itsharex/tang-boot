package com.tang.generator.service;

import java.util.List;
import java.util.Map;

import com.tang.generator.entity.GenTable;

/**
 * 代码生成表 gen_table 表服务接口
 *
 * @author Tang
 */
public interface GenTableService {

    /**
     * 获取代码生成列表
     *
     * @param table 代码生成对象
     * @return 代码生成列表
     */
    List<GenTable> selectTableList(GenTable table);

    /**
     * 获取表列表
     *
     * @param table 代码生成对象
     * @return 表列表
     */
    List<GenTable> selectDatabaseTableList(GenTable table);

    /**
     * 根据主键查询单条数据
     *
     * @param tableId 主键
     * @return 代码生成对象
     */
    GenTable selectTableByTableId(Long tableId);

    /**
     * 新增代码生成
     *
     * @param table 代码生成对象
     * @return 影响行数
     */
    int insertTable(GenTable table);

    /**
     * 修改代码生成信息
     *
     * @param table 代码生成对象
     * @return 影响行数
     */
    int updateTableByTableId(GenTable table);

    /**
     * 通过主键删除数据
     *
     * @param tableId 主键
     * @return 影响行数
     */
    int deleteTableByTableId(Long tableId);

    /**
     * 通过表主键数组批量删除数据
     *
     * @param tableIds 表主键集合
     * @return 影响行数
     */
    int deleteTableByTableIds(Long[] tableIds);

    /**
     * 导入表信息
     *
     * @param tableNames 表名称集合
     * @return 影响行数
     */
    void importTable(String[] tableNames);

    /**
     * 代码预览
     *
     * @param tableId 主键
     * @return 数据
     */
    Map<String, String> previewCode(Long tableId);

    /**
     * 批量代码下载
     *
     * @param tableNames 表名称集合
     * @return 数据
     */
    byte[] downloadCodes(String[] tableNames);

    /**
     * 执行 SQL
     *
     * @param tableNames 表名称集合
     * @return 结果
     */
    int executes(String[] tableNames);

    /**
     * 同步表数据
     *
     * @param tableNames 表名称集合
     */
    int syncs(String[] tableNames);

}
