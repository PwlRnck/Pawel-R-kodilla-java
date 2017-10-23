package com.kodilla.patterns2.facade.employees.api;

import com.kodilla.patterns2.facade.employees.Company;
import com.kodilla.patterns2.facade.employees.Employee;
import com.kodilla.patterns2.facade.employees.dao.CompanyDao;
import com.kodilla.patterns2.facade.employees.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchTool {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> searchCompany(String text) {
        List<Company> result = companyDao.searchCompanyByTextString("%" + text + "%");
        return result;
    }

    public List<Employee> searchEmployee(String text) {
        List<Employee> result = employeeDao.searchEmployeeByTextString("%" + text + "%");
        return result;
    }

}
