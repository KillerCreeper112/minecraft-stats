function PlayerCard({player, onClick}){
    return (
        <button
            onClick={onClick}
            key={player.uuid}
            style={{
                display: "flex",
                alignItems: "center",
                gap: "10px",
                padding: "10px",
                width: "220px"
            }}
        >

            <img
                src={`https://mc-heads.net/avatar/${player.uuid}`}
                alt="head"
                width="32"
                height="32"
            />

            {player.name}
        </button>
    )
}
export default PlayerCard;