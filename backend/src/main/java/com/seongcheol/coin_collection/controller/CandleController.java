package com.seongcheol.coin_collection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seongcheol.coin_collection.dto.DayCandleDto;
import com.seongcheol.coin_collection.service.CandleService;

@RestController
@RequestMapping("/candle")
public class CandleController {
	
	@Autowired
	private CandleService candleService;
	
	@GetMapping("/day")
	public List<DayCandleDto> getDayCandleDtoList() {
		return candleService.getDayCandleDtoList();
	}
	
	@PostMapping("/day/update")
	public List<DayCandleDto> dayCandleUpdate() {
		return candleService.updateDayCandle();
	}

}
