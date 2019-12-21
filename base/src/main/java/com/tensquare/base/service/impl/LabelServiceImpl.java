package com.tensquare.base.service.impl;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pogo.Label;
import com.tensquare.base.service.LabelService;
import com.tensquare.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LabelServiceImpl
 * @Author Administrator
 * @Date 2019/12/21 12:50
 * @Deacription 标签业务逻辑类
 **/

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    @Override
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    @Override
    public void add(Label label) {
        label.setId( idWorker.nextId()+"" );//设置ID
        labelDao.save(label);
    }


    @Override
    public void update(Label label){
        labelDao.save(label);
    }

    @Override
    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Specification<Label> createSpecification(Map searchMap){
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?>
                    criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList=new ArrayList<>();
                if(searchMap.get("labelname")!=null &&
                        !"".equals(searchMap.get("labelname"))){
                    predicateList.add(cb.like(
                            root.get("labelname").as(String.class), "%"+
                                    (String)searchMap.get("labelname")+"%"  ) );
                }
                if(searchMap.get("state")!=null &&
                        !"".equals(searchMap.get("state"))){
                    predicateList.add(cb.equal(
                            root.get("state").as(String.class), (String)searchMap.get("state") ) );
                }
                if(searchMap.get("recommend")!=null &&
                        !"".equals(searchMap.get("recommend"))){
                    predicateList.add(cb.equal(
                            root.get("recommend").as(String.class),
                            (String)searchMap.get("recommend") ) );
                }
                return cb.and( predicateList.toArray( new
                        Predicate[predicateList.size()]) );
            }
        };
    }

    @Override
    public List<Label> findSearch(Map searchMap){
        Specification specification= createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    @Override
    public Page<Label> findSearchPage(Map searchMap){
        Specification specification= createSpecification(searchMap);
        PageRequest pageRequest= PageRequest.of((Integer) searchMap.get("page")-1, (Integer) searchMap.get("size"));
        return labelDao.findAll(specification, pageRequest);
    }


}
