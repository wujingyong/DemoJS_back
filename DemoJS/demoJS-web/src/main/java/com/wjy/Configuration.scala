package com.wjy

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.web.servlet.config.annotation.{ResourceHandlerRegistry, WebMvcConfigurerAdapter}
import springfox.documentation.builders.{ApiInfoBuilder, PathSelectors}
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@SpringBootApplication
class DemoJSConfiguration

object JWSConfiguration extends App{
  SpringApplication.run(classOf[DemoJSConfiguration])
}

@Configuration
@EnableSwagger2
class SwaggerConfig extends WebMvcConfigurerAdapter {

  def createRestApi() = {
    new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .select()
      //?默认会扫描所有的SpringMvc的controller
      //          .apis(RequestHandlerSelectors.withMethodAnnotation(Class[ApiOperation])) //这里采用包含注解的方式来确定要显示的接口
//                      .apis(RequestHandlerSelectors.basePackage("com.wjy.test"))    //这里采用包扫描的方式来确定要显示的接口
      .paths(PathSelectors.any())
      .build();
  }

  def apiInfo() = {
    new ApiInfoBuilder()
      .title("Api Doc")
      .description("Api文档")
      .version("2.0")
      .build();
  }

//  override def addResourceHandlers(registry : ResourceHandlerRegistry ) {
//    registry.addResourceHandler("swagger-ui.htm")
//      .addResourceLocations("classpath*:/META-INF/resources/");
//    registry.addResourceHandler("/webjars/**")
//      .addResourceLocations("classpath*:/META-INF/resources/webjars/");
//  }
}