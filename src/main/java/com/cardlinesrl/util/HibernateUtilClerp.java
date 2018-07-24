package com.cardlinesrl.util;

import java.util.HashMap;
import java.util.Map;

import com.cardlinesrl.clerp.model.VirtualBalance;
import com.cardlinesrl.clerp.model.VirtualParticipant;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtilClerp {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {

                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

                Map<String, Object> settings = new HashMap<>();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, ConnectionData.CLERP_URL);
                settings.put(Environment.USER, ConnectionData.CLERP_USER);
                settings.put(Environment.PASS, ConnectionData.CLERP_PASS);
                //settings.put(Environment.HBM2DDL_AUTO, "update");
                //settings.put(Environment.SHOW_SQL, true);

                registryBuilder.applySettings(settings);

                registry = registryBuilder.build();
                MetadataSources sources = new MetadataSources(registry)
                        .addAnnotatedClass(VirtualParticipant.class)
                        .addAnnotatedClass(VirtualBalance.class);

                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}
