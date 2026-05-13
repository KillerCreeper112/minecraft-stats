import {useEffect, useState} from "react";
import PlayerCard from "../components/PlayerCard.jsx";
import "./Players.css"

function Players() {
  const [players, setPlayers] = useState([]);
  const [selectedPlayer, setSelectedPlayer] = useState(null);
  const [page, setPage] = useState(0)
  const [searchTerm, setSearchTerm] = useState(null);

  useEffect(() => {
    fetch(`http://localhost:8080/plan_player_data?page=${page}&size=52&searchTerm=${searchTerm}`)
      .then(res => res.json())
      .then(data => setPlayers(data));
  }, [page, searchTerm]);

  const onSearch = (e) =>{
    setSearchTerm(e.target.value);
  }

  return (
    <div>
      <h1>Players</h1>

      <input
        type={"text"}
        placeholder={"Search..."}
        value={searchTerm}
        onChange={onSearch}
        style={{
          padding: '10px', width: '300px'
        }}
      />

      <ul
        style={{
          padding: '10px',
          justifyContent: 'center'
        }}
      >
        {players.map(player => (

          <PlayerCard
            key={player.uuid}
            player={player}
            onClick={() => setSelectedPlayer(player)}
          />
        ))}
      </ul>

      <div style={{
        minWidth: "150px",
        position: 'fixed',
        verticalAlign: "middle",
        horizontalAlign: "middle",
        right: '10px',
        top: '50%',
        padding: '10px',
      }}>
        <h2>Details</h2>

        {selectedPlayer ? (
          <div>
            <img
              src={`https://mc-heads.net/avatar/${selectedPlayer.uuid}`}
              width="64"
              height="64"
              alt={"n/a"}/>

            <p>{selectedPlayer.name}</p>
            <p><b>UUID:</b><br/>{selectedPlayer.uuid}</p>
          </div>
        ) : (
          <p>Select a player</p>
        )}
      </div>

      <button
        disabled={page === 0}
        onClick={() => {setPage(page-1)}}
      >
        Previous
      </button>

      <button
        onClick={() => {setPage(page+1)}}
      >
        Next
      </button>

    </div>
  );
}

export default Players;