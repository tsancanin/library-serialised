package programming.tamara.library.serialized.service;

import java.util.List;

import programming.tamara.library.serialized.model.Author;
import programming.tamara.library.serialized.repository.AuthorRepository;

public class AuthorService {
	
	public static List<Author> findAll() throws Exception{
		
		try {
			return AuthorRepository.selectAll();
		} catch (Exception e) {
			throw e;
		}
	}

}
