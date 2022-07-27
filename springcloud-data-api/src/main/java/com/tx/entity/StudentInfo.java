package com.tx.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author:TanXiao
 * @date:2022/7/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@ApiModel(value = "学生实例")
@Table(name = "t_student_info")
public class StudentInfo implements Serializable {
    @Id
    @ApiModelProperty(value = "学生ID")
    private String t_id;

    @ApiModelProperty(value = "学生编号")
   @Column(name = "stu_no")
    private String stu_no;

    @ApiModelProperty(value = "学生姓名")
    @Column(name = "stu_name")
    private String stu_name;

    @ApiModelProperty(value = "学生年龄")
    @Column(name = "stu_age")
    private Integer stu_age;

    @ApiModelProperty(value = "时间")
    @Column(name = "born_date")
    private String born_date;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_date")
    private String create_date;

}
