package com.ttt.controller;

import com.ttt.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@Api(value = "/", description = "mybatis and spring")
@RequestMapping("/batis")
public class Demo {

    //    to get a mysql execute obiect
    @Autowired
    private SqlSessionTemplate template;

//    select
    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "qurice user count", httpMethod = "GET")
    public int getUserCount() {
        int getUserCount = template.selectOne("getUserCount");
        return getUserCount;
    }

//    insert
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    @ApiOperation(value = "insert user", httpMethod = "POST")
    public int insertUser(@RequestBody User user) {
        int addUser = template.insert("addUser",user);
        return addUser;
    }

//    updata
    @RequestMapping(value = "/updataUser", method = RequestMethod.POST)
    @ApiOperation(value = "insert user", httpMethod = "POST")
    public int updataUser(@RequestBody User user) {
        int updateUser = template.update("updateUser",user);
        return updateUser;
    }

//    delete
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    @ApiOperation(value = "insert user", httpMethod = "GET")
    public int deleteUser(@RequestParam int id) {
        int deleteUser = template.delete("deleteUser",id);
        return deleteUser;
    }
}
