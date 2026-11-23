const { Sequelize } = require("sequelize");
const sequelize = new Sequelize(
  "bibliotheque_db", // Nom base de donnees
  "root", // Utilisateur
  "", // Mot de passe (vide par defaut)
  {
    host: "localhost",
    dialect: "mysql",
    logging: false, // Pas de logs SQL
  }
);

// Tester la connexion
sequelize
  .authenticate()
  .then(() => console.log("Connecte a MySQL!"))
  .catch((err) => console.error("Erreur MySQL:", err));
module.exports = sequelize;
