package com.synergix.globalsetup.party.steps;

import com.synergix.globalsetup.party.page.PartyPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PartySteps extends ScenarioSteps {

	PartyPage onBankPage;

	public void switchToIFrame() {
		onBankPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		onBankPage.switchOutDefaultIFrame();
	}

	@Step
	public void clickOnUpdateButton() {
		onBankPage.onClickUpdateButton();
	}

	@Step
	public void addBank() {
		onBankPage.onClickNewButton();
	}

	@Step
	public void typePartyCode(String partyCode) {
		onBankPage.typePartyCode(partyCode);
	}

	@Step
	public void typePartyName(String partyName) {
		onBankPage.typePartyName(partyName);
	}

	@Step
	public void typePartyShortName(String partyShortName) {
		onBankPage.typePartyShortName(partyShortName);
	}

	@Step
	public void typePartyGroupCode(String partyGroupCode) {
		onBankPage.typePartyGroupCode(partyGroupCode);
	}

	@Step
	public void typeCountryOfIncorporation(String countryOfIncorporation) {
		onBankPage.typeCountryOfIncorporation(countryOfIncorporation);
	}

	@Step
	public void typeMainHomePage(String mainHomePage) {
		onBankPage.typeMainHomePage(mainHomePage);
	}

	@Step
	public void chooseTaxAgent(String taxAgent) {
		onBankPage.chooseTaxAgent(taxAgent);
	}

	@Step
	public void typeGSTRegistrationNo(String gSTRegistrationNo) {
		onBankPage.typeGSTRegistrationNo(gSTRegistrationNo);
	}

	@Step
	public void typeUniqueEntityNo(String uniqueEntityNo) {
		onBankPage.typeUniqueEntityNo(uniqueEntityNo);
	}

	@Step
	public void typePartyContraGLAN(String partyContraGLAN) {
		onBankPage.typePartyContraGLAN(partyContraGLAN);
	}

	@Step
	public void typeContraRealizedExchGLAN(String contraRealizedExchGLAN) {
		onBankPage.typeContraRealizedExchGLAN(contraRealizedExchGLAN);
	}

	@Step
	public void chooseRelationService(String partyRelation, String serviceType) {
		onBankPage.chooseRelationService(partyRelation, serviceType);
	}

	@Step
	public void typeAccountNo(String accountNo, int row) {
		onBankPage.typeAccountNo(accountNo, row);
	}

	@Step
	public void typeBranchCode(String branchCode, int row) {
		onBankPage.typeBranchCode(branchCode, row);
	}

	@Step
	public void typeCurrencyCode(String currencyCode, int row) {
		onBankPage.typeCurrencyCode(currencyCode, row);
	}

	@Step
	public void typeBankGLAN(String bankGLAN, int row) {
		onBankPage.typeBankGLAN(bankGLAN, row);
	}

	@Step
	public void typeLastChequeNo(String lastChequeNo, int row) {
		onBankPage.typeLastChequeNo(lastChequeNo, row);
	}

	@Step
	public void chooseCombineBCinPayment(int row) {
		onBankPage.chooseCombineBCinPayment(row);
	}

	@Step
	public void chooseCombineBCinReceipt(int row) {
		onBankPage.chooseCombineBCinReceipt(row);
	}

	@Step
	public void checkAllCompany() {
		onBankPage.chooseAllCompany();
	}

	@Step
	public void checkCompany(String company) {
		onBankPage.chooseCompany(company);

	}

	@Step
	public void moveToCompanyTab() {
		onBankPage.switch_to_tab("Company");
	}

	@Step
	public void moveToLocalInfoTab() {
		onBankPage.switch_to_tab("Local Info");
	}

	@Step
	public void moveToRelationServiceGroupTab() {
		onBankPage.switch_to_tab("Relation/Service Group");
	}

	@Step
	public void moveToOwnBankDetailTab() {
		onBankPage.switch_to_tab("Own Bank Detail");
	}

	@Step
	public void addBankDetail() {
		onBankPage.clickOnAddBtn();
	}

	@Step
	public void searchBank(String partyCode) {
		onBankPage.searchBank(partyCode);
	}

	@Step
	public void chooseAllCompany() {
		onBankPage.chooseAllCompany();
	}

	@Step
	public void chooseCompany(String company2) {
		onBankPage.chooseCompany(company2);
	}

	public boolean isOwnBankDetailExit(String accountNo) {
		return onBankPage.isOwnBankDetailExit(accountNo);
	}

	@Step
	public void chooseDelOwnBankDetail(String accountNo) {
		onBankPage.chooseDelOwnBankDetail(accountNo);
	}

	public int countRowTb() {
		return onBankPage.countRowTb();
	}

	public String autoGenCode(String prefix) {
		return onBankPage.autoGenCode(prefix);
	}

	/**
	 *
	 * @param partyCode
	 * @param partyName
	 * @author Ian
	 */
	@Step
	public void create_new_party(String partyCode, String partyName) {
		onBankPage.switchToIFrame("th5frame");

		addBank();
		onBankPage.waitForAllJSCompletes();

		typePartyCode(partyCode);
		onBankPage.waitForAllJSCompletes();

		typePartyName(partyName);
		onBankPage.waitForAllJSCompletes();

		clickOnUpdateButton();

		onBankPage.switchOutDefaultIFrame();
	}
}
