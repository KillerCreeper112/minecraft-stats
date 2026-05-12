package killercreepr.minecraftstats.shop.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@Configuration
class ShopDataConfig {
  @Bean
  @ConfigurationProperties("shop.datasource")
  fun shopProps() = DataSourceProperties()

  @Bean
  fun shopDataSource(@Qualifier("shopProps") shopProps: DataSourceProperties): DataSource =
    shopProps.initializeDataSourceBuilder().build()

  @Bean
  fun shopJdbcTemplate(@Qualifier("shopDataSource") ds: DataSource) = JdbcTemplate(ds)
}