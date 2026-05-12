package killercreepr.minecraftstats

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@SpringBootApplication
class MinecraftStatsApplication

fun main(args: Array<String>) {
  runApplication<MinecraftStatsApplication>(*args)
}
