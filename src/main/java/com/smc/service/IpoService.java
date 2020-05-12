package com.smc.service;

import com.smc.entity.IPODetailEntity;
import com.smc.repository.IpoRepository;
import com.smc.utils.CommonResult;
import com.smc.utils.ResponseCode;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * @author BoZhang
 * E-mail:dlzbo@cn.ibm.com
 * @version date：May 12, 2020 7:53:47 PM
*/
@Service
public class IpoService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private IpoRepository ipoRepository;


	public CommonResult findAll() {
		try {
			List<IPODetailEntity> ipos = ipoRepository.findAll();
			for (IPODetailEntity ipo : ipos) {
				ipo.setOpenDateTime(df.format(df.parse(ipo.getOpenDateTime())));
			}
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", ipos);
		} catch (Exception e) {
			logger.error("Fail to query ipoDetails data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}


	public CommonResult findIPOByExchange(String exchange) {
		try {
			IPODetailEntity ipoDetail = ipoRepository.findIPOByExchange(exchange);
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", ipoDetail);
		} catch (Exception e) {
			logger.error("Fail to query ipoDetail data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}


	public CommonResult findIPOByCompanyName(String companyName) {
		try {
			IPODetailEntity ipoDetail = ipoRepository.findIPOByCompanyName(companyName);
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", ipoDetail);
		} catch (Exception e) {
			logger.error("Fail to query ipoDetail data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

	public CommonResult findById(int id) {
		try {
			IPODetailEntity ipo = ipoRepository.findById(id).get();
			ipo.setOpenDateTime(df.format(df.parse(ipo.getOpenDateTime())));
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", ipo);
		} catch (Exception e) {
			logger.error("Fail to query ipoDetails data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

}
