package com.smc.repository;

import com.smc.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @author BoZhang
 * E-mail:dlzbo@cn.ibm.com
 * @version date：May 12, 2020 7:53:06 PM
*/
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

	@Query(name = "getCompanyNameByCode", nativeQuery = true,
			value = "SELECT companyname from company where companycode = :companyCode")
	String getCompanyNameByCode(String companyCode);

	CompanyEntity findByCompanyCode(String companyCode);

	@Query(name = "findByName", nativeQuery = true,
			value = "SELECT * from company  where companyname = :companyName")
	CompanyEntity findByName(String companyName);

	List<CompanyEntity> findAllBySectorName(String sector);

}

