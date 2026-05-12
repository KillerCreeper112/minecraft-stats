package killercreepr.minecraftstats.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
class DataSourceConfig {

  @Primary
  @Bean
  @ConfigurationProperties("spring.datasource")
  fun dataSourceProperties(): DataSourceProperties =
    DataSourceProperties()

  @Primary
  @Bean
  fun dataSource(props: DataSourceProperties): DataSource =
    props.initializeDataSourceBuilder().build()
}