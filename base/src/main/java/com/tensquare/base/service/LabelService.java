package com.tensquare.base.service;

import com.tensquare.base.pogo.Label;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName LabelService
 * @Author Administrator
 * @Date 2019/12/21 12:49
 * @Deacription 标签业务逻辑类
 **/

public interface LabelService {

    /**
     * 查询全部标签
     * @return
     */
    List<Label> findAll();

    /**
     * 根据ID查询标签
     * @return
     */
    Label findById(String id);

    /**
     * 增加标签
     * @param label
     */
    void add(Label label);

    /**
     * 修改标签
     * @param label
     */
    void update(Label label);

    /**
     * 删除标签
     * @param id
     */
    void deleteById(String id);

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    public List<Label> findSearch(Map searchMap);

    /**
     * 分页条件查询
     * @param searchMap
     * @return
     */
    public Page<Label> findSearchPage(Map searchMap);
}

