/* 
 * Author ::. Sivateja Kandula | www.java4s.com 
 *
 */

package com.java4s.app.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java4s.app.repository.SpringJava4sDAO;
import com.java4s.model.location;

@RestController
public class SpringJava4sController {
	
	@Autowired
	public SpringJava4sDAO dao;
	

	@RequestMapping("/getcustLocation")
	public List<location> customerLocation() {
		
		List<location> customers = dao.isData();		 
		
		return customers;
	}
	
	@PostMapping("/saveLocation")
	public JSONObject saveLocation(@RequestBody location location) {	
		System.out.println("loca details ........"+location.getCreatedTime()+" user id is ==="+location.getUserId());
		
		int row = dao.saveLocation(location);
			JSONObject json = new JSONObject(); 
		if(row>0) {
			json.put("statusCode", "0");
			json.put("message", "success");
		}else{
			json.put("statusCode", "1");
			json.put("message", "Failed");
		}
		return json;
	}
	
	
	
	
	
	@RequestMapping(value = "/retrieveLocById/{id}")
	@ResponseBody
	public location sendLocationbasedOnId(@PathVariable("id") String id) {
		
		location location= dao.findByCustomerId(id);
	    return location;
	}
	
	
	
	
	
	@RequestMapping("/say")
	public String sayHello() {
		
		//List<location> customers = dao.isData();		 
		
		return "Helloss";
	}
}

//URL: http://localhost:8080/springbootds/getcustInfo