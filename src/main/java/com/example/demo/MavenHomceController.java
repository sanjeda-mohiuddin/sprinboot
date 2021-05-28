package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MavenHomceController {

	Map<Long,Student> map= new HashMap<Long,Student> ();
	
 	@GetMapping("/v1/home")
	public String home() {
		
		return "Home is calling -"+LocalDate.now();
	}
	
	@GetMapping("/v1/name")
	public String name(@RequestParam String name) {
		
		return "Home is calling -"+name;
	}
	
	@PostMapping("/student/add")
	public Student save(@RequestBody Student st) {
		map.put(st.id, st);
		return st;
	}
	
	@PostMapping("/student/update")
	public Student update(@RequestBody Student st) {
		map.put(st.id, st);
		return st;
	}
	
	@DeleteMapping("/student/delete")
	public Collection<Student> delete(@RequestParam long id) {
		map.remove(id);
		return (map.values());
	}
	
	@GetMapping("/student/list")
	public Collection<Student> allStudent( ) {
		return map.values();
	}
}
