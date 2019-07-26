package com.hand.exam1.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.exam1.entity.Film;
import com.hand.exam1.entity.FilmExample;
import com.hand.exam1.mapper.FilmMapper;
import com.hand.exam1.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmMapper filmMapper;
	@Override
	public Film selectOne(short id) {
		return filmMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Film> selectAll() {

		return null;
	}

	@Override
	public Map<String,Object> slectBetween(short a, short b) {
		int pageNum =1;
		int pageSize=5;
		PageHelper.startPage(pageNum,pageSize);
		FilmExample example = new FilmExample();
		example.setOrderByClause("title desc");
		FilmExample.Criteria criteria = example.createCriteria();
		criteria.andFilmIdBetween(a,b);
		List<Film> filmList=filmMapper.selectByExample(example);

		PageInfo<Film> pageResult = new PageInfo<>(filmList);
		Map<String, Object> map = new HashMap<>();
		List<Film> filmList1=pageResult.getList();
		map.put("pageInfo",filmList1);
		return map;
	}

	@Override
	public boolean insert(Film film) {
		Integer i=filmMapper.insertSelective(film);
		if(i>0){
			return true;
		}
		return false;
	}
}
