package killercreepr.minecraftstats.plan.data

import java.util.*

data class PlanPlayerData(
  val id: Long,
  val uuid: UUID,
  val registered: Long,
  val name: String,
)