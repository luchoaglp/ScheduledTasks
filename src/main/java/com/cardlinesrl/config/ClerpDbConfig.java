package com.cardlinesrl.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = { "com.cardlinesrl.clerp.*" },
        entityManagerFactoryRef = "clerpEntityManager",
        transactionManagerRef = "clerpTransactionManager"
)
public class ClerpDbConfig implements DbConfig {

    @Override
    @Primary
    @Bean(name = "clerpDataSource")
    @ConfigurationProperties(prefix = "clerp.config")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Override
    @Primary
    @Bean(name = "clerpEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("clerpDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.cardlinesrl.clerp.*")
                .persistenceUnit("clerp")
                .build();
    }

    @Override
    @Primary
    @Bean(name = "clerpTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("clerpEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}