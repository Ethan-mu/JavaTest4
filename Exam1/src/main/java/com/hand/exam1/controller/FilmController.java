package com.hand.exam1.controller;

import com.github.pagehelper.PageInfo;
import com.hand.exam1.common.Result;
import com.hand.exam1.entity.Film;
import com.hand.exam1.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class FilmController {
	@Autowired
	private FilmService filmService;

	private static final Logger logger = LoggerFactory.getLogger(FilmController.class);
	@RequestMapping(value = "/queryAll/{page}/{pageSize}",method = RequestMethod.GET)
	public Result<List<Film>> slectBetween(@PathVariable("pageSize") String pageSize ,@PathVariable("page") String page){
		Short a=Short.valueOf(page);
		Short b=Short.valueOf(pageSize);
		Map<String,Object> pageInfo=filmService.slectBetween(a, b);
		List<Film> filmList=(List<Film>) pageInfo.get("pageInfo");
		logger.info("==============="+filmList.toString());
		return new Result<List<Film>>(200, "success", filmList);
	}



}
