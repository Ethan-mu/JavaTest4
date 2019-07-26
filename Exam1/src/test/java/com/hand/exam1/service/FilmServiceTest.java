package com.hand.exam1.service;

import com.github.pagehelper.PageInfo;
import com.hand.exam1.Exam1ApplicationTests;
import com.hand.exam1.entity.Film;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class FilmServiceTest extends Exam1ApplicationTests {

	@Autowired
	FilmService filmService;
	@Test
	public void selectOne() {
		short a=1;
		Film film=filmService.selectOne(a);
		System.out.println("------------------------------");
		System.out.println(film.getDescription());
		Assert.assertTrue(film!=null);
	}

	@Test
	public void slectBetween() {

		short a=1;
		short b=100;

//		PageInfo film=filmService.slectBetween(a,b);
		System.out.println("------------------------------");
//		for (Film f:film
//			 ) {
//			System.out.println(f.toString());
//		}
//		System.out.println(film.size());
	}
}