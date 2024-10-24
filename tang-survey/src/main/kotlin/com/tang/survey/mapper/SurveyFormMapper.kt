package com.tang.survey.mapper

import org.apache.ibatis.annotations.Mapper

import com.tang.survey.entity.SurveyForm

/**
 * 调查问卷数据访问层
 *
 * @author Tang
 */
@Mapper
interface SurveyFormMapper {

    /**
     * 查询调查问卷列表
     *
     * @param surveyForm 调查问卷对象
     * @return 调查问卷列表
     */
    fun selectSurveyFormList(surveyForm: SurveyForm): List<SurveyForm>

    /**
     * 通过调查问卷主键查询调查问卷信息
     *
     * @param formId 调查问卷主键
     * @return 调查问卷信息
     */
    fun selectSurveyFormByFormId(formId: Long): SurveyForm

    /**
     * 新增调查问卷信息
     *
     * @param surveyForm 调查问卷信息
     * @return 影响行数
     */
    fun insertSurveyForm(surveyForm: SurveyForm): Int

    /**
     * 通过调查问卷主键修改调查问卷信息
     *
     * @param surveyForm 调查问卷信息
     * @return 影响行数
     */
    fun updateSurveyFormByFormId(surveyForm: SurveyForm): Int

    /**
     * 通过调查问卷主键删除调查问卷信息
     *
     * @param formId 调查问卷主键
     * @return 影响行数
     */
    fun deleteSurveyFormByFormId(formId: Long): Int

    /**
     * 通过调查问卷主键数组批量删除调查问卷信息
     *
     * @param formIds 调查问卷主键数组
     * @return 影响行数
     */
    fun deleteSurveyFormByFormIds(formIds: Array<Long>): Int

}
