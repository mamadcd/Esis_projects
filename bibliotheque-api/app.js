const express = require("express");
const cors = require("cors");
const app = express();
const sequelize = require("./db");
const Auteur = require("./models/Auteur");
const Livre = require("./models/Livre");

// Middlewares
app.use(cors());
app.use(express.json());

const auteursRoutes = require("./routes/auteurs");
app.use("/api/auteurs", auteursRoutes);
const livresRoutes = require("./routes/livres");
app.use("/api/livres", livresRoutes);

// Route de test
app.get("/", (req, res) => {
  res.json({ message: "API Bibliotheque - Bienvenue!" });
});
// Erreur 404
app.use((req, res) => {
  res.status(404).json({ erreur: "Route non trouvee" });
});

// Demarrer
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Serveur en ecoute sur 
http://localhost:${PORT}`);
});

// Synchroniser la BD avec les modeles
sequelize
  .sync()
  .then(() => console.log("Base de donnees synchronisee"))
  .catch((err) => console.error("Erreur sync:", err));
