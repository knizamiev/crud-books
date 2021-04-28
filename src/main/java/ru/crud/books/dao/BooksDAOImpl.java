package ru.crud.books.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import ru.crud.books.dao.common.AbstractDAO;
import ru.crud.books.dao.common.ExtendedBeanPropertySqlParameterSource;
import ru.crud.books.model.Books;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class BooksDAOImpl extends AbstractDAO implements BooksDAO {

	private static final BeanPropertyRowMapper<Books> BOOKS_ROW_MAPPER =
			new BeanPropertyRowMapper<>(Books.class);

	public BooksDAOImpl(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public List<Books> findBooks() {
		return jdbcTemplate.query("select * from books", BOOKS_ROW_MAPPER);
	}

	@Override
	public Books findBook(long id) {
		return jdbcTemplate.queryForObject("select * from books where id = :id", map("id", id), BOOKS_ROW_MAPPER);
	}

	@Override
	public void addBook(Books books) {
		ExtendedBeanPropertySqlParameterSource source = new ExtendedBeanPropertySqlParameterSource(books);

		jdbcTemplate.update("insert into books(" +
						"id, name, author, price)" +
						"values (nextval('books_seq'), :name, :author, :price)", source);
	}


}
