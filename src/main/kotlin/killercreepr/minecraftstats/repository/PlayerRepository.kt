package killercreepr.minecraftstats.repository

import killercreepr.minecraftstats.entity.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PlayerRepository: JpaRepository<Player, UUID> {
  fun findByUuid(uuid: UUID): Player?
  fun existsByName(name: String): Boolean
  fun existsByUuid(uuid: UUID): Boolean
}