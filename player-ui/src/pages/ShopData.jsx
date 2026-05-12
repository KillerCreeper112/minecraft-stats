import { useEffect, useState } from "react";
import ShopDataCard from "../components/ShopDataCard.jsx";
import "./ShopData.css"

function ShopData() {
  const [shopData, setShopData] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/shop_data")
        .then(res => res.json())
        .then(data =>{
            console.log(data);
            setShopData(data)
        });
  }, []);

  return (
      <div>
        <h1>Shop Data</h1>

        <ul>
          {shopData.map(data => (

              <ShopDataCard
                  key={data.npcTraderKey}
                  data={data}
              />
          ))}
        </ul>

      </div>
  );
}

export default ShopData;