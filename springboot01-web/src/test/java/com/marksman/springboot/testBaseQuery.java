package com.marksman.springboot;

import com.marksman.springboot.domain.entity.User;
import com.marksman.springboot.domain.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author weilb
 * @date 2018/8/23
 * @description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class testBaseQuery {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll(){
        List<User> list = userRepository.findAll();
        for (User u : list) {
            System.out.println(u.getUserName()+"###"+u.getNickName());
        }
    }

    @Test
    public void testSave(){
        User user  = new User();
        user.setUserName("pp");
        user.setPassWord("123456");
        user.setNickName("p");
        user.setEmail("ppp@123.com");
        user.setRegTime(new Date()+"");
        User user1 = userRepository.save(user);
        Assert.assertEquals(user1.getUserName(),user.getUserName());
    }

    @Test
    public void testFindByUserName() {
        User user = userRepository.findByUserName("pp");
        System.out.println(user.getEmail());
    }

    @Test
    public void testFindByUserNameOrEmail() {
        System.out.println(userRepository.findByUserNameOrEmail("cc","cc@126.com"));
    }

    @Test
    public void testFindByEmailLike(){
        List<User> list = userRepository.findByEmailLike("%@126.com%");
        System.out.println("#####"+list.size());
    }
    
    /**
      * @description page:第几页开始显示（下标从0开始）  size:每页显示多少行
      * @params []
      * @return void
      * @author weilb
      * @date 2018/8/23
      */
    @Test
    public void testPageQuery(){
        int page = 2,size = 3;
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(page,size,sort);
        Page<User> userPage = userRepository.findAll(pageable);
        System.out.println(userPage.getTotalElements()+"------"+userPage.getTotalPages());
        for (User user : userPage) {
            System.out.println(user.getId()+"---"+user.getUserName()+"---"+user.getNickName()+"---"+user.getEmail());
        }
    }

    @Test
    public void testFindTop2ByuserName(){
        Pageable pageable = new PageRequest(0,5,new Sort(Sort.Direction.ASC,"id"));
        List<User> list = userRepository.findTop2ByPassWord("123456",pageable);
        for (User user : list) {
            System.out.println(user.getId()+"---"+user.getUserName()+"---"+user.getNickName()+"---"+user.getEmail());
        }
    }

    @Test
    public void testModifyByIdAndUserName(){
        int mount = userRepository.modifyByIdAndUserName("marksman",12L);
        System.out.println("修改的数量: "+mount);
        Assert.assertEquals(1,mount);
    }

    @Test
    public void testDeleteById(){
        userRepository.deleteById(13L);
    }

    @Test
    public void testFindByEmail(){
        List<User> list = userRepository.findByEmail("hh@126.com");
        Assert.assertEquals(1,list.size());
    }
}
