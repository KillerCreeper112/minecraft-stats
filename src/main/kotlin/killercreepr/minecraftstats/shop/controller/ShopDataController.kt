package killercreepr.minecraftstats.shop.controller

import killercreepr.minecraftstats.shop.data.ShopTradeStat
import killercreepr.minecraftstats.shop.service.ShopDataService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/shop_data")
class ShopDataController(
  private val shopDataService: ShopDataService
) {
  @GetMapping
  fun getShopData(): List<ShopTradeStat> = shopDataService.getShopData()
}