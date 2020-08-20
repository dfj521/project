package com.dfj.dao;

import com.dfj.entity.Emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    /**
     * 查询所有信息
     * @return
     */
    List<Emp> findAll();

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    Emp findById(Integer id);

    /**
     * 根据name查询信息
     * @param name
     * @return
     */
    List<Emp> findByName(String name);

    /**
     * 添加一条信息
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据条件查询信息
     * @param emp
     * @return
     */
    List<Emp> findByCondition(Emp emp);

    /**
     * 根据id删除信息
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据id更新信息
     * @param emp
     */
    void updateById(Emp emp);

    List<Emp> findByIds(List<Integer> ids);

    /**
     * 根据name和age查询信息
     * @param name
     * @param age
     * @return
     */
    Emp findByNameAndAge(String name, Integer age);

    /**
     * 根据性别查询员工信息，返回值类型是map
     * @param gender
     * @return
     */
    List<Map<String, Object>> findByGender(String gender);
}
