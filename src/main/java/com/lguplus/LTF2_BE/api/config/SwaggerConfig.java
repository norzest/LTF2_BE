package com.lguplus.LTF2_BE.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Docket : Swagger 설정의 핵심으로 문서화 객체
     * useDefultResponseMessages : 응답코드에 대한 기본 메세지 사용 여부
     * select : ApiSelectorBuilder를 생성
     * apis : 컨트롤러가 존재하는 패키지를 basePackage로 지정
     * paths : path 조건에 해당하는 API를 찾아 문서화
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lguplus.LTF2_BE.api.controller"))
                .paths(PathSelectors.ant("/**"))
                .build();
    }
}
