/**
 * 
 */
package a.j.springstart.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author anjun
 *
 */
public class QuickPasswordEncodingGenerator {
	public static void main(String[] args) {
		String password = "abc125";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(password));
	}
}
