import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		List<TaxPayer> taxPayers = new ArrayList<TaxPayer>();
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos contribuintes você vai digitar? ");
		int qtdTaxpayers = sc.nextInt();
		
		for(int x = 0; x < qtdTaxpayers; x++) {
			TaxPayer taxPayer = new TaxPayer();
			System.out.printf("\nDigite os dados do %do contribuinte: %n",x+1);
			System.out.print("Renda anual com salário: ");
			taxPayer.setSalaryIncome(sc.nextDouble());
			sc.nextLine();
			System.out.print("Renda anual com prestação de serviço: ");
			taxPayer.setServicesIncome(sc.nextDouble());
			sc.nextLine();
			System.out.print("Renda anual com ganho de capital: ");
			taxPayer.setCapitalIncome(sc.nextDouble());
			sc.nextLine();
			System.out.print("Gastos médicos: ");
			taxPayer.setHealthSpending(sc.nextDouble());
			sc.nextLine();
			System.out.print("Gastos educacionais: ");
			taxPayer.setEducationSpending(sc.nextDouble());
			sc.nextLine();
			taxPayers.add(taxPayer);
		}
		
		report(taxPayers);
	}

	static void report(List<TaxPayer> taxPayers) {
		for(int x = 0;x<taxPayers.size(); x++){
			System.out.printf("\nResumo do %do contribuinte: %n",x+1);
			System.out.printf("Imposto bruto total: %.2f%n",taxPayers.get(x).grossTax());
			System.out.printf("Abatimento: %.2f%n",taxPayers.get(x).taxRebate());
			System.out.printf("Imposto devido: %.2f%n",taxPayers.get(x).netTax());
		}
	}
}
