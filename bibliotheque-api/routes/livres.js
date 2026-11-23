const express = require("express");
const router = express.Router();
const Livre = require("../models/Livre");
const { Op } = require("sequelize");
// GET - Recuperer TOUS les livres
router.get("/", async (req, res) => {
  try {
    const livres = await Livre.findAll();
    res.json({
      success: true,
      count: livres.length,
      data: livres,
    });
  } catch (err) {
    res.status(500).json({
      success: false,
      erreur: "Erreur serveur",
      details: err.message,
    });
  }
});

// GET - Recuperer UN livre par ID
router.get("/:id", async (req, res) => {
  try {
    const id = parseInt(req.params.id, 10);
    if (isNaN(id)) {
      return res.status(400).json({
        success: false,
        erreur: "ID invalide",
      });
    }
    const livre = await Livre.findByPk(id);
    if (!livre) {
      return res.status(404).json({
        success: false,
        erreur: "Livre non trouve",
      });
    }
    res.json({
      success: true,
      data: livre,
    });
  } catch (err) {
    res.status(500).json({
      success: false,
      erreur: err.message,
    });
  }
});

// POST - Creer un nouvel livre
router.post("/", async (req, res) => {
  try {
    const {
      titre,
      isbn,
      description,
      datePublication,
      nombrePages,
      genre,
      disponible,
      nombreExemplaires,
      auteurId,
      createdAt,
    } = req.body;

    const livre = await Livre.create({
      titre,
      isbn,
      description,
      datePublication,
      nombrePages,
      genre,
      disponible,
      nombreExemplaires,
      auteurId,
      createdAt,
    });

    res.status(201).json({
      success: true,
      message: "Livre cree avec succes",
      data: livre,
    });
  } catch (err) {
    res.status(400).json({
      success: false,
      erreur: err.message,
    });
  }
});

// PUT - Modifier un livre
router.put("/:id", async (req, res) => {
  try {
    const id = parseInt(req.params.id, 10);

    if (isNaN(id)) {
      return res.status(400).json({
        success: false,
        erreur: "ID invalide",
      });
    }

    const livre = await Livre.findByPk(id);

    if (!livre) {
      return res.status(404).json({
        success: false,
        erreur: "Livre non trouve",
      });
    }

    await livre.update(req.body);
    res.json({
      success: true,
      message: "Livre modifie avec succes",
      data: livre,
    });
  } catch (err) {
    res.status(400).json({
      success: false,
      erreur: err.message,
    });
  }
});

// DELETE - Supprimer un livre
router.delete("/:id", async (req, res) => {
  try {
    const id = parseInt(req.params.id, 10);
    if (isNaN(id)) {
      return res.status(400).json({
        success: false,
        erreur: "ID invalide",
      });
    }
    const livre = await Livre.findByPk(id);

    if (!livre) {
      return res.status(404).json({
        success: false,
        erreur: "Livre non trouve",
      });
    }

    await livre.destroy();

    res.json({
      success: true,
      message: "Livre supprime avec succes",
    });
  } catch (err) {
    res.status(500).json({
      success: false,
      erreur: "Erreur serveur",
      details: err.message,
    });
  }
});

module.exports = router;
