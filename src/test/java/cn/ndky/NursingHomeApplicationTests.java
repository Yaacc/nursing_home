package cn.ndky;

import cn.ndky.entity.Employee;
import cn.ndky.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NursingHomeApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;
    /**
     * mybatis-plus快速测试
      */
    @Test
    public void testSelect(){
        System.out.println("selectAll test");
        List<Employee> employeeList = employeeMapper.selectList(null);
        Assert.isTrue(5 == employeeList.size(), "");
        employeeList.forEach(System.out::println);
    }

    /**
     * 手写mybatis
     */
    @Test
    public void find(){
        List<Employee> employeeList=employeeMapper.findAll();
        System.out.println(employeeList);
    }
    @Test
    void contextLoads() {
    }

}
