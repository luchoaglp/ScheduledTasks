package com.cardlinesrl.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = { "com.cardlinesrl.virtualline.*" },
        entityManagerFactoryRef = "virtuallineEntityManager",
        transactionManagerRef = "virtuallineTransactionManager"
)
public class VirtuallineDbConfig implements DbConfig {

    @Override
    @Bean(name = "virtuallineDataSource")
    @ConfigurationProperties(prefix = "virtualline.config")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Override
    @Bean(name = "virtuallineEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("virtuallineDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.cardlinesrl.virtualline.*")
                .persistenceUnit("virtualline")
                .build();
    }

    @Override
    @Bean(name = "virtuallineTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("virtuallineEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}