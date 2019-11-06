//package com.epam.travel_agency.util;
//
//import com.opentable.db.postgres.embedded.EmbeddedPostgres;
//import org.flywaydb.core.Flyway;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//
//
//@Component
//@Qualifier("test")
//public class FlywayDBUtil implements GenericDataSource {
//
//    private final static Logger logger = LoggerFactory.getLogger(FlywayDBUtil.class);
//
//    private static EmbeddedPostgres postgresDB;
//
//    public DataSource getDataSource(){
//        if (postgresDB == null) {
//            try {
//                postgresDB = EmbeddedPostgres.builder().start();
//            } catch (IOException e) {
//                logger.info("Error in FlywayDBConnection.getEmbeddedPostgresDataSource()");
//            }
//            Flyway.configure().dataSource(postgresDB.getPostgresDatabase()).load().migrate();
//        }
//        return postgresDB.getPostgresDatabase();
//    }
//}
