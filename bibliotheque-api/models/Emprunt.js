const { DataTypes } = require("sequelize");
const sequelize = require("../db");
const Livre = require("./Livre");
const Emprunt = sequelize.define("Emprunt", {
  id: { primaryKey: true, autoIncrement: true, type: DataTypes.INTEGER },
  livreId: {
    references: {
      model: "livres",
      key: "id",
    },
    allowNull: false,
    type: DataTypes.INTEGER,
  },
  nomEmprunter: {
    type: DataTypes.STRING(100),
    allowNull: false,
  },
  dateEmprunt: {
    type: DataTypes.DATE,
    allowNull: false,
  },
  dateRetourPrevue: {
    type: DataTypes.DATE,
    allowNull: false,
  },
  dateRetourReel: {
    type: DataTypes.DATE,
    allowNull: true,
  },
});

Livre.belongsTo(Livre, { foreignKey: "livreId" });
