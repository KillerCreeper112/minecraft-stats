package killercreepr.minecraftstats.controller

import killercreepr.minecraftstats.entity.Player
import killercreepr.minecraftstats.repository.PlayerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/players")
class PlayerController(
  val repository: PlayerRepository
) {
  @PostMapping
  fun createPlayer(@RequestBody request: CreatePlayerRequest): Player{
    if(repository.existsByUuid(request.uuid)) error("User ${request.uuid} already exists")
    return repository.save(
      Player(
        uuid = request.uuid,
        name = request.name
      )
    )
  }

  @GetMapping
  fun players(): List<Player> = repository.findAll()
}