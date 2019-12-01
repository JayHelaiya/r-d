package com.jay.easyshop.operationservices.operation.impl;

import org.springframework.stereotype.Service;

import com.jay.easyshop.commonservice.commondatabase.service.GenericServiceImpl;
import com.jay.easyshop.databaseservice.model.Student;
import com.jay.easyshop.operationservices.operation.StudentOperation;

@Service
public class StudentOperationImpl extends GenericServiceImpl<Student> implements StudentOperation{

}
