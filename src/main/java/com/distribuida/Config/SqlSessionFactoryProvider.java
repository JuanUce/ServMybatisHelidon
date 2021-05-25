package com.distribuida.Config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;


import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.cdi.SessionFactoryProvider;

import org.apache.ibatis.session.Configuration;
import com.zaxxer.hikari.HikariDataSource;

@ApplicationScoped
public class SqlSessionFactoryProvider {

	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/BDAutorLibro";
	private String password = "1234";
	private String user = "postgres";

	@Produces
	@ApplicationScoped
	public DataSource dataSource() {

		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(driver);

		ds.setJdbcUrl(url);
		ds.setPassword(password);
		ds.setUsername(user);
		ds.setMaximumPoolSize(3);
		ds.setMinimumIdle(1);

		return ds;
	}

	@Produces
	@ApplicationScoped
	@SessionFactoryProvider
	public SqlSessionFactory produceFactory() {
		DataSource ds = dataSource();
		TransactionFactory transactionFactory = new ManagedTransactionFactory();
		Environment.Builder builder = new Environment.Builder("development");

		Environment environment = builder
				.transactionFactory(transactionFactory)
				.dataSource(ds)
				.build();

		Configuration confg = new Configuration(environment);
		confg.setMapUnderscoreToCamelCase(true);
		confg.addMappers("com.distribuida.mapper");
		SqlSessionFactory factory = new DefaultSqlSessionFactory(confg);

		return factory;

	}

}
