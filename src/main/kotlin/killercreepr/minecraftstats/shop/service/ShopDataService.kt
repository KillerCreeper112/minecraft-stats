package killercreepr.minecraftstats.shop.service

import killercreepr.minecraftstats.shop.data.ShopTradeStat
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class ShopDataService(
  @Qualifier("shopJdbcTemplate")
  private val jdbcTemplate: JdbcTemplate
) {
  fun getShopData(): List<ShopTradeStat> {
    return jdbcTemplate.query(
      """
            SELECT 
                npc_trader_key,
                trade_key,
                total_currency,
                use_count
            FROM npc_trade_stats
            """
    ) { rs, row ->

      ShopTradeStat(
        npcTraderKey = rs.getString("npc_trader_key"),
        tradeKey = rs.getString("trade_key"),
        totalCurrency = rs.getLong("total_currency"),
        useCount = rs.getLong("use_count")
      )
    }
  }
}