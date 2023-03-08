package com.pix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ResourceController {

	@GetMapping("private")
	public String privateEndpoint() {
		return "private";
	}
	
	@GetMapping("public")
	public String publicEndpoint() {
		return "public";
	}
}
