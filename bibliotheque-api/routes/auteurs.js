const express = require("express");
const router = express.Router();
const Auteur = require("../models/Auteur");
const { Op } = require("sequelize");
// GET - Recuperer TOUS les auteurs
router.get("/", async (req, res) => {
  try {
    const auteurs = await Auteur.findAll();
    res.json({
      success: true,
      count: auteurs.length,
      data: auteurs,
    });
  } catch (err) {
    res.status(500).json({
      success: false,
      erreur: "Erreur serveur",
      details: err.message,
    });
  }
});
// GET - Recuperer UN auteur par ID
router.get("/:id", async (req, res) => {
  try {
    const id = parseInt(req.params.id, 10);
    if (isNaN(id)) {
      return res.status(400).json({
        success: false,
        erreur: "ID invalide",
      });
    }
    const auteur = await Auteur.findByPk(id);
    if (!auteur) {
      return res.status(404).json({
        success: false,
        erreur: "Auteur non trouve",
      });
    }
    res.json({
      success: true,
      data: auteur,
    });
  } catch (err) {
    res.status(500).json({
      success: false,
      erreur: err.message,
    });
  }
});

// POST - Creer un nouvel auteur
router.post("/", async (req, res) => {
  try {
    const { nom, prenom, nationalite, dateNaissance, biographie } = req.body;

    // Validation
    if (!nom || !prenom) {
      return res.status(400).json({
        success: false,
        erreur: "nom et prenom sont obligatoires",
      });
    }

    const auteur = await Auteur.create({
      nom,
      prenom,
      nationalite,
      dateNaissance,
      biographie,
    });

    res.status(201).json({
      success: true,
      message: "Auteur cree avec succes",
      data: auteur,
    });
  } catch (err) {
    res.status(400).json({
      success: false,
      erreur: err.message,
    });
  }
});

// PUT - Modifier un auteur
router.put("/:id", async (req, res) => {
  try {
    const id = parseInt(req.params.id, 10);

    if (isNaN(id)) {
      return res.status(400).json({
        success: false,
        erreur: "ID invalide",
      });
    }

    const auteur = await Auteur.findByPk(id);

    if (!auteur) {
      return res.status(404).json({
        success: false,
        erreur: "Auteur non trouve",
      });
    }

    await auteur.update(req.body);

    res.json({
      success: true,
      message: "Auteur modifie avec succes",
      data: auteur,
    });
  } catch (err) {
    res.status(400).json({
      success: false,
      erreur: err.message,
    });
  }
});

// DELETE - Supprimer un auteur
router.delete("/:id", async (req, res) => {
  try {
    const id = parseInt(req.params.id, 10);

    if (isNaN(id)) {
      return res.status(400).json({
        success: false,
        erreur: "ID invalide",
      });
    }
    const auteur = await Auteur.findByPk(id);
    if (!auteur) {
      return res.status(404).json({
        success: false,
        erreur: "Auteur non trouve",
      });
    }
    await auteur.destroy();
    res.json({
      success: true,
      message: "Auteur supprime avec succes",
    });
  } catch (err) {
    res.status(500).json({
      success: false,
      erreur: err.message,
    });
  }
});
module.exports = router;
