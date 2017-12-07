/**
 *Objektene av alle klassene som implementerer dette
 *grensesnittet kan laane ut et objekt og levere det tilbake.
 *@author Peter Killingstad
 *Version 09.02.2015
 */
interface TilUtlaan{
	/**
	 * Et objekt som kan laanes ut skal kunne faa tilknyttet en laaner
	 * @param _navn 	navnet paa den som laaner objektet
	 */
	public void laanUt(String _navn);
	/**
	 * Et objekt som kan laanes ut skal kunne leveres tilbake
	 * Navnet paa den som laaner objektet maa settes til null
	 */
	public void leverTilbake();
}
