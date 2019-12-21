package com.tensquare.base.pogo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Label
 * @Author Administrator
 * @Date 2019/12/21 11:59
 * @Deacription TODO
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "tb_label")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Label {

    @Id
    private String id;//
    private String labelname;//标签名称
    private String state;//状态
    private Long count;//使用数量
    private Long fans;//关注数
    private String recommend;//是否推荐
}