package com.cardlinesrl.config;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

public interface DbConfig {

    DataSource dataSource();

    LocalContainerEntityManagerFactoryBean entityManager(
            EntityManagerFactoryBuilder builder,
            DataSource dataSource);

    PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory);
}
