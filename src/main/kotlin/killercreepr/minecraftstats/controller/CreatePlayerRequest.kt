package killercreepr.minecraftstats.controller

import java.util.UUID

data class CreatePlayerRequest(
  val uuid: UUID,
  val name: String
) {
}