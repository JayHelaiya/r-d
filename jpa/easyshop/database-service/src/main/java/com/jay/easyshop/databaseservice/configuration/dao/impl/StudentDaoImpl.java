package com.jay.easyshop.databaseservice.configuration.dao.impl;

import org.springframework.stereotype.Repository;

import com.jay.easyshop.commonservice.commondatabase.dao.GenericDaoImpl;
import com.jay.easyshop.databaseservice.configuration.dao.StudentDao;
import com.jay.easyshop.databaseservice.model.Student;


@Repository
public class StudentDaoImpl extends GenericDaoImpl<Student> implements StudentDao {

}
