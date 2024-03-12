package com.application.jpa.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*

# ModelMapper
 
- ModelMapper는 객체 간의 매핑을 간소화하기 위한 라이브러리이다. 
- ModelMapper는 반복적인 매핑 코드를 줄여주어 주로 데이터 전송 객체(DTO)와 도메인 모델 사이의 데이터 변환에 사용된다. 
- build.gradle파일에 의존성을 추가하여 ModelMapper 라이브러리를 사용한다.

	//modelMapper
	implementation 'org.modelmapper:modelmapper:2.4.4'
  
  [ 주요 메서드 ]

	map(Object source, Class<D> destinationType)
   위 함수는 source 객체의 데이터를 destinationType 클래스의 새 인스턴스로 매핑한다.

*/

@Configuration
public class ModelMapperConfig {
	
	//메퍼객체 생성
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
