package killercreepr.minecraftstats.shop.data

data class ShopTradeStat(
    val npcTraderKey: String,
    val tradeKey: String,
    val totalCurrency: Long,
    val useCount: Long
)