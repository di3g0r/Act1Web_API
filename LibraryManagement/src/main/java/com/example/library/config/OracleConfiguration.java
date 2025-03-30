package com.example.library.config;

import oracle.jdbc.pool.OracleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class OracleConfiguration {
    private Logger logger = LoggerFactory.getLogger(OracleConfiguration.class);
    
    @Autowired
    private Environment env;
    
    @Bean
    public DataSource dataSource() throws SQLException {
        OracleDataSource ds = new OracleDataSource();
        
        // Use full connection descriptor instead of TNS alias
        String url = "jdbc:oracle:thin:@(description=(retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.mx-queretaro-1.oraclecloud.com))(connect_data=(service_name=g66c205be911df6_webdb_high.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))";
        
        // Set wallet location
        System.setProperty("oracle.net.tns_admin", "C:/Users/diego/OneDrive/Escritorio/Universidad/6to Semestre/Web/Periodo2/Act1/LibraryApi/LibraryManagement/Act1_wallet");
        System.setProperty("oracle.net.ssl_server_dn_match", "true");
        
        ds.setURL(url);
        logger.info("Using URL: " + url);
        ds.setUser("ADMIN");
        logger.info("Using Username: ADMIN");
        ds.setPassword("LasCalaveras123");
        
        return ds;
    }
}