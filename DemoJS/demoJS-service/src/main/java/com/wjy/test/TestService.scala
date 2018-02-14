package com.wjy.test

import com.github.pagehelper.PageHelper
import com.wjy.dao.EmpMapper
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestService @Autowired()(empMapper : EmpMapper){
    def testService(str : String) = {
      str;
    }

    def getEmpAll() = {
        empMapper.selectAll()
    }
}
