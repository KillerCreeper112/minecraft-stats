import { useEffect, useState } from "react";
import PlayerCard from "../components/PlayerCard.jsx";

function Home() {
  const [players, setPlayers] = useState([]);
  const [selectedPlayer, setSelectedPlayer] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/players")
        .then(res => res.json())
        .then(data => setPlayers(data));
  }, []);

  return (
      <div>
        <h1>Players (OLD)</h1>

        <ul>
          {players.map(player => (

              <PlayerCard
                  key={player.uuid}
                  player={player}
                  onClick={()=> setSelectedPlayer(player)}
              />
          ))}
        </ul>

        <div style={{ minWidth: "200px" }}>
          <h2>Details</h2>

          {selectedPlayer ? (
              <div>
                <img
                    src={`https://mc-heads.net/avatar/${selectedPlayer.uuid}`}
                    width="64"
                    height="64"
                />

                <p><b>Name:</b> {selectedPlayer.name}</p>
                <p><b>UUID:</b> {selectedPlayer.uuid}</p>
              </div>
          ) : (
              <p>Select a player</p>
          )}
        </div>

      </div>
  );
}

export default Home;