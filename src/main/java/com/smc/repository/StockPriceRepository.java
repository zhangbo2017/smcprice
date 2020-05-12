package com.smc.repository;

import com.smc.entity.StockPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @author BoZhang
 * E-mail:dlzbo@cn.ibm.com
 * @version date：May 12, 2020 7:53:21 PM
*/
public interface StockPriceRepository extends JpaRepository<StockPriceEntity, Long> {
    List<StockPriceEntity> findByCompanyCodeAndDateTimeBetween(String code, LocalDateTime start, LocalDateTime end);

    StockPriceEntity findFirstByCompanyCodeOrderByDateTimeDesc(String code);

    List<StockPriceEntity> findAllByCompanyCodeInAndDateTimeBetween(List<String> code, LocalDateTime start, LocalDateTime end);



}

