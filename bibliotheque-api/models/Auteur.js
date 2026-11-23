const { DataTypes } = require("sequelize");
const sequelize = require("../db");
const Auteur = sequelize.define(
  "Auteur",
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    nom: {
      type: DataTypes.STRING(100),
      allowNull: false,
      validate: {
        notEmpty: { msg: "Le nom ne peut pas etre vide" },
      },
    },
    prenom: {
      type: DataTypes.STRING(100),
      allowNull: false,
    },
    nationalite: {
      type: DataTypes.STRING(100),
    },
    dateNaissance: {
      type: DataTypes.DATE,
    },
    biographie: {
      type: DataTypes.TEXT,
    },
    createdAt: {
      type: DataTypes.DATE,
      defaultValue: DataTypes.NOW,
    },
  },
  {
    timestamps: false,
    tableName: "auteurs",
  }
);
module.exports = Auteur;
