package com.hand.exam1.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hand.exam1.common.ParamModel;
import com.hand.exam1.common.Result;
import com.hand.exam1.entity.Film;
import com.hand.exam1.service.FilmService;
import com.hand.exam1.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/queryPage")
	public Result queryPage(@ParamModel Page page) {

		Short a=(short)page.getPage();
		Short b=(short)page.getPageSize();

		Map<String,Object> pageInfo=filmService.slectBetween(a,b);
		List<Film> filmList=(List<Film>) pageInfo.get("pageInfo");
		logger.info("==============="+filmList.toString());
		return new Result<List<Film>>(200, "success", filmList);


	}
	@RequestMapping(value = "/addFilm",method = RequestMethod.PUT)
	public Result addFilm(@RequestBody Film f){
		Film film=new Film();
		film.setDescription(f.getDescription());
		film.setLanguageId(Byte.valueOf(f.getLanguageId()));
		film.setTitle(f.getTitle());
		boolean b=filmService.insert(film);
		if (b){
			return new Result(200, "插入成功",b);
		}
		return new Result(200, "插入失败",b);
	}


}
