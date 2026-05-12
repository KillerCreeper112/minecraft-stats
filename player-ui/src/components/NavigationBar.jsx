import { Link } from "react-router-dom";

function Navbar() {
    return (
        <nav style={styles.nav}>
            <h2 style={styles.logo}>Minecraft Stats</h2>

            <div style={styles.links}>
                <Link to="/" style={styles.link}>Home</Link>
                <Link to="/shop" style={styles.link}>Shop</Link>
                <Link to="/plan_player_data" style={styles.link}>Players</Link>
            </div>
        </nav>
    );
}

const styles = {
    nav: {
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
        padding: "10px 20px",
        backgroundColor: "#222",
        color: "white"
    },
    logo: {
        margin: 0
    },
    links: {
        display: "flex",
        gap: "15px"
    },
    link: {
        color: "white",
        textDecoration: "none"
    }
};

export default Navbar;