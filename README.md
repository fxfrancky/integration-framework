# integration-framework




    <driver name="postgresql" module="org.postgresql">
        <!-- for xa datasource -->
        <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
        <!-- for non-xa datasource -->
        <driver-class>org.postgresql.Driver</driver-class>
    </driver>






    <datasource jndi-name="java:jboss/datasources/IntegrationFrameworkDS" pool-name="IntegrationFrameworkDS" enabled="true" use-java-context="true">
        <connection-url>jdbc:postgresql://localhost:5432/OWONADB</connection-url>
        <driver>postgresql</driver>
        <security>
            <user-name>Admin</user-name>
            <password>Xavier123+s</password>
        </security>
    </datasource>






    <datasources>

        <datasource jndi-name="java:jboss/datasources/IntegrationFrameworkDS" pool-name="IntegrationFrameworkDS" enabled="true" use-java-context="true">
            <connection-url>jdbc:postgresql://localhost:5432/OWONADB</connection-url>
            <driver>postgresql</driver>
            <security>
                <user-name>Admin</user-name>
                <password>Xavier123+s</password>
            </security>
        </datasource>



        <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
            <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
            <driver>h2</driver>
            <security>
                <user-name>sa</user-name>
                <password>sa</password>
            </security>
        </datasource>
        <drivers>
            <driver name="h2" module="com.h2database.h2">
                <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
            </driver>

            <driver name="postgresql" module="org.postgresql">
                <!-- for xa datasource -->
                <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
                <!-- for non-xa datasource -->
                <driver-class>org.postgresql.Driver</driver-class>
            </driver>

        </drivers>
    </datasources>