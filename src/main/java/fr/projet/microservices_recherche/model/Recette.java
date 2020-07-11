package fr.projet.microservices_recherche.model;

import java.awt.Image;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recette {

	private String _id;

	private List<String> ingredients;
	private List<String> etapesPreparation;
	private List<String> materiels;

	private String nomRecette;
	private String imageRecette;
	private String note;
	private String portion;
	private String difficulte;
	private String budget;
	private String tpsTotal;
	private String tpsPreparation;
	private String tpsCuisson;
	private String conseil;
	private String typeRecette;
	private String source;
	private String site;
	private String optionType;

	/////////////////////////// Getters Setters//////////////////////////////////////

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getEtapesPreparation() {
		return etapesPreparation;
	}

	public void setEtapesPreparation(List<String> etapesPreparation) {
		this.etapesPreparation = etapesPreparation;
	}

	public List<String> getMateriels() {
		return materiels;
	}

	public void setMateriels(List<String> materiels) {
		this.materiels = materiels;
	}

	public String getNomRecette() {
		return nomRecette;
	}

	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	public String getImageRecette() {
		return imageRecette;
	}

	public void setImageRecette(String imageRecette) {
		this.imageRecette = imageRecette;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPortion() {
		return portion;
	}

	public void setPortion(String portion) {
		this.portion = portion;
	}

	public String getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getTpsTotal() {
		return tpsTotal;
	}

	public void setTpsTotal(String tpsTotal) {
		this.tpsTotal = tpsTotal;
	}

	public String getTpsPreparation() {
		return tpsPreparation;
	}

	public void setTpsPreparation(String tpsPreparation) {
		this.tpsPreparation = tpsPreparation;
	}

	public String getTpsCuisson() {
		return tpsCuisson;
	}

	public void setTpsCuisson(String tpsCuisson) {
		this.tpsCuisson = tpsCuisson;
	}

	public String getConseil() {
		return conseil;
	}

	public void setConseil(String conseil) {
		this.conseil = conseil;
	}

	public String getTypeRecette() {
		return typeRecette;
	}

	public void setTypeRecette(String typeRecette) {
		this.typeRecette = typeRecette;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getVegieOUpa() {
		return optionType;
	}

	public void setVegieOUpa(String vegieOUpa) {
		this.optionType = vegieOUpa;
	}

	@Override
	public String toString() {
		return "recette [_id=" + _id + ", ingredients=" + ingredients + ", etapesPreparation=" + etapesPreparation
				+ ", materiels=" + materiels + ", nomRecette=" + nomRecette + ", imageRecette=" + imageRecette
				+ ", note=" + note + ", portion=" + portion + ", difficulte=" + difficulte + ", budget=" + budget
				+ ", tpsTotal=" + tpsTotal + ", tpsPreparation=" + tpsPreparation + ", tpsCuisson=" + tpsCuisson
				+ ", conseil=" + conseil + ", typeRecette=" + typeRecette + ", source=" + source + ", site=" + site
				+ ", vegieOUpa=" + optionType + "]";
	}
}