package com.application.jpa.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
/*

- JPA 주요 어노테이션

@Entity : 클래스가 JPA 엔티티임을 나타낸다. 클래스 이름이 DB 테이블 이름에 매핑된다.
@Table  : 엔티티 클래스가 매핑될 테이블의 정보를 명시한다. (name, catalog, schema 등의 속성을 가질 수 있음)
@Id		: 엔티티의 기본 키(Primary Key)를 나타낸다.
@GeneratedValue : 기본 키의 값을 자동으로 생성할 전략을 명시한다. (AUTO, IDENTITY, SEQUENCE, TABLE 중 선택)
@Column : 필드가 매핑될 테이블의 컬럼을 명시한다. (name, nullable, length 등의 속성을 가질 수 있음)
@ManyToOne, @OneToMany, @OneToOne, @ManyToMany : 엔티티 간의 관계를 명시한다. (@JoinColumn과 함께 사용되는 경우가 많음)
@JoinColumn : 외래 키(Foreign Key)를 매핑할 때 사용한다. (name, referencedColumnName 등의 속성을 가질 수 있음)
@Transient : 필드가 영속성 컨텍스트에 저장되거나 검색되지 않음을 나타다.
@Temporal : 날짜 타입(java.util.Date, java.util.Calendar)의 매핑을 명시한다. (TemporalType.DATE, TemporalType.TIME, TemporalType.TIMESTAMP 중 선택)

*/

@Data 
@Entity//(순서는 상관없음)
public class Brand {
	@Id //import jakarta.persistence.Id; 자바의 연속성 primaryKey 어노테이션으로!
	private Long brandId;//래퍼클래스로 명시한다.
	private String brandNm;
	private Date enteredDt;
	private String activeYn;
}
