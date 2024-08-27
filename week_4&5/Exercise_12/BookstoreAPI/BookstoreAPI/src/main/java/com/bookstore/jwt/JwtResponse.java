package com.bookstore.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {
	@Getter
    private String jwtToken;
	@Getter
    private String username;
    public static  JwtResponse builder() {
    	//System.out.println(getjwtToken());
 		return new JwtResponse();
 	}

}
