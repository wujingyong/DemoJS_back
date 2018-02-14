package com.wjy.test

import java.time.format.DateTimeFormatter
import java.time.{LocalDate, LocalDateTime, ZoneId}

import com.alibaba.fastjson.JSON
import com.github.pagehelper.{PageHelper, PageInfo}
import com.github.pagehelper.page.PageMethod
import com.wjy.model.Emp
import io.swagger.annotations.ApiParam
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._

@Controller
@ResponseBody
@RequestMapping(Array("test"))
class testDemo @Autowired()(val testService: TestService){


  @GetMapping(Array("gg"))
  def test2() = {
    testService.testService("aabbccddee")
  }

  @GetMapping(Array("getAll"))
  def getAll(
              @ApiParam(name = "pageNo", value = "页码数", required = true) @RequestParam("pageNo") pageNo : Integer,
              @ApiParam(name = "pageSize", value = "每页数量", required = true) @RequestParam("pageSize") pageSize : Int
            ) = {
    PageMethod.startPage(pageNo,pageSize)
    new PageInfo[Emp](testService.getEmpAll(), 5)
  }

  @PostMapping(Array("setEmp"))
  def setEmp(@ApiParam(name = "emp", value = "json格式") @RequestBody emp: Emp) = {

    println(emp)
    println(emp.getCreateTime.toInstant.atZone(ZoneId.systemDefault()).getMonthValue)

    val empJSON = JSON.toJSON(emp)
    println(empJSON)
    val empStr = empJSON.toString
    println(empStr)
    val emp2 = JSON.parseObject(empStr,classOf[Emp])
    println(emp2)
    emp
  }
}