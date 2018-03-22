package com.guardian.app.dao;

import java.util.List;

import com.guardian.app.domain.entity.Department;

public interface DepartmentDao {
	Department findById(int id);
	Department save(Department department);
	List<Department> findAll();
}
