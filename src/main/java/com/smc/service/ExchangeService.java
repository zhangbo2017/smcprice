package com.smc.service;

import com.smc.entity.StockExchangeEntity;
import com.smc.repository.ExchangeRepository;
import com.smc.utils.CommonResult;
import com.smc.utils.ResponseCode;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BoZhang
 * E-mail:dlzbo@cn.ibm.com
 * @version date：May 12, 2020 7:53:39 PM
*/
@Service
public class ExchangeService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExchangeRepository exchangeRepository;


	// public CommonResult findAll() {
	// 	try {
	// 		List<StockExchangeEntity> exchange = exchangeRepository.findAll();
	// 		return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", exchange);
	// 	} catch (Exception e) {
	// 		logger.error("Fail to query exchange data:", e);
	// 		return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
	// 	}
	// }


	public CommonResult findByExchange(String exchange) {
		try {
			StockExchangeEntity stockExchange = exchangeRepository.findByExchange(exchange);
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", stockExchange);
		} catch (Exception e) {
			logger.error("Fail to query exchange data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}


	public CommonResult findById(int id) {
		try {
			StockExchangeEntity stockExchange = exchangeRepository.findById(id).get();
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", stockExchange);
		} catch (Exception e) {
			logger.error("Fail to query exchange data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

}
