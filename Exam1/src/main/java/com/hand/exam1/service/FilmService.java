package com.hand.exam1.service;


import com.github.pagehelper.PageInfo;
import com.hand.exam1.entity.Film;

import java.util.List;
import java.util.Map;

public interface FilmService {
	Film selectOne(short id);
	List<Film> selectAll();
	public Map<String,Object> slectBetween(short a, short b);
	boolean insert(Film film);
}
