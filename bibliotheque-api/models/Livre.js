const { DataTypes } = require("sequelize");
const sequelize = require("../db");
const Auteur = require("./Auteur");
const Livre = sequelize.define(
  "Livre",
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    titre: {
      type: DataTypes.STRING(150),
      allowNull: false,
      validate: {
        notEmpty: { msg: "Le titre ne peut pas etre vide" },
      },
    },
    isbn: {
      type: DataTypes.STRING(20),
      unique: true,
      allowNull: false,
    },
    description: {
      type: DataTypes.TEXT,
    },
    datePublication: {
      type: DataTypes.DATE,
    },
    nombrePages: {
      type: DataTypes.INTEGER,
    },
    genre: {
      type: DataTypes.STRING(50),
    },
    disponible: {
      type: DataTypes.BOOLEAN,
      defaultValue: true,
    },
    nombreExemplaires: {
      type: DataTypes.INTEGER,
      defaultValue: 1,
    },
    auteurId: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: Auteur,
        key: "id",
      },
    },
    createdAt: {
      type: DataTypes.DATE,
      defaultValue: DataTypes.NOW,
    },
  },
  {
    timestamps: false,
    tableName: "livres",
  }
);
// Relation
Auteur.hasMany(Livre, { foreignKey: "auteurId" });
Livre.belongsTo(Auteur, { foreignKey: "auteurId" });
module.exports = Livre;
