package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="vehicles")
public interface CarRepository extends CrudRepository<Car, Long>{
	
	//브랜드로 자동차를 검색
	List<Car> findByBrand(@Param("brand")String brand);
	
	//색상으로 자동차 검색
	List<Car> findByColor(@Param("color")String color);
	
	// 연도로 자동차 검색
	List<Car> findByModelYear(int modelYear);

	//브랜드와 모델 자동차를 검색
	List<Car> findByBrandAndModel(String brand, String model);
	
	//브랜드 또는 색상별로 자동차 가져오기
	List<Car> findByBrandOrColor(String brand, String color);
	
	//브랜드로 자동차를 검색하고 연도로 정렬
	List<Car> findByBrandOrderByModelYearAsc(String brand);
	
	//SQL 문을 이용해 브랜드로 자동차를 검색
	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);
	
}
