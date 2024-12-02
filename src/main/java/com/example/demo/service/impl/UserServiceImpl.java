package com.example.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private ModelMapper modelMapper;

}
