package com.example.CarAudioShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Woofers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String Model;

	private int Company_ID;

	private java.sql.Date Date;

	private String Comment;

	private String Notes;

	private String Piston_Desc;

	private String Susp_Desc;

	private String Dust_Cap_Desc;

	private String Frame_Desc;

	private String VC_Desc;

	private String Term_Desc;

	private String Mag_Desc;

	private int DualMG;

	private double Fs;

	private double Qms;

	private double Vas;

	private double Cms;

	private double Mms;

	private double Rms;

	private double Xlin;

	private String P_Dia;

	private double Sd;

	private double Qes;

	private double Re;

	private double Le;

	private double Z;

	private double BL;

	private double Pe;

	private double Qts;

	private double Eff;

	private double SPL1;
	private double SPL2;
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getCompany_ID() {
		return Company_ID;
	}
	public void setCompany_ID(int company_ID) {
		Company_ID = company_ID;
	}
	public java.sql.Date getDate() {
		return Date;
	}
	public void setDate(java.sql.Date date) {
		Date = date;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getPiston_Desc() {
		return Piston_Desc;
	}
	public void setPiston_Desc(String piston_Desc) {
		Piston_Desc = piston_Desc;
	}
	public String getSusp_Desc() {
		return Susp_Desc;
	}
	public void setSusp_Desc(String susp_Desc) {
		Susp_Desc = susp_Desc;
	}
	public String getDust_Cap_Desc() {
		return Dust_Cap_Desc;
	}
	public void setDust_Cap_Desc(String dust_Cap_Desc) {
		Dust_Cap_Desc = dust_Cap_Desc;
	}
	public String getFrame_Desc() {
		return Frame_Desc;
	}
	public void setFrame_Desc(String frame_Desc) {
		Frame_Desc = frame_Desc;
	}
	public String getVC_Desc() {
		return VC_Desc;
	}
	public void setVC_Desc(String vC_Desc) {
		VC_Desc = vC_Desc;
	}
	public String getTerm_Desc() {
		return Term_Desc;
	}
	public void setTerm_Desc(String term_Desc) {
		Term_Desc = term_Desc;
	}
	public String getMag_Desc() {
		return Mag_Desc;
	}
	public void setMag_Desc(String mag_Desc) {
		Mag_Desc = mag_Desc;
	}
	public int getDualMG() {
		return DualMG;
	}
	public void setDualMG(int dualmg) {
		DualMG = dualmg;
	}
	public double getFs() {
		return Fs;
	}
	public void setFs(double fs) {
		Fs = fs;
	}
	public double getQms() {
		return Qms;
	}
	public void setQms(double qms) {
		Qms = qms;
	}
	public double getVas() {
		return Vas;
	}
	public void setVas(double vas) {
		Vas = vas;
	}
	public double getCms() {
		return Cms;
	}
	public void setCms(double cms) {
		Cms = cms;
	}
	public double getMms() {
		return Mms;
	}
	public void setMms(double mms) {
		Mms = mms;
	}
	public double getRms() {
		return Rms;
	}
	public void setRms(double rms) {
		Rms = rms;
	}
	public double getXlin() {
		return Xlin;
	}
	public void setXlin(double xlin) {
		Xlin = xlin;
	}
	public String getP_Dia() {
		return P_Dia;
	}
	public void setP_Dia(String p_Dia) {
		P_Dia = p_Dia;
	}
	public double getSd() {
		return Sd;
	}
	public void setSd(double sd) {
		Sd = sd;
	}
	public double getQes() {
		return Qes;
	}
	public void setQes(double qes) {
		Qes = qes;
	}
	public double getRe() {
		return Re;
	}
	public void setRe(double re) {
		Re = re;
	}
	public double getLe() {
		return Le;
	}
	public void setLe(double le) {
		Le = le;
	}
	public double getZ() {
		return Z;
	}
	public void setZ(double z) {
		Z = z;
	}
	public double getBL() {
		return BL;
	}
	public void setBL(double bL) {
		BL = bL;
	}
	public double getPe() {
		return Pe;
	}
	public void setPe(double pe) {
		Pe = pe;
	}
	public double getQts() {
		return Qts;
	}
	public void setQts(double qts) {
		Qts = qts;
	}
	public double getEff() {
		return Eff;
	}
	public void setEff(double eff) {
		Eff = eff;
	}
	public double getSPL1() {
		return SPL1;
	}
	public void setSPL1(double sPL1) {
		SPL1 = sPL1;
	}
	public double getSPL2() {
		return SPL2;
	}
	public void setSPL2(double sPL2) {
		SPL2 = sPL2;
	}
	public int getId() {
		return id;
	}
	
	

}
