package com.tang.system.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tang.commons.utils.AjaxResult;
import com.tang.system.entity.SysDept;
import com.tang.system.service.SysDeptService;

/**
 * 部门逻辑控制层
 *
 * @author Tang
 */
@RestController
@RequestMapping("/system/dept")
public class SysDeptController {

    private final SysDeptService deptService;

    public SysDeptController(SysDeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 获取部门列表
     *
     * @param dept 部门对象
     * @return 部门列表
     */
    @PreAuthorize("@auth.hasPermission('system:dept:list')")
    @GetMapping("/list")
    public AjaxResult list(SysDept dept){
        var list = deptService.selectDeptListTree(dept);
        return AjaxResult.success(list);
    }

    /**
     * 获取部门树下拉选项
     *
     * @param dept 部门对象
     * @return 部门树下拉选项
     */
    @PreAuthorize("@auth.hasPermission('system:dept:list')")
    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept){
        var list = deptService.selectDeptTree(dept);
        return AjaxResult.success(list);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param deptId 主键
     * @return 部门对象
     */
    @PreAuthorize("@auth.hasPermission('system:dept:list')")
    @GetMapping("/{deptId}")
    public AjaxResult selectDeptByDeptId(@PathVariable Long deptId) {
        return AjaxResult.success(deptService.selectDeptByDeptId(deptId));
    }

    /**
     * 新增部门
     *
     * @param dept 部门对象
     * @return 影响行数
     */
    @PreAuthorize("@auth.hasPermission('system:dept:add')")
    @PostMapping
    public AjaxResult add(@RequestBody SysDept dept) {
        return AjaxResult.rows(deptService.insertDept(dept));
    }

    /**
     * 修改部门信息
     *
     * @param dept 部门对象
     * @return 影响行数
     */
    @PreAuthorize("@auth.hasPermission('system:dept:edit')")
    @PutMapping
    public AjaxResult edit(@RequestBody SysDept dept) {
        return AjaxResult.rows(deptService.updateDeptByDeptId(dept));
    }

    /**
     * 修改部门状态
     *
     * @param dept 部门对象
     * @return 影响行数
     */
    @PreAuthorize("@auth.hasPermission('system:dept:edit')")
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysDept dept) {
        return AjaxResult.rows(deptService.updateDeptStatusByDeptId(dept));
    }

    /**
     * 通过主键删除数据
     *
     * @param deptId 主键
     * @return 影响行数
     */
    @PreAuthorize("@auth.hasPermission('system:dept:delete')")
    @DeleteMapping("/{deptId}")
    public AjaxResult delete(@PathVariable Long deptId) {
        if (deptService.checkHasChildren(deptId)) {
            return AjaxResult.error("删除失败，存在下级部门");
        }
        return AjaxResult.rows(deptService.deleteDeptByDeptId(deptId));
    }

}
