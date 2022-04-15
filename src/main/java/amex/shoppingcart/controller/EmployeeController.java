package amex.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import amex.shoppingcart.model.Employee;

@RestController
public class EmployeeController {

	
	
	private static List<Employee> empList = new ArrayList<>();
	
	@GetMapping("/showAllEmploys")
	public List<Employee> getAllEmployees(){
		
		return empList;
		
	}	
	
	@PostMapping("/addEmployee")
	
	public String addEmpDetails(@RequestBody Employee employee) {		
		
		empList.add(employee);
		return "Employee Recorded Successfully...";
		
	}
	
	@GetMapping("/searchEmployee/{empid}")
	
	public ResponseEntity<?> searchEmp(@PathVariable("empid") int empid){
		
		
		for (Employee employee : empList) {
			
			if(employee.getEmployeeID() == empid) {
				return ResponseEntity.ok(employee);
			}
		}
		
		return ResponseEntity.ok("No Record Found with  Empolyee ID: " + empid) ;
		
	}
	
	@DeleteMapping("/deleteEmployee/{empid}")
	
	public String deleteEmployee(@PathVariable("empid") int empid) {
		
		for (Employee employee : empList) {
			
			if(employee.getEmployeeID() == empid) {
				empList.remove(employee);
				return "Employee Record Deleted Successfully";
			}
		}
		
		return ("No Record Found with  Empolyee ID: " + empid) ;
	}
	
	@PutMapping("/updateEmploy")	
	public String updateEmployee(@RequestBody Employee emp) {
		
		for (Employee employee : empList) {
			
			if(employee.getEmployeeID() == emp.getEmployeeID()) {
			
				employee.setEmployeeName(emp.getEmployeeName());
				employee.setEmployeeContact(emp.getEmployeeContact());
				
				return "Employee Record Updated Successfully";
			}
		}
		
		return ("No Record Found with  Empolyee ID: " + emp.getEmployeeID()) ;
	}
	
	
	
}
