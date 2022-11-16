package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	@Autowired
	CustomerRepo repo;

	@RequestMapping("/")
	public String details() {
		return "customers";
	}

	@RequestMapping("/details")
	public String details(Customers customers) {
		repo.save(customers);
		return "customers";
	}

	@RequestMapping("/getDetails")
	public String getDetails() {
		return "ViewCustomer";
	}

	@PostMapping("/getDetails")
	public ModelAndView getDetails(@RequestParam int cId) {
		ModelAndView mv = new ModelAndView("Retrieve");
		Customers customers = repo.findById(cId).orElse(null);
		mv.addObject(customers);
		return mv;
	}

	@RequestMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomers() {
		return repo.findAll();
	}

	@RequestMapping("/customers/{cId}")
	@ResponseBody
	public Optional<Customers> getCustomers2(@PathVariable("cId") int cId) {
		return repo.findById(cId);
	}
	
	@PostMapping("/customers")
	public Customers getCustomers3(@RequestBody Customers customers) {
		repo.save(customers);
		return customers;
	}
	
	@DeleteMapping("/customers/{cId}")
	public Customers getCustomers4(@PathVariable("cId") int cId) {
		Customers cust = repo.getReferenceById(cId);
		repo.delete(cust);
		return cust;
	}
	
	@PutMapping(path="/customers",consumes= {"application/json"})
	public Customers getCustomers5(@RequestBody Customers customers) {
		repo.save(customers);
		return customers;
	}

//	@PostMapping("/details")
//	public String viewDetails(@RequestParam("cId") String cId, @RequestParam("cName") String cName,
//			@RequestParam("cEmail") String cEmail, ModelMap modelMap) {
//		modelMap.put("cId", cId);
//		modelMap.put("cName", cName);
//		modelMap.put("cEmail", cEmail);
//		return "ViewCustomer";
//	}

}
