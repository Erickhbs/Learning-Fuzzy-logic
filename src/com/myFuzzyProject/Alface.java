package com.myFuzzyProject;

import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class Alface {
	public static void main(String[] args) throws Exception {
		Scanner ler = new Scanner(System.in);
		float dias, peso, altura;
		
		String filename = "eficiencia.fcl"; //arquivo FCL
		FIS fis = FIS.load(filename, true); //carregamento

		if (fis == null) { //erro durante o carregamento do arquivo
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

	
		
		// Definicoes de variaveis de entrada FIS
		System.out.print("Quantos dias o alface tem desde o tempo de muda ao colhimento? ");
		dias = ler.nextFloat();
		System.out.print("Quanto pesava a planta inteira? ");
		peso = ler.nextFloat();
		System.out.print("Quanto mede as folhas baixas da planta? ");
		altura = ler.nextFloat();
		fb.setVariable("dias", dias);  
		fb.setVariable("peso", peso);  
		fb.setVariable("comprimento", altura);

		// Execucao do sistema
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("eficiencia").defuzzify();

		// Print ruleSet
		System.out.println(fb);
		System.out.println("A eficiencia desta solucao, a partir dos dados e: " + fb.getVariable("eficiencia").getValue());

	}

}
