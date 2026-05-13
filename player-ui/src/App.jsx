import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/NavigationBar";
import HomePage from "./pages/Home";
import ShopPage from "./pages/ShopData";
import Players from "./pages/Players.jsx";
import BottomBar from "./components/BottomBar.jsx";

function App() {
    return (
        <BrowserRouter>

            <Navbar />

            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/shop" element={<ShopPage />} />
                <Route path="/plan_player_data" element={<Players />} />
            </Routes>

          <BottomBar/>
        </BrowserRouter>
    );
}

export default App;