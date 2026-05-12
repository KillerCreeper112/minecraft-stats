function ShopDataCard({data}){
    const tradeKeyParts = data.tradeKey.split("_for_");

    const ingredientTitle = toTitle(tradeKeyParts[0]);
    const resultTile = toTitle(tradeKeyParts[1]);

    return (
        <button
            //onClick={onClick}
            key={data.npcTraderKey}
            style={{
                display: "flex",
                alignItems: "center",
                gap: "10px",
                padding: "10px",
                width: "150px",
                height: "150px"
            }}
        >
            {data.npcTraderKey}<br/>
            {ingredientTitle} for {resultTile}<br/>
            Currency: {data.totalCurrency}<br/>
            Uses: {data.useCount}
        </button>
    )
}

function toTitle(str){
    const index = str.indexOf(':');
    const word = index < 0 ? str : str.substring(index+1, str.length);
    return word.split("_")
        .map(s => s.charAt(0).toUpperCase() + s.slice(1))
        .join(" ")
}

export default ShopDataCard;