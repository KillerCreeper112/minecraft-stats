package killercreepr.minecraftstats.plan.controller

import killercreepr.minecraftstats.plan.data.PlanPlayerData
import killercreepr.minecraftstats.plan.service.PlanDataService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plan_player_data")
class PlanDataController(
  private val planDataService: PlanDataService
) {
  @GetMapping
  fun getPlayerData(
    @RequestParam(defaultValue = "0") page: Int,
    @RequestParam(defaultValue = "50") size: Int,
    @RequestParam(required = false) searchTerm: String?,
  ): List<PlanPlayerData> = planDataService.getPlayerData(page, size, searchTerm)
}