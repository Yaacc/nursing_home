package cn.ndky.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class employee {
    private Integer id;             //序号
    private String employeeNumber;  //员工编号
    private String username;        //用户名
    @JsonIgnore
    private String password;        //密码
    private String realName;        //真实姓名
    private String sex;             //性别
    private Integer age;            //年龄
    private String phone;           //联系电话
    private String IDCard;          //身份证号
}
