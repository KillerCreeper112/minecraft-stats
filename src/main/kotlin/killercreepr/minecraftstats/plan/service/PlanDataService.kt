package killercreepr.minecraftstats.plan.service

import killercreepr.minecraftstats.plan.data.PlanPlayerData
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PlanDataService(
  @Qualifier("planJdbcTemplate")
  private val jdbcTemplate: JdbcTemplate
) {
  fun getPlayerData(): List<PlanPlayerData> {
    return jdbcTemplate.query(
      """
            SELECT 
                id,
                uuid,
                registered,
                name
            FROM plan_users
            """
    ) { rs, row ->

      PlanPlayerData(
        id = rs.getLong("id"),
        uuid = UUID.fromString(rs.getString("uuid")),
        registered = rs.getLong("registered"),
        name = rs.getString("name"),
      )
    }
  }
  fun getPlayerData(page: Int, size: Int, searchTerm: String?): List<PlanPlayerData> {
    val offset = page * size

    println("$searchTerm")

    val query = StringBuilder("""
      SELECT id, uuid, registered, name
      FROM plan_users
    """)

    val params = mutableListOf<Any>()

    if(!searchTerm.isNullOrBlank()){
      query.append(" WHERE name LIKE ? ")
      params.add("%$searchTerm%")
    }

    query.append("""
      ORDER BY registered DESC
      LIMIT ?
      OFFSET ?
    """)
    params.apply {
      add(size)
      add(offset)
    }

    return jdbcTemplate.query(query.toString(),
      { rs, row ->

        PlanPlayerData(
          id = rs.getLong("id"),
          uuid = UUID.fromString(rs.getString("uuid")),
          registered = rs.getLong("registered"),
          name = rs.getString("name"),
        )
      },
      *params.toTypedArray()
    )
  }
}