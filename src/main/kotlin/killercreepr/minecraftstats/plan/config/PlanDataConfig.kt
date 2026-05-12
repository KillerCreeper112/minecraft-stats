package killercreepr.minecraftstats.plan.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@Configuration
class PlanDataConfig {
  @Bean
  @ConfigurationProperties("plan.datasource")
  fun planProps() = DataSourceProperties()

  @Bean
  fun planDataSource(@Qualifier("planProps") planProps: DataSourceProperties): DataSource =
    planProps.initializeDataSourceBuilder().build()

  @Bean
  fun planJdbcTemplate(@Qualifier("planDataSource") ds: DataSource) = JdbcTemplate(ds)
}